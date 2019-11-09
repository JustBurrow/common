package kr.lul.common.util.parser;

import kr.lul.common.util.ParseException;
import kr.lul.common.util.Parser;

import java.time.Period;
import java.time.format.DateTimeParseException;

/**
 * @author justburrow
 * @since 2018. 9. 28.
 */
public class PeriodParser implements Parser<Period> {
  @Override
  public Period parse(String text) throws ParseException {
    try {
      return null == text
          ? null
          : Period.parse(text);
    } catch (DateTimeParseException e) {
      throw new ParseException(e);
    }
  }
}
