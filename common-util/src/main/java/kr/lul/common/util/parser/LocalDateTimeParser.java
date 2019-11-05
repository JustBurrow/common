package kr.lul.common.util.parser;

import kr.lul.common.util.ParseException;
import kr.lul.common.util.Parser;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static kr.lul.common.util.Arguments.notNull;

/**
 * @author justburrow
 * @since 2018. 9. 28.
 */
public class LocalDateTimeParser implements Parser<LocalDateTime> {
  private DateTimeFormatter formatter;

  public LocalDateTimeParser() {
    this(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
  }

  public LocalDateTimeParser(DateTimeFormatter formatter) {
    notNull(formatter, "formatter");
    this.formatter = formatter;
  }

  public DateTimeFormatter getFormatter() {
    return this.formatter;
  }

  @Override
  public LocalDateTime parse(String text) throws ParseException {
    try {
      return null == text
          ? null
          : LocalDateTime.parse(text, this.formatter);
    } catch (DateTimeParseException e) {
      throw new ParseException(e);
    }
  }
}
