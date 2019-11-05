package kr.lul.common.util.parser;

import kr.lul.common.util.ParseException;
import kr.lul.common.util.Parser;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static kr.lul.common.util.Arguments.notNull;

/**
 * @author justburrow
 * @since 2018. 9. 28.
 */
public class LocalTimeParser implements Parser<LocalTime> {
  private DateTimeFormatter formatter;

  public LocalTimeParser() {
    this(DateTimeFormatter.ISO_LOCAL_TIME);
  }

  public LocalTimeParser(DateTimeFormatter formatter) {
    notNull(formatter, "formatter");
    this.formatter = formatter;
  }

  public DateTimeFormatter getFormatter() {
    return this.formatter;
  }

  @Override
  public LocalTime parse(String text) throws ParseException {
    try {
      return null == text
          ? null
          : LocalTime.parse(text, this.formatter);
    } catch (DateTimeParseException e) {
      throw new ParseException(e);
    }
  }
}
