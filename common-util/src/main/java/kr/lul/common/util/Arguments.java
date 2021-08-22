package kr.lul.common.util;

import java.time.Instant;
import java.util.Collection;
import java.util.List;
import java.util.regex.PatternSyntaxException;

import static java.lang.String.format;

/**
 * 메서드 인자의 검증 유틸리티.
 *
 * @author justburrow
 * @since 2018. 9. 17.
 */
public abstract class Arguments {
  private static final String DEFAULT_TARGET_NAME = "target";

  /**
   * 단정 대상의 이름을 결정한다.
   *
   * @param targetName 요청받은 단정 대상의 원래 이름.
   *
   * @return 단정 대상의 이름.
   */
  private static String name(final String targetName) {
    return null == targetName || targetName.isEmpty()
        ? DEFAULT_TARGET_NAME
        : targetName;
  }

  /**
   * 단정 대상이 {@code null}이면 실패.
   *
   * @param target 단정 대상.
   * @param <T>    타겟 타입.
   *
   * @return {@code target} 인스턴스.
   *
   * @throws IllegalArgumentException 단정 대상이 {@code null}일 때.
   * @see java.util.Objects#requireNonNull(Object)
   */
  public static <T> T notNull(final T target) throws IllegalArgumentException {
    if (null == target)
      throw new IllegalArgumentException(DEFAULT_TARGET_NAME + " is null.");

    return target;
  }

  /**
   * 단정 대상이 {@code null}이면 실패.
   *
   * @param target     단정 대상.
   * @param targetName 단정 대상의 이름.
   * @param <T>        타겟 타입.
   *
   * @return {@code target} 인스턴스.
   *
   * @throws IllegalArgumentException 단정 대상이 {@code null}일 때.
   * @see java.util.Objects#requireNonNull(Object, String)
   */
  public static <T> T notNull(final T target, final String targetName) throws IllegalArgumentException {
    if (null == target)
      throw new IllegalArgumentException(name(targetName) + " is null.");

    return target;
  }

  public static boolean isTrue(boolean b) throws IllegalArgumentException {
    if (b)
      return true;

    throw new IllegalArgumentException(DEFAULT_TARGET_NAME + " is not true.");
  }

  public static boolean isTrue(boolean b, String targetName) throws IllegalArgumentException {
    if (b)
      return true;

    throw new IllegalArgumentException(format("%s is not true.", name(targetName)));
  }

  public static boolean isFalse(boolean b) throws IllegalArgumentException {
    if (b)
      throw new IllegalArgumentException(DEFAULT_TARGET_NAME + " is not false.");

    return false;
  }

  public static boolean isFalse(boolean b, String targetName) throws IllegalArgumentException {
    if (b)
      throw new IllegalArgumentException(name(targetName) + " is not false.");

    return false;
  }

  /**
   * 단정 대상이 0 보다 작거나 같으면 실패.
   *
   * @param target 단정 대상.
   *
   * @return {@code target} 인스턴스.
   *
   * @throws IllegalArgumentException 단정 대상이 0보다 작거나 같을 때.
   */
  public static int positive(final int target) throws IllegalArgumentException {
    if (0 >= target) {
      throw new IllegalArgumentException(format("%s is not positive : %d", DEFAULT_TARGET_NAME, target));
    }

    return target;
  }

  /**
   * 단정 대상이 0 보다 작거나 같으면 실패.
   *
   * @param target     단정 대상.
   * @param targetName 단정 대상의 이름.
   *
   * @return {@code target} 인스턴스.
   *
   * @throws IllegalArgumentException 단정 대상이 0보다 작거나 같을 때.
   */
  public static int positive(final int target, final String targetName) throws IllegalArgumentException {
    if (0 >= target)
      throw new IllegalArgumentException(format("%s is not positive : %d", name(targetName), target));

    return target;
  }

  /**
   * 단정 대상이 0 보다 작거나 같으면 실패.
   *
   * @param target 단정 대상.
   *
   * @return {@code target} 인스턴스.
   *
   * @throws IllegalArgumentException 단정 대상이 0보다 작거나 같을 때.
   */
  public static long positive(final long target) throws IllegalArgumentException {
    if (0 >= target) {
      throw new IllegalArgumentException(format("%s is not positive : %d", DEFAULT_TARGET_NAME, target));
    }

    return target;
  }

