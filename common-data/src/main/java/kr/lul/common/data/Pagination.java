package kr.lul.common.data;

import kr.lul.common.util.Maths;

import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;
import static kr.lul.common.util.Arguments.notNull;
import static kr.lul.common.util.Arguments.positive;

/**
 * {@code org.springframework.data.domain.Slice} 대체 인터페이스.
 *
 * @param <T> 데이터 타입.
 *
 * @author justburrow
 * @since 2020/03/14
 */
public interface Pagination<T> {
  /**
   * @return 현재 페이지. 0-based.
   */
  int getPage();

  /**
   * @return 현재 페이지의 데이터 수.
   */
  default int getCount() {
    return getContent().size();
  }

  /**
   * @return 한 페이지의 최대 데이터 수.
   */
  int getLimit();

  /**
   * @return 현재 페이지의 데이터.
   */
  List<T> getContent();

  /**
   * @return 전체 페이지 수.
   */
  default int getTotalPage() {
    long page = getTotalCount() / getLimit();
    if (0 < getTotalCount() % getLimit())
      page++;
    return (int) page;
  }

  /**
   * @return 전체 데이터 수.
   */
  long getTotalCount();

  /**
   * @return 첫 페이지이면 {@code true}.
   */
  default boolean isFirst() {
    return 0 == getPage();
  }

  /**
   * @return 마지막 페이지이면 {@code true}.
   */
  default boolean isLast() {
    return 0 == getTotalPage() || getPage() == getTotalPage() - 1;
  }

  /**
   * @return 첫 페이지. 0-based.
   */
  default int getFirst() {
    return 0;
  }

  /**
   * @return 마지막 페이지. 0-based.
   */
  default int getLast() {
    return Math.max(0, getTotalPage() - 1);
  }

  /**
   * @return 앞 페이지가 있으면 {@code true}.
   */
  default boolean hasPre() {
    return 0 < getPage();
  }

  /**
   * @return 앞 페이지. 앞 페이지가 없으면 현재 페이지 번호.
   */
  default int getPre() {
    return hasPre()
               ? getPage() - 1
               : getPage();
  }

  /**
   * @return 다음 페이지가 있으면 {@code true}.
   */
  default boolean hasNext() {
    return getPage() < getTotalPage() - 1;
  }

  /**
   * @return 다음 페이지. 앞 페이지가 없으면 현재 페이지 번호.
   */
  default int getNext() {
    return hasNext()
               ? getPage() + 1
               : getPage();
  }

  /**
   * 자료형 변환한 인스턴스를 반환한다.
   *
   * @param converter 자료형 변환 함수.
   * @param <R>       타겟 자료형.
   *
   * @return 자료형이 변환된 인스턴스.
   */
  default <R> Pagination<R> map(final Function<? super T, ? extends R> converter) {
    notNull(converter, "converter");
    return new PaginationImpl<>(getPage(), getLimit(), getTotalCount(), getContent().stream().map(converter).collect(toList()));
  }

  /**
   * @param size 한 블록에 들어가는 페이지 수.
   *
   * @return 페이지 블록 번호. 0-based.
   */
  default int getBlock(final int size) {
    positive(size, "size");
    return getPage() / size;
  }

  /**
   * @param size 한 블록에 들어가는 페이지 수.
   *
   * @return 전체 블록 수.
   */
  default int getTotalBlock(final int size) {
    positive(size, "size");
    int block = getTotalPage() / size;
    if (0 < getTotalPage() % size)
      block++;
    return block;
  }

  /**
   * @param size 한 블록에 들어가는 페이지 수.
   *
   * @return 첫번째 블록이면 {@code true}.
   */
  default boolean isFirstBlock(final int size) {
    return 0 == getBlock(size);
  }

  /**
   * @param size 한 블록에 들어가는 페이지 수.
   *
   * @return 마지막 블록이면 {@code true}.
   */
  default boolean isLastBlock(final int size) {
    return getBlock(size) == Math.max(getTotalBlock(size) - 1, 0);
  }

  /**
   * @param size 한 블록에 들어가는 페이지 수.
   *
   * @return 블록 시작 페이지 번호(포함). 0-based.
   */
  default int getBlockStartPage(final int size) {
    return getBlock(size) * size;
  }

  /**
   * @param size 한 블록에 들어가는 페이지 수.
   *
   * @return 블록 마지막 페이지 번호(포함).
   */
  default int getBlockEndPage(final int size) {
    positive(size, "size");
    return 0 == getTotalPage()
               ? 0
               : Maths.min(getBlockStartPage(size) + size - 1, getTotalPage() - 1);
  }

  /**
   * @param size 한 블록에 들어가는 페이지 수.
   *
   * @return 앞 블록이 있으면 {@code true}.
   */
  default boolean hasPreBlock(final int size) {
    return 0 < getBlock(size);
  }

  /**
   * @param size 한 블록에 들어가는 페이지 수.
   *
   * @return 다음 블록이 있으면 {@code true}.
   */
  default boolean hasNextBlock(final int size) {
    return getBlock(size) < getTotalBlock(size) - 1;
  }

  /**
   * @param size 한 블록에 들어가는 페이지 수.
   *
   * @return 이전 블록의 대표 페이지 번호. 0-based. 이전 블록이 없으면 현재 블록의 첫 페이지 번호.
   */
  default int getPreBlockPage(final int size) {
    positive(size, "size");
    return isFirstBlock(size)
               ? getBlockStartPage(size)
               : getBlockStartPage(size) - 1;
  }

  /**
   * @param size 한 블록에 들어가는 페이지 수.
   *
   * @return 다음 블록의 대표 페이지 번호. 다음 블록이 없으면 현재 블록의 마지막 페이지 번호.
   */
  default int getNextBlockPage(final int size) {
    positive(size, "size");

    return isLastBlock(size)
               ? getBlockEndPage(size)
               : getBlockEndPage(size) + 1;
  }
}
