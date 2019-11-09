package kr.lul.common.util.parser;

import kr.lul.common.util.ParseException;
import kr.lul.common.util.Parser;

import java.time.Duration;
import java.time.format.DateTimeParseException;

/**
 * @author justburrow
 * @since 2018. 9. 28.
 */
public class DurationParser implements Parser<Duration> {
  @Override
  public Duration parse(String text) throws ParseException {
    try {
      return null == text
          ? null
          : Duration.parse(text);
    } catch (DateTimeParseException e) {
      throw new ParseException(e);
    }
  }
}
