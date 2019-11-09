package kr.lul.common.util.composer;

import kr.lul.common.util.ComposeException;
import kr.lul.common.util.Composer;

import java.time.OffsetTime;
import java.time.format.DateTimeFormatter;

import static kr.lul.common.util.Arguments.notNull;

/**
 * @author justburrow
 * @since 2018. 9. 28.
 */
public class OffsetTimeComposer implements Composer<OffsetTime> {
  private DateTimeFormatter formatter;

  public OffsetTimeComposer() {
    this(DateTimeFormatter.ISO_OFFSET_TIME);
  }

  public OffsetTimeComposer(DateTimeFormatter formatter) {
    notNull(formatter, "formatter");
    this.formatter = formatter;
  }

  public DateTimeFormatter getFormatter() {
    return this.formatter;
  }

  @Override
  public String compose(OffsetTime offsetTime) throws ComposeException {
    return null == offsetTime
        ? null
        : offsetTime.format(this.formatter);
  }
}
