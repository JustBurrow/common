package kr.lul.common.util;

import java.time.Instant;

/**
 * UTC milliseconds 단위의 정밀도로 시각정보를 제공한다.
 *
 * @author justburrow
 * @since 2019/11/04
 */
public class MillisSystemTimeProvider extends SystemTimeProvider {
  @Override
  public Instant now() {
    return Instant.ofEpochMilli(System.currentTimeMillis());
  }
}
