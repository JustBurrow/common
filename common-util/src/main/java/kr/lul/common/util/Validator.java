package kr.lul.common.util;

/**
 * 인스턴스를 검증한다.
 *
 * @param <T> 검증할 타입.
 *
 * @author justburrow
 * @since 2019/11/16
 */
public interface Validator<T> {
  /**
   * 대상을 검증한다. 문제가 있으면 예외를 던진다.
   *
   * @param target 검증할 대상.
   *
   * @return {@code target} 인스턴스.
   *
   * @throws ValidationException 대상에 문제가 있을 때.
   */
  T validate(T target) throws ValidationException;
}
