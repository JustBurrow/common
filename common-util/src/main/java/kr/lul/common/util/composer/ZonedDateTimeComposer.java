package kr.lul.common.util.composer;

import kr.lul.common.util.ComposeException;
import kr.lul.common.util.Composer;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static kr.lul.common.util.Arguments.notNull;

/**
 * @author justburrow
 * @see ZonedDateTime
 * @since 2018. 9. 24.
 */
public class ZonedDateTimeComposer implements Composer<ZonedDateTime> {
  private DateTimeFormatter formatter;

  public ZonedDateTimeComposer() {
    this(DateTimeFormatter.ISO_ZONED_DATE_TIME);
  }

  public ZonedDateTimeComposer(DateTimeFormatter formatter) {
    notNull(formatter, "formatter");

    this.formatter = formatter;
  }

  public DateTimeFormatter getFormatter() {
    return this.formatter;
  }

  @Override
  public String compose(ZonedDateTime zonedDateTime) throws ComposeException {
    return null == zonedDateTime
        ? null
        : zonedDateTime.format(this.formatter);
  }
}
