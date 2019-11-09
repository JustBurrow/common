package kr.lul.common.util.composer;

import kr.lul.common.util.ComposeException;
import kr.lul.common.util.Composer;

import java.time.Instant;
import java.time.format.DateTimeFormatter;

/**
 * {@link Instant}용 컴포저.
 *
 * @author justburrow
 * @since 2018. 9. 23.
 */
public class InstantComposer implements Composer<Instant> {
  private DateTimeFormatter formatter;

  public InstantComposer() {
    this(DateTimeFormatter.ISO_INSTANT);
  }

  public InstantComposer(DateTimeFormatter formatter) {
    this.formatter = formatter;
  }

  public DateTimeFormatter getFormatter() {
    return this.formatter;
  }

  @Override
  public String compose(Instant instant) throws ComposeException {
    return null == instant
        ? null
        : this.formatter.format(instant);
  }
}
