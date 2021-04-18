package kr.lul.common.logging;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.Appender;
import ch.qos.logback.core.read.ListAppender;
import org.slf4j.LoggerFactory;

import java.util.function.Predicate;

import static kr.lul.common.util.Arguments.notNull;

/**
 * 유닛 테스트용 유틸리티.
 *
 * @author justburrow
 * @since 2021/03/26
 */
public abstract class TestUtils {
  /**
   * 해당 로거에 {@link ListAppender}를 추가한 후 반환한다.
   *
   * @param clazz 로거 클래스.
   *
   * @return 로거에 추가한 어펜더.
   */
  public static ListAppender<ILoggingEvent> addListAppender(final Class<?> clazz) {
    return addListAppender(notNull(clazz, "clazz").getName());
  }

  /**
   * 해당 로거에 {@link ListAppender}를 추가한 후 반환한다.
   *
   * @param name 로거 이름.
   *
   * @return 로거에 추가한 어펜더.
   */
  public static ListAppender<ILoggingEvent> addListAppender(final String name) {
    final Logger logger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(name);
    //noinspection SynchronizationOnLocalVariableOrMethodParameter
    synchronized (logger) {
      final ListAppender<ILoggingEvent> appender = new ListAppender<>();

      appender.start();
      logger.addAppender(appender);

      return appender;
    }
  }

  /**
   * 로거에서 어펜더를 제거한다.
   *
   * @param clazz    로거 클래스.
   * @param appender 로거에서 제거할 어펜더.
   *
   * @return {@code true} - 로거가 어펜더를 사용하고 있었을 때.
   */
  public static boolean removeAppender(final Class<?> clazz, final Appender<ILoggingEvent> appender) {
    return removeAppender(notNull(clazz, "clazz").getName(), notNull(appender, "appender"));
  }

  /**
   * 로거에서 어펜더를 제거한다.
   *
   * @param name     로거 이름.
   * @param appender 로거에서 제거할 어펜더.
   *
   * @return {@code true} - 로거가 어펜더를 사용하고 있었을 때.
   */
  public static boolean removeAppender(final String name, final Appender<ILoggingEvent> appender) {
    notNull(appender, "appender");

    final Logger logger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(name);
    return logger.detachAppender(appender);
  }

  /**
   * 로그 이벤트 중에서 조건에 맞는 첫번째 이벤트를 찾는다.
   *
   * @param appender  어펜더.
   * @param predicate 조건.
   *
   * @return 첫번째 로그 이벤트. 없으면 {@code null}.
   */
  public static ILoggingEvent findFirst(ListAppender<ILoggingEvent> appender, Predicate<ILoggingEvent> predicate) {
    return notNull(appender, "appender").list.stream()
               .filter(notNull(predicate, "predicate"))
               .findFirst()
               .orElse(null);
  }

  public static int count(ListAppender<ILoggingEvent> appender, Predicate<ILoggingEvent> predicate) {
    return (int) notNull(appender, "appender").list.stream()
                     .filter(notNull(predicate, "predicate"))
                     .count();
  }

  public TestUtils() {
    throw new UnsupportedOperationException();
  }
}
