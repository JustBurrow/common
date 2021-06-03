package kr.lul.common.data;

/**
 * {@link Object#toString()}가 너무 복잡할 경우 대신 사용할 메서드를 제공한다.
 *
 * @author justburrow
 * @since 2021/06/03
 */
public interface SimpleString {
  /**
   * @return 간단한 문자열 표현.
   */
  String toSimpleString();
}