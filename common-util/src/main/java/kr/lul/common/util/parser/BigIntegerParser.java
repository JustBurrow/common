package kr.lul.common.util.parser;

import kr.lul.common.util.ParseException;
import kr.lul.common.util.Parser;

import java.math.BigInteger;

/**
 * @author justburrow
 * @since 2018. 9. 28.
 */
public class BigIntegerParser implements Parser<BigInteger> {
  @Override
  public BigInteger parse(String text) throws ParseException {
    try {
      return null == text
          ? null
          : new BigInteger(text);
    } catch (NumberFormatException e) {
      throw new ParseException(e);
    }
  }
}