  /**
   * 단정 대상이 0 보다 작거나 같으면 실패.
   *
   * @param target     단정 대상.
   * @param targetName 단정 대상의 이름.
   *
   * @return {@code target} 인스턴스.
   *
   * @throws IllegalArgumentException 단정 대상이 0보다 작거나 같을 때.
   */
  public static long positive(final long target, final String targetName) throws IllegalArgumentException {
    if (0 >= target)
      throw new IllegalArgumentException(format("%s is not positive : %d", name(targetName), target));

    return target;
  }

  /**
   * 단정 대상이 0 보다 작으면 실패.
   *
   * @param target 단정 대상.
   *
   * @return {@code target} 인스턴스.
   *
   * @throws IllegalArgumentException 단정 대상이 0보다 작을 때.
   */
  public static int notNegative(final int target) throws IllegalArgumentException {
    if (0 > target)
      throw new IllegalArgumentException(format("%s is negative : %d", DEFAULT_TARGET_NAME, target));

    return target;
  }

  /**
   * 단정 대상이 0 보다 작으면 실패.
   *
   * @param target     단정 대상.
   * @param targetName 단정 대상의 이름.
   *
   * @return {@code target} 인스턴스.
   *
   * @throws IllegalArgumentException 단정 대상이 0보다 작을 때.
   */
  public static int notNegative(final int target, final String targetName) throws IllegalArgumentException {
    if (0 > target)
      throw new IllegalArgumentException(format("%s is negative : %d", name(targetName), target));

    return target;
  }

  /**
   * 단정 대상이 0 보다 작으면 실패.
   *
   * @param target 단정 대상.
   *
   * @return {@code target} 인스턴스.
   *
   * @throws IllegalArgumentException 단정 대상이 0보다 작을 때.
   */
  public static long notNegative(final long target) throws IllegalArgumentException {
    if (0 > target)
      throw new IllegalArgumentException(format("%s is negative : %d", DEFAULT_TARGET_NAME, target));

    return target;
  }

  /**
   * 단정 대상이 0 보다 작으면 실패.
   *
   * @param target     단정 대상.
   * @param targetName 단정 대상의 이름.
   *
   * @return {@code target} 인스턴스.
   *
   * @throws IllegalArgumentException 단정 대상이 0보다 작을 때.
   */
  public static long notNegative(final long target, final String targetName) throws IllegalArgumentException {
    if (0 > target)
      throw new IllegalArgumentException(format("%s is negative : %d", name(targetName), target));

    return target;
  }

  /**
   * 대상이 0 보다 크면 실패.
   *
   * @param target 대상.
   *
   * @return {@code target} 인스턴스.
   *
   * @throws IllegalArgumentException 대상이 0보다 클 때.
   */
  public static int notPositive(final int target) throws IllegalArgumentException {
    if (0 < target)
      throw new IllegalArgumentException(format("%s is positive : %d", DEFAULT_TARGET_NAME, target));

    return target;
  }

  /**
   * 대상이 0 보다 크면 실패.
   *
   * @param target     대상.
   * @param targetName 대상의 이름.
   *
   * @return {@code target} 인스턴스.
   *
   * @throws IllegalArgumentException 대상이 0보다 클 때.
   */
  public static int notPositive(final int target, final String targetName) throws IllegalArgumentException {
    if (0 < target)
      throw new IllegalArgumentException(format("%s is positive : %d", name(targetName), target));

    return target;
  }

  /**
   * 대상이 0 보다 크면 실패.
   *
   * @param target 대상.
   *
   * @return {@code target} 인스턴스.
   *
   * @throws IllegalArgumentException 대상이 0보다 클 때.
   */
  public static long notPositive(final long target) throws IllegalArgumentException {
    if (0 < target)
      throw new IllegalArgumentException(format("%s is positive : %d", DEFAULT_TARGET_NAME, target));

    return target;
  }

  /**
   * 대상이 0 보다 크면 실패.
   *
   * @param target     대상.
   * @param targetName 대상의 이름.
   *
   * @return {@code target} 인스턴스.
   *
   * @throws IllegalArgumentException 대상이 0보다 클 때.
   */
  public static long notPositive(final long target, final String targetName) throws IllegalArgumentException {
    if (0 < target)
      throw new IllegalArgumentException(format("%s is positive : %d", name(targetName), target));

    return target;
  }

