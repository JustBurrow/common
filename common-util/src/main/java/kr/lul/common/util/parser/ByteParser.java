package kr.lul.common.util.parser;

import kr.lul.common.util.ParseException;
import kr.lul.common.util.Parser;

/**
 * @author justburrow
 * @since 2018. 9. 28.
 */
public class ByteParser implements Parser<Byte> {
  @Override
  public Byte parse(String text) throws ParseException {
    try {
      return null == text
          ? null
          : Byte.parseByte(text);
    } catch (NumberFormatException e) {
      throw new ParseException(e);
    }
  }
}
