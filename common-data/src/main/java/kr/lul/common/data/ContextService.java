package kr.lul.common.data;

/**
 * 실행 컨택스트를 관리하는 서비스.
 *
 * @author justburrow
 * @since 2019/11/24
 */
public interface ContextService<C extends Context<?>> {
  /**
   * 신규 발급.
   *
   * @return 실행 컨텍스트.
   *
   * @throws IllegalStateException 유효한 실행 컨텍스트가 있을 때.
   */
  C issue() throws IllegalStateException;

  /**
   * 현재 컨텍스트. 없으면 새로 생성한다.
   *
   * @return 현재 컨텍스트.
   */
  C get();

  /**
   * 현재 컨텍스트를 삭제한다.
   *
   * @return 유효한 컨텍스트가 없으면 {@code false}.
   */
  boolean clear();
}