  /**
   * @param target 대상.
   * @param max    최대값(미포함).
   *
   * @return {@code target} 인스턴스.
   *
   * @throws IllegalArgumentException 대상이 최대값보다 크거나 같을 때.
   */
  public static int lt(final int target, final int max) throws IllegalArgumentException {
    return lt(target, max, DEFAULT_TARGET_NAME);
  }

  /**
   * @param target     대상.
   * @param max        최대값(미포함).
   * @param targetName 대상의 이름.
   *
   * @return {@code target} 인스턴스.
   *
   * @throws IllegalArgumentException 대상이 최대값보다 크거나 같을 때.
   */
  public static int lt(final int target, final int max, final String targetName) throws IllegalArgumentException {
    if (max <= target) {
      throw new IllegalArgumentException(format("%s is not less than %d : %d", name(targetName), max, target));
    }

    return target;
  }

  /**
   * @param target 대상.
   * @param max    최대값(미포함).
   *
   * @return {@code target} 인스턴스.
   *
   * @throws IllegalArgumentException 대상이 최대값보다 크거나 같을 때.
   */
  public static long lt(final long target, final long max) throws IllegalArgumentException {
    return lt(target, max, DEFAULT_TARGET_NAME);
  }

  /**
   * @param target     대상.
   * @param max        최대값(미포함).
   * @param targetName 대상의 이름.
   *
   * @return {@code target} 인스턴스.
   *
   * @throws IllegalArgumentException 대상이 최대값보다 크거나 같을 때.
   */
  public static long lt(final long target, final long max, final String targetName) throws IllegalArgumentException {
    if (max <= target) {
      throw new IllegalArgumentException(format("%s is not less than %d : %d", name(targetName), max, target));
    }

    return target;
  }

  public static <C extends Comparable<C>> C lt(C target, C max) throws IllegalArgumentException {
    return lt(target, max, DEFAULT_TARGET_NAME);
  }

  public static <C extends Comparable<C>> C lt(C target, C max, String targetName) throws IllegalArgumentException {
    if (0 <= notNull(target, targetName).compareTo(notNull(max, "max")))
      throw new IllegalArgumentException(format("%s is not less than %s : %s", name(targetName), max, target));

    return target;
  }

  /**
   * @param target 대상
   * @param max    최대값(포함)
   *
   * @return {@code target} 인스턴스.
   *
   * @throws IllegalArgumentException 대상이 최대값보다 큰 경우.
   */
  public static int le(final int target, final int max) throws IllegalArgumentException {
    return le(target, max, DEFAULT_TARGET_NAME);
  }

  /**
   * @param target     대상
   * @param max        최대값(포함)
   * @param targetName 대상의 이름
   *
   * @return {@code target} 인스턴스.
   *
   * @throws IllegalArgumentException 대상이 최대값보다 큰 경우.
   */
  public static int le(final int target, final int max, final String targetName) throws IllegalArgumentException {
    if (max < target)
      throw new IllegalArgumentException(format("%s is not less than or equal to %d : %d", name(targetName), max, target));

    return target;
  }

  /**
   * @param target 대상
   * @param max    최대값(포함)
   *
   * @return {@code target} 인스턴스.
   *
   * @throws IllegalArgumentException 대상이 최대값보다 큰 경우.
   */
  public static long le(final long target, final long max) throws IllegalArgumentException {
    return le(target, max, DEFAULT_TARGET_NAME);
  }

  /**
   * @param target     대상
   * @param max        최대값(포함)
   * @param targetName 대상의 이름
   *
   * @return {@code target} 인스턴스.
   *
   * @throws IllegalArgumentException 대상이 최대값보다 큰 경우.
   */
  public static long le(final long target, final long max, final String targetName) throws IllegalArgumentException {
    if (max < target)
      throw new IllegalArgumentException(format("%s is not less than or equal to %d : %d", name(targetName), max, target));

    return target;
  }

  /**
   * @param target 대상
   * @param max    최대값(포함)
   * @param <C>    대상 타입
   *
   * @return 대상
   *
   * @throws IllegalArgumentException 대상이 최대값보다 클 때.
   */
  public static <C extends Comparable<C>> C le(C target, C max) throws IllegalArgumentException {
    return le(target, max, DEFAULT_TARGET_NAME);
  }

