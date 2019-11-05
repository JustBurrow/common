package kr.lul.common.util.composer;

import kr.lul.common.util.ComposeException;
import kr.lul.common.util.Composer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static kr.lul.common.util.Arguments.notNull;

/**
 * @author justburrow
 * @since 2018. 9. 24.
 */
public class LocalDateComposer implements Composer<LocalDate> {
  private DateTimeFormatter formatter;

  public LocalDateComposer() {
    this(DateTimeFormatter.ISO_LOCAL_DATE);
  }

  public LocalDateComposer(DateTimeFormatter formatter) {
    notNull(formatter, "formatter");

    this.formatter = formatter;
  }

  public DateTimeFormatter getFormatter() {
    return this.formatter;
  }

  @Override
  public String compose(LocalDate localDate) throws ComposeException {
    return null == localDate
        ? null
        : localDate.format(this.formatter);
  }
}
