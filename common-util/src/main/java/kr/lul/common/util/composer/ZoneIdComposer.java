package kr.lul.common.util.composer;

import kr.lul.common.util.ComposeException;
import kr.lul.common.util.Composer;

import java.time.ZoneId;

/**
 * @author justburrow
 * @since 2018. 9. 24.
 */
public class ZoneIdComposer implements Composer<ZoneId> {
  @Override
  public String compose(ZoneId zoneId) throws ComposeException {
    return null == zoneId
        ? null
        : zoneId.toString();
  }
}
