package kr.lul.common.util.parser;

import kr.lul.common.util.ParseException;
import kr.lul.common.util.Parser;

import java.time.Instant;
import java.time.format.DateTimeParseException;

/**
 * @author justburrow
 * @since 2018. 9. 28.
 */
public class InstantParser implements Parser<Instant> {
  @Override
  public Instant parse(String text) throws ParseException {
    try {
      return null == text
          ? null
          : Instant.parse(text);
    } catch (DateTimeParseException e) {
      throw new ParseException(e);
    }
  }
}
