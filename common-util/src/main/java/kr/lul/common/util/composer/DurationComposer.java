package kr.lul.common.util.composer;

import kr.lul.common.util.ComposeException;
import kr.lul.common.util.Composer;

import java.time.Duration;

/**
 * @author justburrow
 * @since 2018. 9. 24.
 */
public class DurationComposer implements Composer<Duration> {
  @Override
  public String compose(Duration duration) throws ComposeException {
    return null == duration
        ? null
        : duration.toString();
  }
}