  /**
   * @param target     대상
   * @param max        최대값(포함)
   * @param targetName 대상 이름
   * @param <C>        대상 타입
   *
   * @return 대상
   *
   * @throws IllegalArgumentException 대상이 최대값보다 클 때.
   */
  public static <C extends Comparable<C>> C le(C target, C max, String targetName) throws IllegalArgumentException {
    if (0 < notNull(target, targetName).compareTo(notNull(max, "max")))
      throw new IllegalArgumentException(format("%s is not less than or equal to %s : %s", name(targetName), max, target));

    return target;
  }

  /**
   * @param target 대상
   * @param min    최소값(미포함)
   *
   * @return {@code target} 인스턴스.
   *
   * @throws IllegalArgumentException 대상이 최소값보다 작거나 같을 때.
   */
  public static int gt(final int target, final int min) throws IllegalArgumentException {
    return gt(target, min, DEFAULT_TARGET_NAME);
  }

  /**
   * @param target     대상
   * @param min        최소값(미포함)
   * @param targetName 대상 이름
   *
   * @return {@code target} 인스턴스.
   *
   * @throws IllegalArgumentException 대상이 최소값보다 작거나 같을 때.
   */
  public static int gt(final int target, final int min, final String targetName) throws IllegalArgumentException {
    if (min >= target)
      throw new IllegalArgumentException(format("%s is not greater than %d : %d", name(targetName), min, target));

    return target;
  }

  /**
   * @param target 대상
   * @param min    최소값(미포함)
   *
   * @return {@code target} 인스턴스.
   *
   * @throws IllegalArgumentException 대상이 최소값보다 작거나 같을 때.
   */
  public static long gt(final long target, final long min) throws IllegalArgumentException {
    return gt(target, min, DEFAULT_TARGET_NAME);
  }

  /**
   * @param target     대상
   * @param min        최소값(미포함)
   * @param targetName 대상 이름
   *
   * @return {@code target} 인스턴스.
   *
   * @throws IllegalArgumentException 대상이 최소값보다 작거나 같을 때.
   */
  public static long gt(final long target, final long min, final String targetName) throws IllegalArgumentException {
    if (min >= target)
      throw new IllegalArgumentException(format("%s is not greater than %d : %d", name(targetName), min, target));

    return target;
  }

  /**
   * @param target 대상
   * @param min    최소값(미포함)
   * @param <C>    대상 타입
   *
   * @return 대상
   *
   * @throws IllegalArgumentException 대상이 최소값보다 작거나 같을 때.
   */
  public static <C extends Comparable<C>> C gt(C target, C min) throws IllegalArgumentException {
    return gt(target, min, DEFAULT_TARGET_NAME);
  }

  /**
   * @param target     대상
   * @param min        최소값(미포함)
   * @param targetName 대상 이름
   * @param <C>        대상 타입
   *
   * @return 대상
   *
   * @throws IllegalArgumentException 대상이 최소값보다 작거나 같을 때.
   */
  public static <C extends Comparable<C>> C gt(C target, C min, String targetName) {
    if (0 >= notNull(target, targetName).compareTo(notNull(min, "min")))
      throw new IllegalArgumentException(format("%s is not greater than %s : %s", name(targetName), min, target));

    return target;
  }

  /**
   * @param target 대상
   * @param min    최소값(포함)
   *
   * @return {@code target} 인스턴스.
   *
   * @throws IllegalArgumentException 대상이 최소값보다 작을 때.
   */
  public static int ge(final int target, final int min) throws IllegalArgumentException {
    return ge(target, min, DEFAULT_TARGET_NAME);
  }

  /**
   * @param target     대상
   * @param min        최소값(포함)
   * @param targetName 대상의 이름
   *
   * @return {@code target} 인스턴스.
   *
   * @throws IllegalArgumentException 대상이 최소값보다 작을 때.
   */
  public static int ge(final int target, final int min, final String targetName) throws IllegalArgumentException {
    if (min > target)
      throw new IllegalArgumentException(format("%s is not greater than or equal to %d : %d", name(targetName), min, target));

    return target;
  }

