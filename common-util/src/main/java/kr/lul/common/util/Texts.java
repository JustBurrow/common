package kr.lul.common.util;

import static java.lang.String.format;
import static kr.lul.common.util.Arguments.notNull;

/**
 * 문자열 유틸리티.
 *
 * @author justburrow
 * @since 2019/11/04
 */
public abstract class Texts {
  public static final char ELLIPSIS_CHARACTER = '\u2026';

  /**
   * 문자열을 따옴표로 묶는다.
   *
   * @param text 원본 문자열.
   *
   * @return {@code null}이면 {@code null}, {@code null}이 아니면 따옴표로 묶은 문자열을 반환한다.
   */
  public static String singleQuote(final String text) {
    return null == text
               ? null
               : format("'%s'", text);
  }

  /**
   * 문자열을 쌍따옴표로 묶는다.
   *
   * @param text 원본 문자열.
   *
   * @return {@code null}이면 {@code null}, {@code null}이 아니면 쌍따옴표로 묶은 문자열을 반환한다.
   */
  public static String doubleQuote(final String text) {
    return null == text
               ? null
               : format("\"%s\"", text);
  }

  /**
   * 긴 문자열의 앞부분을 반환한다.
   *
   * @param text 문자열.
   * @param max  잘라낸 문자열의 최대 길이.
   *
   * @return 문자열의 앞부분.
   */
  public static String head(final String text, final int max) {
    if (1 >= max)
      throw new IllegalArgumentException("too small max.");

    if (null == text)
      return null;

    return text.length() <= max
               ? text
               : text.substring(0, max - 1) + ELLIPSIS_CHARACTER;
  }

  /**
   * 긴 문자열의 앞부분을 반환한다.
   *
   * @param text     문자열.
   * @param max      잘라낸 문자열의 최대 길이. 말줄임표를 포함한다.
   * @param ellipsis 잘라낼 경우 말줄임표를 붙일지 여부.
   *
   * @return 문자열의 앞부분.
   *
   * @see #ELLIPSIS_CHARACTER
   */
  public static String head(final String text, final int max, final boolean ellipsis) {
    if (ellipsis)
      return head(text, max);

    if (1 > max)
      throw new IllegalArgumentException("too small max.");

    if (null == text)
      return null;

    return text.length() <= max
               ? text
               : text.substring(0, max);
  }

  /**
   * 유니코드 문자의 갯수를 센다.
   *
   * @param text 문자열
   *
   * @return 유니코드 문자 갯수.
   */
  public static int count(final String text) {
    return notNull(text, "text").codePointCount(0, text.length());
  }

  protected Texts() {
    throw new UnsupportedOperationException("does not support instance.");
  }
}
