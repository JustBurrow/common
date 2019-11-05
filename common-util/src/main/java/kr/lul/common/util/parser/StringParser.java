package kr.lul.common.util.parser;

import kr.lul.common.util.ParseException;
import kr.lul.common.util.Parser;

/**
 * 사용하는 측에서 타입에 따라 분기를 할 필요 없도록 하기 위한 클래스.
 *
 * @author justburrow
 * @since 2018. 9. 28.
 */
public class StringParser implements Parser<String> {
  @Override
  public String parse(String text) throws ParseException {
    return text;
  }
}