  /**
   * @param target 대상
   * @param min    최소값(포함)
   *
   * @return {@code target} 인스턴스.
   *
   * @throws IllegalArgumentException 대상이 최소값보다 작을 때.
   */
  public static long ge(final long target, final long min) throws IllegalArgumentException {
    return ge(target, min, DEFAULT_TARGET_NAME);
  }

  /**
   * @param target     대상
   * @param min        최소값(포함)
   * @param targetName 대상의 이름
   *
   * @return {@code target} 인스턴스.
   *
   * @throws IllegalArgumentException 대상이 최소값보다 작을 때.
   */
  public static long ge(final long target, final long min, final String targetName) throws IllegalArgumentException {
    if (min > target)
      throw new IllegalArgumentException(format("%s is not greater than or equal to %d : %d", name(targetName), min, target));

    return target;
  }

  /**
   * @param target 대상
   * @param min    최소값(포함)
   * @param <C>    대상 타입.
   *
   * @return 대상
   *
   * @throws IllegalArgumentException 대상이 최소값보다 작을 때.
   */
  public static <C extends Comparable<C>> C ge(C target, C min) throws IllegalArgumentException {
    return ge(target, min, DEFAULT_TARGET_NAME);
  }

  /**
   * @param target     대상
   * @param min        최소값(포함)
   * @param targetName 대상 이름.
   * @param <C>        대상 타입.
   *
   * @return 대상
   *
   * @throws IllegalArgumentException 대상이 최소값보다 작을 때.
   */
  public static <C extends Comparable<C>> C ge(C target, C min, String targetName) {
    if (0 > notNull(target, targetName).compareTo(notNull(min, "min")))
      throw new IllegalArgumentException(format("%s is not greater than or equal to %s : :%s", name(targetName), min, target));

    return target;
  }

  /**
   * 숫자가 범위를 벗어나면 실패.
   *
   * @param target 대상.
   * @param min    최소값(포함).
   * @param max    최대값(포함).
   *
   * @return {@code target} 인스턴스.
   *
   * @throws IllegalArgumentException 대상이 범위를 벗어날 때.
   */
  public static int range(final int target, final int min, final int max) throws IllegalArgumentException {
    return range(target, min, max, DEFAULT_TARGET_NAME);
  }

  /**
   * 숫자가 범위를 벗어나면 실패.
   *
   * @param target     대상.
   * @param min        최소값(포함).
   * @param max        최대값(포함).
   * @param targetName 대상 이름.
   *
   * @return {@code target} 인스턴스.
   *
   * @throws IllegalArgumentException 대상이 범위를 벗어날 때.
   */
  public static int range(final int target, final int min, final int max, final String targetName) {
    if (min > max)
      throw new IllegalArgumentException(format("min is greater than max : min=%d, max=%d", min, max));
    else if (min > target)
      throw new IllegalArgumentException(
          format("%s is less than min : %s=%d, min=%d", name(targetName), name(targetName), target, min));
    else if (max < target)
      throw new IllegalArgumentException(
          format("%s is greater than max : %s=%d, max=%d", name(targetName), name(targetName), target, max));

    return target;
  }

  /**
   * 숫자가 범위를 벗어나면 실패.
   *
   * @param target 대상.
   * @param min    최소값(포함).
   * @param max    최대값(포함).
   * @param <C>    타겟 타입.
   *
   * @return {@code target} 인스턴스.
   *
   * @throws IllegalArgumentException 대상이 범위를 벗어날 때.
   */
  public static <C extends Comparable<C>> C range(C target, C min, C max) throws IllegalArgumentException {
    return range(target, min, max, DEFAULT_TARGET_NAME);
  }

  /**
   * 숫자가 범위를 벗어나면 실패.
   *
   * @param target     대상.
   * @param min        최소값(포함).
   * @param max        최대값(포함).
   * @param targetName 대상 이름.
   * @param <C>        타겟 타입.
   *
   * @return {@code target} 인스턴스.
   *
   * @throws IllegalArgumentException 대상이 범위를 벗어날 때.
   */
  public static <C extends Comparable<C>> C range(C target, C min, C max, String targetName) throws IllegalArgumentException {
    if (null == target)
      throw new IllegalArgumentException(name(targetName) + " is null.");
    else if (null == min)
      throw new IllegalArgumentException("min is null.");
    else if (null == max)
      throw new IllegalArgumentException("max is null.");

    le(min, max, "min");
    ge(target, min, name(targetName));
    le(target, max, name(targetName));

    return target;
  }

