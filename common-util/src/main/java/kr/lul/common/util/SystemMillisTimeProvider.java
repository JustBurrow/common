package kr.lul.common.util;

import java.time.Instant;
import java.time.ZoneId;

/**
 * @author justburrow
 * @since 2019/12/15
 */
public class SystemMillisTimeProvider implements TimeProvider {
  @Override
  public ZoneId zoneId() {
    return ZoneId.systemDefault();
  }

  @Override
  public Instant now() {
    return Instant.ofEpochMilli(System.currentTimeMillis());
  }
}
