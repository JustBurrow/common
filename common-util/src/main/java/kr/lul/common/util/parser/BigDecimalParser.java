package kr.lul.common.util.parser;

import kr.lul.common.util.ParseException;
import kr.lul.common.util.Parser;

import java.math.BigDecimal;

/**
 * @author justburrow
 * @since 2018. 9. 28.
 */
public class BigDecimalParser implements Parser<BigDecimal> {
  @Override
  public BigDecimal parse(String text) throws ParseException {
    try {
      return null == text
          ? null
          : new BigDecimal(text);
    } catch (NumberFormatException e) {
      throw new ParseException(e);
    }
  }
}
