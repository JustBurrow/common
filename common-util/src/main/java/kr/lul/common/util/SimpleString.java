package kr.lul.common.util;

/**
 * {@link Object#toString()}가 지나치게 복잡해질 경우 대안으로 사용.
 *
 * @author justburrow
 * @since 2020/02/05
 */
public interface SimpleString {
  /**
   * @return 인스턴스를 표현하는 간단한 문자열.
   */
  String toSimpleString();
}