  /**
   * 단정 대상이 {@code null} 이거나 빈 문자열이면 실패.
   *
   * @param target 단정 대상.
   *
   * @return {@code target} 인스턴스.
   *
   * @throws IllegalArgumentException 단정 대상이 {@code null} 이거나 빈 문자열일 때.
   */
  public static String notEmpty(final String target) throws IllegalArgumentException {
    if (null == target)
      throw new IllegalArgumentException(DEFAULT_TARGET_NAME + " is null.");
    else if (target.isEmpty())
      throw new IllegalArgumentException(DEFAULT_TARGET_NAME + " is empty.");

    return target;
  }

  /**
   * 단정 대상이 {@code null} 이거나 빈 문자열이면 실패.
   *
   * @param target     단정 대상.
   * @param targetName 단정 대상의 이름.
   *
   * @return {@code target} 인스턴스.
   *
   * @throws IllegalArgumentException 단정 대상이 {@code null} 이거나 빈 문자열일 때.
   */
  public static String notEmpty(final String target, final String targetName) throws IllegalArgumentException {
    if (null == target)
      throw new IllegalArgumentException(name(targetName) + " is null.");
    else if (target.isEmpty())
      throw new IllegalArgumentException(name(targetName) + " is empty.");

    return target;
  }

  /**
   * 대상 배열이 {@code null}이거나 길이가 0이면 실패.
   *
   * @param target 단정 대상.
   *
   * @return {@code target} 인스턴스.
   *
   * @throws IllegalArgumentException 대상이 {@code null}이거나 길이가 0일 때.
   */
  public static byte[] notEmpty(final byte[] target) throws IllegalArgumentException {
    if (null == target)
      throw new IllegalArgumentException(DEFAULT_TARGET_NAME + " is null.");
    else if (0 == target.length)
      throw new IllegalArgumentException(DEFAULT_TARGET_NAME + " is empty.");

    return target;
  }

  /**
   * 대상 배열이 {@code null}이거나 길이가 0이면 실패.
   *
   * @param target     단정 대상.
   * @param targetName 단정 대상의 이름.
   *
   * @return {@code target} 인스턴스.
   *
   * @throws IllegalArgumentException 대상이 {@code null}이거나 길이가 0일 때.
   */
  public static byte[] notEmpty(final byte[] target, final String targetName) throws IllegalArgumentException {
    if (null == target)
      throw new IllegalArgumentException(name(targetName) + " is null.");
    else if (0 == target.length)
      throw new IllegalArgumentException(name(targetName) + " is empty.");

    return target;
  }

  public static <T> T[] notEmpty(final T[] target) throws IllegalArgumentException {
    return notEmpty(target, DEFAULT_TARGET_NAME);
  }

  public static <T> T[] notEmpty(final T[] target, final String targetName) throws IllegalArgumentException {
    if (null == target)
      throw new IllegalArgumentException(name(targetName) + " is null.");
    else if (0 == target.length)
      throw new IllegalArgumentException(name(targetName) + " is empty.");

    return target;
  }

  public static <T> List<T> notEmpty(final List<T> target) throws IllegalArgumentException {
    return notEmpty(target, DEFAULT_TARGET_NAME);
  }

  public static <T> List<T> notEmpty(final List<T> target, final String targetName) throws IllegalArgumentException {
    if (null == target)
      throw new IllegalArgumentException(name(targetName) + " is null.");
    else if (target.isEmpty())
      throw new IllegalArgumentException(name(targetName) + " is empty.");

    return target;
  }

  public static String noWhitespace(final String target) throws IllegalArgumentException {
    return noWhitespace(target, DEFAULT_TARGET_NAME);
  }

  public static String noWhitespace(final String target, final String name) throws IllegalArgumentException {
    if (null == target)
      throw new IllegalArgumentException(name(name) + " is null.");
    if (null == name)
      throw new IllegalArgumentException("name is null.");
    else if (name.isEmpty())
      throw new IllegalArgumentException("name is empty.");
    else if (!target.matches("\\S*"))
      throw new IllegalArgumentException(format("%s contains whitespace character(s) : '%s'", name(name), target));

    return target;
  }

