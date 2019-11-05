package kr.lul.common.util.parser;

import kr.lul.common.util.ParseException;
import kr.lul.common.util.Parser;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static kr.lul.common.util.Arguments.notNull;

/**
 * @author justburrow
 * @since 2018. 9. 28.
 */
public class ZonedDateTimeParser implements Parser<ZonedDateTime> {
  private DateTimeFormatter formatter;

  public ZonedDateTimeParser() {
    this(DateTimeFormatter.ISO_ZONED_DATE_TIME);
  }

  public ZonedDateTimeParser(DateTimeFormatter formatter) {
    notNull(formatter, "formatter");
    this.formatter = formatter;
  }

  public DateTimeFormatter getFormatter() {
    return this.formatter;
  }

  @Override
  public ZonedDateTime parse(String text) throws ParseException {
    try {
      return null == text
          ? null
          : ZonedDateTime.parse(text, this.formatter);
    } catch (DateTimeParseException e) {
      throw new ParseException(e);
    }
  }
}
