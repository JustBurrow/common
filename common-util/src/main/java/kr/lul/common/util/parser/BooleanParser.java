package kr.lul.common.util.parser;

import kr.lul.common.util.ParseException;
import kr.lul.common.util.Parser;

/**
 * @author justburrow
 * @since 2018. 9. 28.
 */
public class BooleanParser implements Parser<Boolean> {
  @Override
  public Boolean parse(String text) throws ParseException {
    return null == text
        ? null
        : Boolean.parseBoolean(text);
  }
}
