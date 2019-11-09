package kr.lul.common.util.parser;

import kr.lul.common.util.ParseException;
import kr.lul.common.util.Parser;

import static java.lang.String.format;

/**
 * @author justburrow
 * @since 2018. 9. 28.
 */
public class CharacterParser implements Parser<Character> {
  @Override
  public Character parse(String text) throws ParseException {
    if (null == text) {
      return null;
    } else if (text.isEmpty()) {
      throw new ParseException("text is empty.");
    } else if (1 < text.length()) {
      throw new ParseException(format("too long text : %s", text));
    }

    return text.charAt(0);
  }
}
