package kr.lul.common.data;

import java.time.temporal.Temporal;

/**
 * 생성 시각 정보를 제공할 수 있는 오브젝트.
 *
 * @param <T> 시각 정보 타입.
 *
 * @author justburrow
 * @since 2019/11/24
 */
public interface Creatable<T extends Temporal> {
  /**
   * @return 생성 시각.
   */
  T getCreatedAt();
}
