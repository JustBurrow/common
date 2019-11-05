package kr.lul.common.util;

/**
 * 문자열을 해석해 목표 오브젝트의 클래스로 변환한다.
 *
 * @author justburrow
 * @since 2018. 9. 23.
 */
@FunctionalInterface
public interface Parser<T> {
  /**
   * 문자열을 목표 클래스의 오브젝트로 변환한다.
   *
   * @param text 문자열.
   *
   * @return 목표 오브젝트. {@code text}가 {@code null}이면 {@code null}.
   *
   * @throws ParseException 문자열 변환 실패.
   */
  T parse(String text) throws ParseException;
}
