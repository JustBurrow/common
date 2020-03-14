package kr.lul.common.data;

import org.junit.Test;
import org.slf4j.Logger;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2020/03/14
 */
public class PaginationTest {
  protected static final Logger log = getLogger(PaginationTest.class);

  @Test
  public void test_new_with_negative1_page() throws Exception {
    // GIVEN
    final int page = -1;
    final int limit = 10;
    final long totalCount = 10L;
    final List<String> content = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
    log.info("GIVEN - page={}, limit={}, totalCount={}, content={}", page, limit, totalCount, content);

    // WHEN & THEN
    assertThatThrownBy(() -> new Pagination<>(page, limit, totalCount, content))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("page is negative : " + page);
  }

  @Test
  public void test_new_with_0_limit() throws Exception {
    // GIVEN
    final int page = 0;
    final int limit = 0;
    final long totalCount = 10L;
    final List<String> content = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
    log.info("GIVEN - page={}, limit={}, totalCount={}, content={}", page, limit, totalCount, content);

    // WHEN & THEN
    assertThatThrownBy(() -> new Pagination<>(page, limit, totalCount, content))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("limit is not positive : " + limit);
  }

  @Test
  public void test_new_with_0_totalCount() throws Exception {
    // GIVEN
    final int page = 0;
    final int limit = 10;
    final long totalCount = 0L;
    final List<String> content = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
    log.info("GIVEN - page={}, limit={}, totalCount={}, content={}", page, limit, totalCount, content);

    // WHEN & THEN
    assertThatThrownBy(() -> new Pagination<>(page, limit, totalCount, content))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("totalCount is not positive : " + totalCount);
  }

  @Test
  public void test_new_with_too_many_content() throws Exception {
    // GIVEN
    final int page = 0;
    final int limit = 10;
    final long totalCount = 10L;
    final List<String> content = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11");
    log.info("GIVEN - page={}, limit={}, totalCount={}, content={}", page, limit, totalCount, content);

    // WHEN & THEN
    assertThatThrownBy(() -> new Pagination<>(page, limit, totalCount, content))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageStartingWith("too many data");
  }

  @Test
  public void test_new_1st_and_partial_content() throws Exception {
    // GIVEN
    final int page = 0;
    final int limit = 10;
    final long totalCount = 9L;
    final List<String> content = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9");
    log.info("GIVEN - page={}, limit={}, totalCount={}, content={}", page, limit, totalCount, content);

    // WHEN
    final Pagination<String> pagination = new Pagination<>(page, limit, totalCount, content);
    log.info("WHEN - pagination={}", pagination);

    // THEN
    assertThat(pagination)
        .extracting(Pagination::getPage, Pagination::getLimit, Pagination::getTotalCount, Pagination::getContent,
            Page::getCount, Page::getTotalPage,
            Page::isFirst, Page::isLast, Page::hasBefore, Page::hasNext)
        .containsSequence(page, limit, totalCount, content,
            9, 1,
            true, true, false, false);
  }

  @Test
  public void test_new_1st_and_full_content() throws Exception {
    // GIVEN
    final int page = 0;
    final int limit = 10;
    final long totalCount = 10L;
    final List<String> content = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
    log.info("GIVEN - page={}, limit={}, totalCount={}, content={}", page, limit, totalCount, content);

    // WHEN
    final Pagination<String> pagination = new Pagination<>(page, limit, totalCount, content);
    log.info("WHEN - pagination={}", pagination);

    // THEN
    assertThat(pagination)
        .extracting(Pagination::getPage, Pagination::getLimit, Pagination::getTotalCount, Pagination::getContent,
            Page::getCount, Page::getTotalPage,
            Page::isFirst, Page::isLast, Page::hasBefore, Page::hasNext)
        .containsSequence(page, limit, totalCount, content,
            10, 1,
            true, true, false, false);
  }