  /**
   * 단정 대상 문자열이 지정한 패턴이 아니면 실패.
   *
   * @param target  단정 대상.
   * @param pattern 비교할 정규 표현식.
   *
   * @return {@code target} 인스턴스.
   *
   * @throws IllegalArgumentException 단정 대상 문자열이 지정한 패턴이 아닐 때.
   * @see String#matches(String)
   */
  public static String matches(final String target, final String pattern) throws IllegalArgumentException {
    if (null == target)
      throw new IllegalArgumentException(DEFAULT_TARGET_NAME + " is null.");
    else if (null == pattern)
      throw new IllegalArgumentException("pattern is null.");

    try {
      if (!target.matches(pattern))
        throw new IllegalArgumentException(format("%s does not match : pattern='%s', target='%s'",
            DEFAULT_TARGET_NAME, pattern, target));

      return target;
    } catch (final PatternSyntaxException e) {
      throw new IllegalArgumentException(format("illegal pattern : pattern='%s'", pattern), e);
    }
  }

  /**
   * 단정 대상 문자열이 지정한 패턴이 아니면 실패.
   *
   * @param target     단정 대상.
   * @param pattern    비교할 정규 표현식.
   * @param targetName 단정 대상의 이름.
   *
   * @return {@code target} 인스턴스.
   *
   * @throws IllegalArgumentException 단정 대상 문자열이 지정한 패턴이 아닐 때.
   * @see String#matches(String)
   */
  public static String matches(final String target, final String pattern,
      final String targetName) throws IllegalArgumentException {
    if (null == target)
      throw new IllegalArgumentException(name(targetName) + " is null.");
    else if (null == pattern)
      throw new IllegalArgumentException("pattern is null.");

    try {
      if (!target.matches(pattern))
        throw new IllegalArgumentException(format("%s does not match : pattern='%s', target='%s'",
            name(targetName), pattern, target));

      return target;
    } catch (final PatternSyntaxException e) {
      throw new IllegalArgumentException(format("illegal pattern : pattern='%s'", pattern), e);
    }
  }

  /**
   * {@code after or equal to}
   *
   * @param target 검증 대상.
   * @param comp   검증 기준
   *
   * @return {@code target} 인스턴스.
   */
  public static Instant ae(final Instant target, final Instant comp) {
    return ae(target, comp, DEFAULT_TARGET_NAME);
  }

  /**
   * {@code after or equal to}
   *
   * @param target     검증 대상.
   * @param comp       검증 기준
   * @param targetName 검증 대상의 이름.
   *
   * @return {@code target} 인스턴스.
   */
  public static Instant ae(final Instant target, final Instant comp, final String targetName) {
    if (null == target)
      throw new IllegalArgumentException(name(targetName) + " is null.");
    else if (null == comp)
      throw new IllegalArgumentException("comp is null.");

    if (target.isBefore(comp))
      throw new IllegalArgumentException(format("%s is not after or equal to compare : compare=%s, target=%s",
          name(targetName), comp, target));

    return target;
  }

  /**
   * 대상의 인스턴스의 클래스가 기대치와 영확히 일치하는지 검사한다.
   *
   * @param target 검사 대상.
   * @param clz    기대하는 클래스.
   * @param <T>    기대하는 타입.
   *
   * @return {@code target} 인스턴스.
   */
  public static <T> T instanceOf(final Object target, final Class<T> clz) {
    return instanceOf(target, clz, null);
  }

  /**
   * 대상의 인스턴스의 클래스가 기대치와 영확히 일치하는지 검사한다.
   *
   * @param <T>        기대하는 타입.
   * @param target     검사 대상.
   * @param clz        기대하는 클래스.
   * @param targetName 검사 대상의 이름.
   *
   * @return {@code target} 인스턴스.
   */
  public static <T> T instanceOf(final Object target, final Class<T> clz, final String targetName) {
    if (null == clz) {
      throw new IllegalArgumentException("clz is null.");
    } else if (null == target || target.getClass().equals(clz)) {
      //noinspection unchecked
      return (T) target;
    }

    throw new IllegalArgumentException(format("%s is not instance of %s", name(targetName), clz.getName()));
  }

