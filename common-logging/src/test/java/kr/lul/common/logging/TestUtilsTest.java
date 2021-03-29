package kr.lul.common.logging;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static ch.qos.logback.classic.Level.*;
import static kr.lul.common.logging.TestUtils.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2021/03/26
 */
class TestUtilsTest {
  private static final Logger LOGGER = getLogger(TestUtilsTest.class);

  @Test
  void test_addListAppender_with_null() {
    assertThatThrownBy(() -> TestUtils.addListAppender((String) null))
        .isInstanceOf(IllegalArgumentException.class);

    assertThatThrownBy(() -> addListAppender((Class<?>) null))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("clazz is null.");
  }

  //@Test
  void test_listAppender_with_empty_name() {
    TestUtils.addListAppender("");
  }

  static class A {
    private static final Logger log = getLogger(A.class);

    void foo() {
      log.warn("#foo");
    }

    void foo2() {
      log.info("#foo2");
      log.info("#foo2");
    }
  }

  static class B {
    private static final Logger log = getLogger(B.class);

    void bar() {
      log.warn("#bar");
    }
  }

  @Test
  void test_addListAppender() {
    // GIVEN
    var a = new A();

    // WHEN
    ListAppender<ILoggingEvent> appender1 = addListAppender(A.class);
    ListAppender<ILoggingEvent> appender2 = TestUtils.addListAppender(A.class.getName());

    a.foo();

    // THEN
    assertThat(appender1.list
                   .stream()
                   .filter(it -> it.getLevel() == WARN && it.getMessage().equals("#foo"))
                   .findFirst()
                   .orElse(null)
    )
        .isNotNull();

    assertThat(appender2.list
                   .stream()
                   .filter(it -> it.getLevel() == WARN && it.getMessage().equals("#foo"))
                   .findFirst()
                   .orElse(null)
    )
        .isNotNull();

    // CLEANUP
    removeAppender(A.class, appender1);
    removeAppender(A.class, appender2);
  }

  @Test
  void test_addListAppender_with_other_logger() {
    // GIVEN
    var a = new A();

    // WHEN
    ListAppender<ILoggingEvent> appender1 = addListAppender(B.class);
    ListAppender<ILoggingEvent> appender2 = TestUtils.addListAppender(B.class.getName());

    a.foo();

    // THEN
    assertThat(appender1.list
                   .stream()
                   .filter(it -> it.getLevel() == WARN && it.getMessage().equals("#foo"))
                   .findFirst()
                   .orElse(null)
    )
        .isNull();

    assertThat(appender2.list
                   .stream()
                   .filter(it -> it.getLevel() == WARN && it.getMessage().equals("#foo"))
                   .findFirst()
                   .orElse(null)
    )
        .isNull();

    // CLEANUP
    removeAppender(B.class, appender1);
    removeAppender(B.class, appender2);
  }

  @Test
  void test_removeAppender_with_illegal_args() {
    assertThatThrownBy(() -> removeAppender((Class<?>) null, new ListAppender<>()))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("clazz is null.");
    assertThatThrownBy(() -> removeAppender((String) null, new ListAppender<>()))
        .isInstanceOf(IllegalArgumentException.class);

    assertThatThrownBy(() -> removeAppender(A.class, null))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("appender is null.");
  }

  @Test
  void test_removeAppender() throws Exception {
    // GIVEN
    var a = new A();
    ListAppender<ILoggingEvent> appender = addListAppender(A.class);
    a.foo();
    List<ILoggingEvent> expected = Collections.unmodifiableList(appender.list);
    LOGGER.info("[GIVEN] expected={}, expected.size={}", expected, expected.size());

    // WHEN
    boolean b = removeAppender(A.class, appender);
    LOGGER.info("[WHEN] b={}", b);

    a.foo();

    // THEN
    assertThat(b)
        .isTrue();
    assertThat(appender.list)
        .containsExactlyElementsOf(expected);

    // CLEANUP
    removeAppender(A.class, appender);
  }

  @Test
  void test_removeAppender_with_other_class() {
    // GIVEN
    var a = new A();
    ListAppender<ILoggingEvent> aAppender = addListAppender(A.class);
    a.foo();

    var b = new B();
    ListAppender<ILoggingEvent> bAppender = addListAppender(B.class);

    // WHEN & THEN
    assertThat(removeAppender(B.class, aAppender))
        .isFalse();

    // & THEN
    b.bar();
    assertThat(bAppender.list)
        .hasSize(1);
    assertThat(bAppender.list.get(0))
        .extracting(ILoggingEvent::getLevel, ILoggingEvent::getMessage)
        .containsSequence(WARN, "#bar");

    // CLEANUP
    removeAppender(A.class, aAppender);
    removeAppender(B.class, bAppender);
  }

  @SuppressWarnings("ResultOfMethodCallIgnored")
  @Test
  void test_findFirst_with_illegal() {
    assertThatThrownBy(() -> findFirst(null, it -> false))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("appender is null.");

    assertThatThrownBy(() -> findFirst(new ListAppender<>(), null))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("predicate is null.");
  }

  @Test
  void test_findFirst() {
    // GIVEN
    A a = new A();

    ListAppender<ILoggingEvent> appender = addListAppender(A.class);
    a.foo();
    a.foo2();

    // WHEN
    ILoggingEvent l1 = findFirst(appender, it -> it.getLevel() == TRACE);
    ILoggingEvent l2 = findFirst(appender, it -> it.getLevel() == INFO);
    ILoggingEvent l3 = findFirst(appender, it -> it.getLevel() == WARN);
    LOGGER.info("WHEN - l1={}, l2={}, l3={}", l1, l2, l3);

    // THEN
    assertThat(l1)
        .isNull();
    assertThat(l2)
        .isNotNull()
        .extracting(ILoggingEvent::getMessage)
        .isEqualTo("#foo2");
    assertThat(l3)
        .isNotNull()
        .extracting(ILoggingEvent::getMessage)
        .isEqualTo("#foo");

    // CLEANUP
    removeAppender(A.class, appender);
  }

  @Test
  void test_count_with_null() {
    assertThatThrownBy(() -> count(null, null))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("appender is null.");
    assertThatThrownBy(() -> count(null, it -> true))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("appender is null.");
    assertThatThrownBy(() -> count(new ListAppender<>(), null))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("predicate is null.");
  }

  @Test
  void test_count() {
    // GIVEN
    int count = ThreadLocalRandom.current().nextInt(100, 1000);
    LOGGER.info("[GIVEN] count={}", count);
    A a = new A();
    ListAppender<ILoggingEvent> appender = addListAppender(A.class);

    for (int i = 0; i < count; i++) {
      a.foo();
      a.foo2();
    }

    // WHEN
    int wCnt = count(appender, it -> WARN == it.getLevel());
    int iCnt = count(appender, it -> INFO == it.getLevel());
    int tCnt = count(appender, it -> TRACE == it.getLevel());
    LOGGER.info("[WHEN] wCnt={}, iCnt={}, tCnt={}", wCnt, iCnt, tCnt);

    // THEN
    assertThat(wCnt)
        .isEqualTo(count);
    assertThat(iCnt)
        .isEqualTo(count * 2);
    assertThat(tCnt)
        .isEqualTo(0);

    // CLEANUP
    removeAppender(A.class, appender);
  }
}