  @Test
  public void test_new_1st() throws Exception {
    // GIVEN
    final int page = 0;
    final int limit = 10;
    final long totalCount = 11L;
    final List<String> content = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
    log.info("GIVEN - page={}, limit={}, totalCount={}, content={}", page, limit, totalCount, content);

    // WHEN
    final Pagination<String> pagination = new Pagination<>(page, limit, totalCount, content);
    log.info("WHEN - pagination={}", pagination);

    // THEN
    assertThat(pagination)
        .extracting(Pagination::getPage, Pagination::getLimit, Pagination::getTotalCount, Pagination::getContent,
            Page::getCount, Page::getTotalPage,
            Page::isFirst, Page::isLast, Page::hasBefore, Page::hasNext)
        .containsSequence(page, limit, totalCount, content,
            10, 2,
            true, false, false, true);
  }

  @Test
  public void test_new_last() throws Exception {
    // GIVEN
    final int page = 1;
    final int limit = 10;
    final long totalCount = 11L;
    final List<String> content = List.of("1");
    log.info("GIVEN - page={}, limit={}, totalCount={}, content={}", page, limit, totalCount, content);

    // WHEN
    final Pagination<String> pagination = new Pagination<>(page, limit, totalCount, content);
    log.info("WHEN - pagination={}", pagination);

    // THEN
    assertThat(pagination)
        .extracting(Pagination::getPage, Pagination::getLimit, Pagination::getTotalCount, Pagination::getContent,
            Page::getCount, Page::getTotalPage,
            Page::isFirst, Page::isLast, Page::hasBefore, Page::hasNext)
        .containsSequence(page, limit, totalCount, content,
            1, 2,
            false, true, true, false);
  }

  @Test
  public void test_new_middle_page() throws Exception {
    // GIVEN
    final int page = 1;
    final int limit = 5;
    final long totalCount = 11L;
    final List<String> content = List.of("6", "7", "8", "9", "10");
    log.info("GIVEN - page={}, limit={}, totalCount={}, content={}", page, limit, totalCount, content);

    // WHEN
    final Pagination<String> pagination = new Pagination<>(page, limit, totalCount, content);
    log.info("WHEN - pagination={}", pagination);

    // THEN
    assertThat(pagination)
        .extracting(Pagination::getPage, Pagination::getLimit, Pagination::getTotalCount, Pagination::getContent,
            Page::getCount, Page::getTotalPage,
            Page::isFirst, Page::isLast, Page::hasBefore, Page::hasNext)
        .containsSequence(page, limit, totalCount, content,
            5, 3,
            false, false, true, true);
  }

  @Test
  public void test_map_with_null() throws Exception {
    // GIVEN
    final int page = 1;
    final int limit = 5;
    final long totalCount = 11L;
    final List<String> content = List.of("6", "7", "8", "9", "10");
    log.info("GIVEN - page={}, limit={}, totalCount={}, content={}", page, limit, totalCount, content);

    final Pagination<String> pagination = new Pagination<>(page, limit, totalCount, content);
    log.info("GIVEN - pagination={}", pagination);

    // WHEN & THEN
    assertThatThrownBy(() -> pagination.map(null))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("converter is null.");
  }

  @Test
  public void test_map() throws Exception {
    // GIVEN
    final int page = 1;
    final int limit = 5;
    final long totalCount = 11L;
    final List<String> content = List.of("6", "7", "8", "9", "10");
    log.info("GIVEN - page={}, limit={}, totalCount={}, content={}", page, limit, totalCount, content);
    final Pagination<String> pagination = new Pagination<>(page, limit, totalCount, content);
    log.info("GIVEN - pagination={}", pagination);

    // WHEN
    final Page<Integer> actual = pagination.map(Integer::parseInt);
    log.info("WHEN - actual={}", actual);

    // THEN
    assertThat(actual)
        .isNotNull()
        .extracting(Page::getPage, Page::getLimit, Page::getTotalCount, Page::getContent,
            Page::getCount, Page::getTotalPage,
            Page::isFirst, Page::isLast, Page::hasBefore, Page::hasNext)
        .containsSequence(page, limit, totalCount, List.of(6, 7, 8, 9, 10),
            5, 3,
            false, false, true, true);
  }
}
