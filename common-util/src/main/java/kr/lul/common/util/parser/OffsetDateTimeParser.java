package kr.lul.common.util.parser;

import kr.lul.common.util.ParseException;
import kr.lul.common.util.Parser;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static kr.lul.common.util.Arguments.notNull;

/**
 * @author justburrow
 * @since 2018. 9. 28.
 */
public class OffsetDateTimeParser implements Parser<OffsetDateTime> {
  private DateTimeFormatter formatter;

  public OffsetDateTimeParser() {
    this(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
  }

  public OffsetDateTimeParser(DateTimeFormatter formatter) {
    notNull(formatter, "formatter");
    this.formatter = formatter;
  }

  public DateTimeFormatter getFormatter() {
    return this.formatter;
  }

  @Override
  public OffsetDateTime parse(String text) throws ParseException {
    try {
      return null == text
          ? null
          : OffsetDateTime.parse(text, this.formatter);
    } catch (DateTimeParseException e) {
      throw new ParseException(e);
    }
  }
}
