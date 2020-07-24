package kr.lul.common.util;

import org.junit.Test;
import org.slf4j.Logger;

import java.util.List;

import static kr.lul.common.util.ListUtils.subList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2020/07/24
 */
public class ListUtilsTest {
  private static final Logger log = getLogger(ListUtilsTest.class);

  @Test
  public void test_subList_with_illegal_args() throws Exception {
    assertThatThrownBy(() -> subList(null, 0, 0))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  public void test_subList() throws Exception {
    // GIVEN
    final List<String> list = List.of("a", "b", "c");
    log.info("GIVEN - list={}", list);

    // WHEN
    List<String> subList = subList(list, 0, 0);
    log.info("WHEN - subList={}", subList);

    // THEN
    assertThat(subList)
        .containsExactly();

    // WHEN
    subList = subList(list, 0, 1);
    log.info("WHEN - subList={}", subList);

    // THEN
    assertThat(subList)
        .containsExactly("a");

    // WHEN
    subList = subList(list, 0, 2);
    log.info("WHEN - subList={}", subList);

    // THEN
    assertThat(subList)
        .containsExactly("a", "b");

    // WHEN
    subList = subList(list, 0, 3);
    log.info("WHEN - subList={}", subList);

    // THEN
    assertThat(subList)
        .containsExactly("a", "b", "c");

    // WHEN
    subList = subList(list, 0, 4);
    log.info("WHEN - subList={}", subList);

    // THEN
    assertThat(subList)
        .containsExactly("a", "b", "c");
  }
}
