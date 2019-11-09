package kr.lul.common.util.parser;

import kr.lul.common.util.ParseException;
import kr.lul.common.util.Parser;

import java.time.OffsetTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static kr.lul.common.util.Arguments.notNull;

/**
 * @author justburrow
 * @since 2018. 9. 28.
 */
public class OffsetTimeParser implements Parser<OffsetTime> {
  private DateTimeFormatter formatter;

  public OffsetTimeParser() {
    this(DateTimeFormatter.ISO_OFFSET_TIME);
  }

  public OffsetTimeParser(DateTimeFormatter formatter) {
    notNull(formatter, "formatter");
    this.formatter = formatter;
  }

  public DateTimeFormatter getFormatter() {
    return this.formatter;
  }

  @Override
  public OffsetTime parse(String text) throws ParseException {
    try {
      return null == text
          ? null
          : OffsetTime.parse(text, this.formatter);
    } catch (DateTimeParseException e) {
      throw new ParseException(e);
    }
  }
}
