package kr.lul.common.util;

import java.time.Instant;
import java.time.ZoneId;

/**
 * 시스템
 *
 * @author justburrow
 * @since 2019/11/04
 */
public class SystemTimeProvider implements TimeProvider {
  @Override
  public ZoneId zoneId() {
    return ZoneId.systemDefault();
  }

  @Override
  public Instant now() {
    return Instant.now();
  }
}
