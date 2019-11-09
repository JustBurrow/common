package kr.lul.common.util.composer;

import kr.lul.common.util.ComposeException;
import kr.lul.common.util.Composer;

import java.util.Arrays;

import static kr.lul.common.util.JavaLangConstants.*;

/**
 * {@link Object#toString()} 대용 컴포저.
 *
 * TODO 배열을 다룰 때, 구분자나 배열의 시작/끝 표시를 설정할 수 있는 방법.
 * TODO 문자열 배열을 다룰 때, 구분자를 포함하고 있는 경우.
 *
 * @author justburrow
 * @see Object#toString()
 * @since 2018. 9. 20.
 */
public class ToStringComposer implements Composer<Object> {
  public String compose(boolean b) {
    return Boolean.toString(b);
  }

  public String compose(byte b) {
    return Byte.toString(b);
  }

  public String compose(short s) {
    return Short.toString(s);
  }

  public String compose(int i) {
    return Integer.toString(i);
  }

  public String compose(long l) {
    return Long.toString(l);
  }

  public String compose(float f) {
    return Float.toString(f);
  }

  public String compose(double d) {
    return Double.toString(d);
  }

  public String compose(char c) {
    return Character.toString(c);
  }

  public String compose(String string) {
    return string;
  }

  public String compose(boolean[] array) {
    return null == array
        ? null
        : Arrays.toString(array);
  }

  public String compose(byte[] array) {
    return null == array
        ? null
        : Arrays.toString(array);
  }

  public String compose(short[] array) {
    return null == array
        ? null
        : Arrays.toString(array);
  }

  public String compose(int[] array) {
    return null == array
        ? null
        : Arrays.toString(array);
  }

  public String compose(long[] array) {
    return null == array
        ? null
        : Arrays.toString(array);
  }

  public String compose(float[] array) {
    return null == array
        ? null
        : Arrays.toString(array);
  }

  public String compose(double[] array) {
    return null == array
        ? null
        : Arrays.toString(array);
  }

  public String compose(char[] array) {
    return null == array
        ? null
        : Arrays.toString(array);
  }

  public <T> String compose(T[] array) {
    return null == array
        ? null
        : Arrays.toString(array);
  }

  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // kr.lul.commons.util.Composer
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  @Override
  public String compose(Object source) throws ComposeException {
    if (null == source) {
      return null;
    }

    switch (source.getClass().getName()) {
      case BOOLEAN_TYPE_ARRAY_CLASS_NAME:
        return compose((boolean[]) source);
      case BYTE_TYPE_ARRAY_CLASS_NAME:
        return compose((byte[]) source);
      case SHORT_TYPE_ARRAY_CLASS_NAME:
        return compose((short[]) source);
      case INTEGER_TYPE_ARRAY_CLASS_NAME:
        return compose((int[]) source);
      case LONG_TYPE_ARRAY_CLASS_NAME:
        return compose((long[]) source);
      case FLOAT_TYPE_ARRAY_CLASS_NAME:
        return compose((float[]) source);
      case DOUBLE_TYPE_ARRAY_CLASS_NAME:
        return compose((double[]) source);
      case CHARACTER_TYPE_ARRAY_CLASS_NAME:
        return compose((char[]) source);
      default:
        return source.toString();
    }
  }
}
