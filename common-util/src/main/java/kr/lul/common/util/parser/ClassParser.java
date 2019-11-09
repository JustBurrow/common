package kr.lul.common.util.parser;

import kr.lul.common.util.ParseException;
import kr.lul.common.util.Parser;

import static kr.lul.common.util.Arguments.notEmpty;
import static kr.lul.common.util.JavaLangConstants.*;

/**
 * @author justburrow
 * @since 2018. 9. 18.
 */
public class ClassParser implements Parser<Class> {
  @Override
  public Class parse(String text) throws ParseException {
    if (null == text) {
      return null;
    }
    notEmpty(text, "text");

    // 기본 자료형
    switch (text) {
      case BOOLEAN_TYPE_NAME:
        return Boolean.TYPE;
      case BYTE_TYPE_NAME:
        return Byte.TYPE;
      case SHORT_TYPE_NAME:
        return Short.TYPE;
      case INTEGER_TYPE_NAME:
        return Integer.TYPE;
      case LONG_TYPE_NAME:
        return Long.TYPE;
      case FLOAT_TYPE_NAME:
        return Float.TYPE;
      case DOUBLE_TYPE_NAME:
        return Double.TYPE;
      case CHARACTER_TYPE_NAME:
        return Character.TYPE;
    }

    try {
      return Class.forName(text);
    } catch (ClassNotFoundException e) {
      throw new ParseException(e);
    }
  }
}
