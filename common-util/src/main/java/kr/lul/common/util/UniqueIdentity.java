package kr.lul.common.util;

import java.net.URI;

/**
 * 독립적으로 구분 가능한 인스턴스.
 *
 * @author justburrow
 * @since 2020/02/06
 */
public interface UniqueIdentity {
  /**
   * @return 인스턴스의 URI.
   */
  URI uri();
}
