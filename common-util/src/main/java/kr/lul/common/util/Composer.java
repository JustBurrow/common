package kr.lul.common.util;

/**
 * 오브젝트를 문자열로 변환한다.
 *
 * @author justburrow
 * @since 2018. 9. 23.
 */
@FunctionalInterface
public interface Composer<S> {
  /**
   * 오브젝트를 문자열로 변환한다.
   *
   * @param source 원본 오브젝트.
   *
   * @return 오브젝트의 문자열. {@code source}가 {@code null}이면 {@code null}.
   *
   * @see ComposeException 문자열로 변환 실패.
   */
  String compose(S source) throws ComposeException;
}
