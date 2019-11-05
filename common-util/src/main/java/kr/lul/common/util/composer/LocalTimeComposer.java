package kr.lul.common.util.composer;

import kr.lul.common.util.ComposeException;
import kr.lul.common.util.Composer;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static kr.lul.common.util.Arguments.notNull;

/**
 * @author justburrow
 * @since 2018. 9. 24.
 */
public class LocalTimeComposer implements Composer<LocalTime> {
  private DateTimeFormatter formatter;

  public LocalTimeComposer() {
    this(DateTimeFormatter.ISO_LOCAL_TIME);
  }

  public LocalTimeComposer(DateTimeFormatter formatter) {
    notNull(formatter, "formatter");

    this.formatter = formatter;
  }

  public DateTimeFormatter getFormatter() {
    return this.formatter;
  }

  @Override
  public String compose(LocalTime localTime) throws ComposeException {
    return null == localTime
        ? null
        : localTime.format(this.formatter);
  }
}