  /**
   * 대상 인스턴스를 기대 클래스의 변수에 할당할 수 있는지 검사한다.
   *
   * @param <T>    기대하는 타입.
   * @param target 검사 대상.
   * @param clz    기대하는 클래스.
   *
   * @return {@code target} 인스턴스.
   */
  public static <T> T assignable(final Object target, final Class<T> clz) {
    return assignable(target, clz, null);
  }

  /**
   * 대상 인스턴스를 기대 클래스의 변수에 할당할 수 있는지 검사한다.
   *
   * @param <T>        기대하는 타입.
   * @param target     검사 대상.
   * @param clz        기대하는 클래스.
   * @param targetName 대상의 이름.
   *
   * @return {@code target} 인스턴스.
   */
  public static <T> T assignable(final Object target, final Class<T> clz, final String targetName) {
    if (null == clz)
      throw new IllegalArgumentException("clz is null.");
    else if (null == target)
      return null;
    else if (!clz.isAssignableFrom(target.getClass()))
      throw new IllegalArgumentException(name(targetName) + " is not assignable to " + clz.getName());

    //noinspection unchecked
    return (T) target;
  }

  /**
   * 대상 인스턴스가 기대하는 클래스 혹은 기대 클래스를 상속한 클래스의 인스턴스인지 검사한다.
   *
   * @param target     검사 대상.
   * @param superClass 기대하는 클래스.
   * @param <T>        타겟 타입.
   *
   * @return {@code target} 인스턴스.
   *
   * @see #assignable(Object, Class, String) alias
   */
  public static <T> T extend(final T target, final Class<?> superClass) {
    return extend(target, superClass, null);
  }

  /**
   * 대상 인스턴스가 기대하는 클래스 혹은 기대 클래스를 상속한 클래스의 인스턴스인지 검사한다.
   *
   * @param target     검사 대상.
   * @param superClass 기대하는 클래스.
   * @param targetName 대상의 이름.
   * @param <T>        타겟 타입.
   *
   * @return {@code target} 인스턴스.
   *
   * @see #assignable(Object, Class, String) alias
   */
  public static <T> T extend(final T target, final Class<?> superClass, final String targetName) {
    if (null == superClass)
      throw new IllegalArgumentException("superClass is null.");
    else if (null == target)
      return null;
    else if (!superClass.isAssignableFrom(target.getClass()))
      throw new IllegalArgumentException(name(targetName) + " does not extend " + superClass.getName());

    return target;
  }

  /**
   * 대상이 컬렉션에 포함되어 있는지 시험한다.
   *
   * @param target     시험 대상.
   * @param collection 컬렉션.
   * @param <T>        대상의 타입.
   *
   * @return {@code target} 인스턴스.
   *
   * @throws IllegalArgumentException 시험 대상이 컬렉션에 포함되어있지 않을 때.
   */
  public static <T> T in(final T target, final Collection<T> collection) throws IllegalArgumentException {
    if (null == target)
      throw new IllegalArgumentException("target is null.");
    else if (null == collection)
      throw new IllegalArgumentException("collection is null.");
    else if (!collection.contains(target))
      throw new IllegalArgumentException(format("%s is not in collection : target=%s, collection=%s",
          DEFAULT_TARGET_NAME, target, collection));

    return target;
  }

  /**
   * 대상이 컬렉션에 포함되어 있는지 시험한다.
   *
   * @param target     시험 대상.
   * @param collection 컬렉션.
   * @param targetName 시험 대상의 이름.
   * @param <T>        대상의 타입.
   *
   * @return {@code target} 인스턴스.
   *
   * @throws IllegalArgumentException 시험 대상이 컬렉션에 포함되어있지 않을 때.
   */
  public static <T> T in(final T target, final Collection<T> collection,
      final String targetName) throws IllegalArgumentException {
    if (null == target)
      throw new IllegalArgumentException(name(targetName) + " is null.");
    else if (null == collection)
      throw new IllegalArgumentException("collection is null.");
    else if (!collection.contains(target))
      throw new IllegalArgumentException(format("%s is not in collection : target=%s, collection=%s",
          name(targetName), target, collection));

    return target;
  }

  protected Arguments() {
    throw new UnsupportedOperationException("does not support instance.");
  }
}