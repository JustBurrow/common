package kr.lul.common.util.composer;

import kr.lul.common.util.ComposeException;
import kr.lul.common.util.Composer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static kr.lul.common.util.Arguments.notNull;

/**
 * @author justburrow
 * @since 2018. 9. 24.
 */
public class LocalDateTimeComposer implements Composer<LocalDateTime> {
  private DateTimeFormatter formatter;

  public LocalDateTimeComposer() {
    this(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
  }

  public LocalDateTimeComposer(DateTimeFormatter formatter) {
    notNull(formatter, "formatter");

    this.formatter = formatter;
  }

  public DateTimeFormatter getFormatter() {
    return this.formatter;
  }

  @Override
  public String compose(LocalDateTime localDateTime) throws ComposeException {
    return null == localDateTime
        ? null
        : localDateTime.format(this.formatter);
  }
}
