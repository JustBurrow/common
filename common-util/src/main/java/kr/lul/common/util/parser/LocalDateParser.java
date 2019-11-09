package kr.lul.common.util.parser;

import kr.lul.common.util.ParseException;
import kr.lul.common.util.Parser;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static kr.lul.common.util.Arguments.notNull;

/**
 * @author justburrow
 * @since 2018. 9. 28.
 */
public class LocalDateParser implements Parser<LocalDate> {
  private DateTimeFormatter formatter;

  public LocalDateParser() {
    this(DateTimeFormatter.ISO_LOCAL_DATE);
  }

  public LocalDateParser(DateTimeFormatter formatter) {
    notNull(formatter, "formatter");
    this.formatter = formatter;
  }

  public DateTimeFormatter getFormatter() {
    return this.formatter;
  }

  @Override
  public LocalDate parse(String text) throws ParseException {
    try {
      return null == text
          ? null
          : LocalDate.parse(text, this.formatter);
    } catch (DateTimeParseException e) {
      throw new ParseException(e);
    }
  }
}
