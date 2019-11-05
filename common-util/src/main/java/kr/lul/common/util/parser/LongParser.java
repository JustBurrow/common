package kr.lul.common.util.parser;

import kr.lul.common.util.ParseException;
import kr.lul.common.util.Parser;

/**
 * @author justburrow
 * @since 2018. 9. 28.
 */
public class LongParser implements Parser<Long> {
  @Override
  public Long parse(String text) throws ParseException {
    try {
      return null == text
          ? null
          : Long.parseLong(text);
    } catch (NumberFormatException e) {
      throw new ParseException(e);
    }
  }
}
