package kr.lul.common.data;

import java.io.Serializable;

/**
 * 반복 실행하는 로직에서 현재 실행의 정보(컨텍스트)를 제공한다.
 *
 * @param <ID> ID 타입.
 *
 * @author justburrow
 * @since 2019/11/24
 */
public interface Context<ID extends Serializable> extends Serializable {
  /**
   * @return 컨텍스트 ID.
   */
  ID id();

  <P extends Serializable> P put(String name, P value);

  Object get(String name);

  <P extends Serializable> P get(String name, Class<P> type);
}
