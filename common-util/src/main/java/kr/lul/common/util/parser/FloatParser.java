package kr.lul.common.util.parser;

import kr.lul.common.util.ParseException;
import kr.lul.common.util.Parser;

/**
 * @author justburrow
 * @since 2018. 9. 28.
 */
public class FloatParser implements Parser<Float> {
  @Override
  public Float parse(String text) throws ParseException {
    try {
      return null == text
          ? null
          : Float.parseFloat(text);
    } catch (NumberFormatException e) {
      throw new ParseException(e);
    }
  }
}
