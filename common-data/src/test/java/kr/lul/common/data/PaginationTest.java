package kr.lul.common.data;

import org.junit.Test;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;
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
  public void test_new_with_negative1_totalCount() throws Exception {
    // GIVEN
    final int page = 0;
    final int limit = 10;
    final long totalCount = -1L;
    final List<String> content = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
    log.info("GIVEN - page={}, limit={}, totalCount={}, content={}", page, limit, totalCount, content);

    // WHEN & THEN
    assertThatThrownBy(() -> new Pagination<>(page, limit, totalCount, content))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("totalCount is negative : " + totalCount);
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
  public void test_new_with_empty() throws Exception {
    // GIVEN
    final int page = 0;
    final int limit = 10;
    final long totalCount = 0L;
    final List<String> content = List.of();
    log.info("GIVEN - page={}, limit={}, totalCount={}, content={}", page, limit, totalCount, content);

    // WHEN
    final Pagination<String> pagination = new Pagination<>(page, limit, totalCount, content);
    log.info("WHEN - pagination={}", pagination);

    // THEN
    assertThat(pagination)
        .extracting(Pagination::getPage, Pagination::getLimit, Pagination::getTotalCount, Pagination::getContent,
            Pagination::getCount, Pagination::getTotalPage,
            Pagination::isFirst, Pagination::isLast, Pagination::hasPre, Pagination::hasNext)
        .containsSequence(page, limit, totalCount, content,
            0, 0,
            true, true, false, false);
  }

  @Test
  public void test_new_with_1st_and_partial_content() throws Exception {
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
            Pagination::getCount, Pagination::getTotalPage,
            Pagination::isFirst, Pagination::isLast, Pagination::hasPre, Pagination::hasNext)
        .containsSequence(page, limit, totalCount, content,
            9, 1,
            true, true, false, false);
  }

  @Test
  public void test_new_with_1st_and_full_content() throws Exception {
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
            Pagination::getCount, Pagination::getTotalPage,
            Pagination::isFirst, Pagination::isLast, Pagination::hasPre, Pagination::hasNext)
        .containsSequence(page, limit, totalCount, content,
            10, 1,
            true, true, false, false);
  }

  @Test
  public void test_new_with_1st_page() throws Exception {
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
            Pagination::getCount, Pagination::getTotalPage,
            Pagination::isFirst, Pagination::isLast, Pagination::hasPre, Pagination::hasNext)
        .containsSequence(page, limit, totalCount, content,
            10, 2,
            true, false, false, true);
  }

  @Test
  public void test_new_with_last_page() throws Exception {
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
            Pagination::getCount, Pagination::getTotalPage,
            Pagination::isFirst, Pagination::isLast, Pagination::hasPre, Pagination::hasNext)
        .containsSequence(page, limit, totalCount, content,
            1, 2,
            false, true, true, false);
  }

  @Test
  public void test_new_with_middle_page() throws Exception {
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
            Pagination::getCount, Pagination::getTotalPage,
            Pagination::isFirst, Pagination::isLast, Pagination::hasPre, Pagination::hasNext)
        .containsSequence(page, limit, totalCount, content,
            5, 3,
            false, false, true, true);
  }

  @Test
  public void test_new_with_over_totalPage() throws Exception {
    // GIVEN
    final int page = Integer.MAX_VALUE;
    final int limit = 10;
    final long totalCount = 100L;
    final List<String> content = List.of();
    log.info("GIVEN - page={}, limit={}, totalCount={}, content={}", page, limit, totalCount, content);

    // WHEN
    final Pagination<String> pagination = new Pagination<>(page, limit, totalCount, content);
    log.info("WHEN - pagination={}", pagination);

    // THEN
    assertThat(pagination)
        .extracting(Pagination::getPage, Pagination::getLimit, Pagination::getTotalCount, Pagination::getContent,
            Pagination::getCount, Pagination::getTotalPage,
            Pagination::isFirst, Pagination::isLast, Pagination::hasPre, Pagination::hasNext)
        .containsSequence(page, limit, totalCount, content,
            0, 10,
            false, false, true, false);
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
    final Pagination<Integer> actual = pagination.map(Integer::parseInt);
    log.info("WHEN - actual={}", actual);

    // THEN
    assertThat(actual)
        .isNotNull()
        .extracting(Pagination::getPage, Pagination::getLimit, Pagination::getTotalCount, Pagination::getContent,
            Pagination::getCount, Pagination::getTotalPage,
            Pagination::isFirst, Pagination::isLast, Pagination::hasPre, Pagination::hasNext)
        .containsSequence(page, limit, totalCount, List.of(6, 7, 8, 9, 10),
            5, 3,
            false, false, true, true);
  }

  @Test
  public void test_block_with_page0_and_empty_data() throws Exception {
    // GIVEN
    final Pagination<String> pagination = new Pagination<>(0, 10, 0L, List.of());
    log.info("GIVEN - pagination={}", pagination);

    // WHEN & THEN
    assertThat(pagination)
        .extracting(Pagination::getPage, Pagination::getLimit, Pagination::getTotalCount, Pagination::getContent,
            Pagination::getTotalPage,
            Pagination::isFirst, Pagination::isLast, Pagination::hasPre, Pagination::hasNext,
            Pagination::getFirst, Pagination::getLast, Pagination::getPre, Pagination::getNext)
        .containsSequence(0, 10, 0L, new ArrayList<String>(),
            0,
            true, true, false, false,
            0, 0, 0, 0);
    assertThat(List.of(
        pagination.getBlock(10), pagination.getTotalBlock(10),
        pagination.isFirstBlock(10), pagination.isLastBlock(10),
        pagination.getBlockStartPage(10), pagination.getBlockEndPage(10),
        pagination.hasPreBlock(10), pagination.hasNextBlock(10),
        pagination.getPreBlockPage(10), pagination.getNextBlockPage(10)
    ))
        .containsExactly(
            0, 0,
            true, true,
            0, 0,
            false, false,
            0, 0);
  }

  /**
   * 한 페이지를 채우지 못하는 데이터가 있을 때 0 페이지 테스트.
   */
  @Test
  public void test_block_with_page0_and_partial_page() throws Exception {
    // GIVEN
    final int page = 0;
    final int limit = 5;
    final long totalCount = 4L;
    final List<String> content = range(1, (int) totalCount + 1).mapToObj(Integer::toString).collect(toList());
    log.info("GIVEN - page={}, limit={}, totalCount={}, content={}", page, limit, totalCount, content);

    // WHEN
    final Pagination<String> pagination = new Pagination<>(page, limit, totalCount, content);
    log.info("WHEN - pagination={}", pagination);

    // THEN
    assertThat(pagination)
        .extracting(Pagination::getPage, Pagination::getLimit, Pagination::getTotalCount, Pagination::getContent,
            Pagination::getTotalPage,
            Pagination::isFirst, Pagination::isLast, Pagination::hasPre, Pagination::hasNext,
            Pagination::getFirst, Pagination::getLast, Pagination::getPre, Pagination::getNext)
        .containsSequence(0, 5, 4L, List.of("1", "2", "3", "4"),
            1,
            true, true, false, false,
            0, 0, 0, 0);
    assertThat(List.of(
        pagination.getBlock(10), pagination.getTotalBlock(10),
        pagination.isFirstBlock(10), pagination.isLastBlock(10),
        pagination.getBlockStartPage(10), pagination.getBlockEndPage(10),
        pagination.hasPreBlock(10), pagination.hasNextBlock(10),
        pagination.getPreBlockPage(10), pagination.getNextBlockPage(10)
    ))
        .containsExactly(
            0, 1,
            true, true,
            0, 0,
            false, false,
            0, 0
        );
  }

  /**
   * 한 페이지만 채우는 데이터로 0 페이지 테스트.
   */
  @Test
  public void test_block_with_page0_and_single_page_data() throws Exception {
    // GIVEN
    final int page = 0;
    final int limit = 5;
    final long totalCount = 5L;
    final List<String> content = range(1, (int) totalCount + 1).mapToObj(Integer::toString).collect(toList());
    log.info("GIVEN - page={}, limit={}, totalCount={}, content={}", page, limit, totalCount, content);

    // WHEN
    final Pagination<String> pagination = new Pagination<>(page, limit, totalCount, content);
    log.info("WHEN - pagination={}", pagination);

    // THEN
    assertThat(pagination)
        .extracting(Pagination::getPage, Pagination::getLimit, Pagination::getTotalCount, Pagination::getContent,
            Pagination::getTotalPage,
            Pagination::isFirst, Pagination::isLast, Pagination::hasPre, Pagination::hasNext,
            Pagination::getFirst, Pagination::getLast, Pagination::getPre, Pagination::getNext)
        .containsSequence(0, 5, 5L, List.of("1", "2", "3", "4", "5"),
            1,
            true, true, false, false,
            0, 0, 0, 0);
    assertThat(List.of(
        pagination.getBlock(10), pagination.getTotalBlock(10),
        pagination.isFirstBlock(10), pagination.isLastBlock(10),
        pagination.getBlockStartPage(10), pagination.getBlockEndPage(10),
        pagination.hasPreBlock(10), pagination.hasNextBlock(10),
        pagination.getPreBlockPage(10), pagination.getNextBlockPage(10)
    ))
        .containsExactly(
            0, 1,
            true, true,
            0, 0,
            false, false,
            0, 0
        );
  }

  /**
   * 데이터가 없을 때, 1 이상의 페이지에 접근할 때.
   */
  @Test
  public void test_block_with_over_page_and_empty_data() throws Exception {
    // GIVEN
    final int page = 1;
    final int limit = 5;
    final long totalCount = 0L;
    final List<String> content = range(1, (int) totalCount + 1).mapToObj(Integer::toString).collect(toList());
    log.info("GIVEN - page={}, limit={}, totalCount={}, content={}", page, limit, totalCount, content);

    // WHEN
    final Pagination<String> pagination = new Pagination<>(page, limit, totalCount, content);
    log.info("WHEN - pagination={}", pagination);

    // THEN
    assertThat(pagination)
        .extracting(Pagination::getPage, Pagination::getLimit, Pagination::getTotalCount, Pagination::getContent,
            Pagination::getTotalPage,
            Pagination::isFirst, Pagination::isLast, Pagination::hasPre, Pagination::hasNext,
            Pagination::getFirst, Pagination::getLast, Pagination::getPre, Pagination::getNext)
        .containsSequence(page, limit, totalCount, List.of(),
            0,
            false, true, true, false,
            0, 0, 0, 1);
    assertThat(List.of(
        pagination.getBlock(10), pagination.getTotalBlock(10),
        pagination.isFirstBlock(10), pagination.isLastBlock(10),
        pagination.getBlockStartPage(10), pagination.getBlockEndPage(10),
        pagination.hasPreBlock(10), pagination.hasNextBlock(10),
        pagination.getPreBlockPage(10), pagination.getNextBlockPage(10)
    ))
        .containsExactly(
            0, 0,
            true, true,
            0, 0,
            false, false,
            0, 0
        );
  }

  /**
   * 중간 페이지 블록, 블록 내 중간 페이지.
   */
  @Test
  public void test_block_with_intermediate() throws Exception {
    // GIVEN
    final int page = 15;
    final int limit = 10;
    final long totalCount = 234L;
    final List<String> content = range(1 + page * limit, 1 + (page + 1) * limit)
                                     .mapToObj(Integer::toString)
                                     .collect(toList());
    log.info("GIVEN - page={}, limit={}, totalCount={}, content={}", page, limit, totalCount, content);

    // WHEN
    final Pagination<String> pagination = new Pagination<>(page, limit, totalCount, content);
    log.info("WHEN - pagination={}", pagination);

    // THEN
    assertThat(pagination)
        .extracting(Pagination::getPage, Pagination::getLimit, Pagination::getTotalCount, Pagination::getContent,
            Pagination::getTotalPage,
            Pagination::isFirst, Pagination::isLast, Pagination::hasPre, Pagination::hasNext,
            Pagination::getFirst, Pagination::getLast, Pagination::getPre, Pagination::getNext)
        .containsSequence(page, limit, totalCount, List.of("151", "152", "153", "154", "155", "156", "157", "158", "159", "160"),
            24,
            false, false, true, true,
            0, 23, 14, 16);
    assertThat(List.of(
        pagination.getBlock(10), pagination.getTotalBlock(10),
        pagination.isFirstBlock(10), pagination.isLastBlock(10),
        pagination.getBlockStartPage(10), pagination.getBlockEndPage(10),
        pagination.hasPreBlock(10), pagination.hasNextBlock(10),
        pagination.getPreBlockPage(10), pagination.getNextBlockPage(10)
    ))
        .containsExactly(
            1, 3,
            false, false,
            10, 19,
            true, true,
            9, 20
        );
  }
}
