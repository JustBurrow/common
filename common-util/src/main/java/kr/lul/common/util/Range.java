package kr.lul.common.util;

/**
 * 어떤 범위를 지정하기 위한 타입.
 *
 * @author justburrow
 * @since 2019/11/16
 */
public interface Range<C extends Comparable<C>> {
  /**
   * @param comparee 비교 대상.
   *
   * @return
   */
  boolean isInclude(C comparee);
}
