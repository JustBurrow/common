package kr.lul.common.util.composer;

import kr.lul.common.util.ComposeException;
import kr.lul.common.util.Composer;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

import static kr.lul.common.util.Arguments.notNull;

/**
 * @author justburrow
 * @see OffsetDateTime
 * @since 2018. 9. 24.
 */
public class OffsetDateTimeComposer implements Composer<OffsetDateTime> {
  private DateTimeFormatter formatter;

  public OffsetDateTimeComposer() {
    this(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
  }

  public OffsetDateTimeComposer(DateTimeFormatter formatter) {
    notNull(formatter, "formatter");

    this.formatter = formatter;
  }

  public DateTimeFormatter getConfig() {
    return this.formatter;
  }

  @Override
  public String compose(OffsetDateTime offsetDateTime) throws ComposeException {
    return null == offsetDateTime
        ? null
        : offsetDateTime.format(this.formatter);
  }
}
