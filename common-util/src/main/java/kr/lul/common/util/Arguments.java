package kr.lul.common.util;

import java.time.Instant;
import java.util.Collection;
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
  private static String name(String targetName) {
    return null == targetName || targetName.isEmpty()
        ? DEFAULT_TARGET_NAME
        : targetName;
  }

  /**
   * 단정 대상이 {@code null}이면 실패.
   *
   * @param target 단정 대상.
   *
   * @throws IllegalArgumentException 단정 대상이 {@code null}일 때.
   * @see java.util.Objects#requireNonNull(Object)
   */
  public static void notNull(Object target) throws IllegalArgumentException {
    if (null == target) {
      throw new IllegalArgumentException(DEFAULT_TARGET_NAME + " is null.");
    }
  }

  /**
   * 단정 대상이 {@code null}이면 실패.
   *
   * @param target     단정 대상.
   * @param targetName 단정 대상의 이름.
   *
   * @throws IllegalArgumentException 단정 대상이 {@code null}일 때.
   * @see java.util.Objects#requireNonNull(Object, String)
   */
  public static void notNull(Object target, String targetName) throws IllegalArgumentException {
    if (null == target) {
      throw new IllegalArgumentException(name(targetName) + " is null.");
    }
  }

  /**
   * 단정 대상이 0 보다 작거나 같으면 실패.
   *
   * @param target 단정 대상.
   *
   * @throws IllegalArgumentException 단정 대상이 0보다 작거나 같을 때.
   */
  public static void positive(int target) throws IllegalArgumentException {
    if (0 >= target) {
      throw new IllegalArgumentException(format("%s is not positive : %d", DEFAULT_TARGET_NAME, target));
    }
  }

  /**
   * 단정 대상이 0 보다 작거나 같으면 실패.
   *
   * @param target     단정 대상.
   * @param targetName 단정 대상의 이름.
   *
   * @throws IllegalArgumentException 단정 대상이 0보다 작거나 같을 때.
   */
  public static void positive(int target, String targetName) throws IllegalArgumentException {
    if (0 >= target) {
      throw new IllegalArgumentException(format("%s is not positive : %d", name(targetName), target));
    }
  }

  /**
   * 단정 대상이 0 보다 작거나 같으면 실패.
   *
   * @param target 단정 대상.
   *
   * @throws IllegalArgumentException 단정 대상이 0보다 작거나 같을 때.
   */
  public static void positive(long target) throws IllegalArgumentException {
    if (0 >= target) {
      throw new IllegalArgumentException(format("%s is not positive : %d", DEFAULT_TARGET_NAME, target));
    }
  }

  /**
   * 단정 대상이 0 보다 작거나 같으면 실패.
   *
   * @param target     단정 대상.
   * @param targetName 단정 대상의 이름.
   *
   * @throws IllegalArgumentException 단정 대상이 0보다 작거나 같을 때.
   */
  public static void positive(long target, String targetName) throws IllegalArgumentException {
    if (0 >= target) {
      throw new IllegalArgumentException(format("%s is not positive : %d", name(targetName), target));
    }
  }

  /**
   * 단정 대상이 0 보다 작으면 실패.
   *
   * @param target 단정 대상.
   *
   * @throws IllegalArgumentException 단정 대상이 0보다 작을 때.
   */
  public static void notNegative(int target) throws IllegalArgumentException {
    if (0 > target) {
      throw new IllegalArgumentException(format("%s is negative : %d", DEFAULT_TARGET_NAME, target));
    }
  }

  /**
   * 단정 대상이 0 보다 작으면 실패.
   *
   * @param target     단정 대상.
   * @param targetName 단정 대상의 이름.
   *
   * @throws IllegalArgumentException 단정 대상이 0보다 작을 때.
   */
  public static void notNegative(int target, String targetName) throws IllegalArgumentException {
    if (0 > target) {
      throw new IllegalArgumentException(format("%s is negative : %d", name(targetName), target));
    }
  }

  /**
   * 단정 대상이 0 보다 작으면 실패.
   *
   * @param target 단정 대상.
   *
   * @throws IllegalArgumentException 단정 대상이 0보다 작을 때.
   */
  public static void notNegative(long target) throws IllegalArgumentException {
    if (0 > target) {
      throw new IllegalArgumentException(format("%s is negative : %d", DEFAULT_TARGET_NAME, target));
    }
  }

  /**
   * 단정 대상이 0 보다 작으면 실패.
   *
   * @param target     단정 대상.
   * @param targetName 단정 대상의 이름.
   *
   * @throws IllegalArgumentException 단정 대상이 0보다 작을 때.
   */
  public static void notNegative(long target, String targetName) throws IllegalArgumentException {
    if (0 > target) {
      throw new IllegalArgumentException(format("%s is negative : %d", name(targetName), target));
    }
  }

  /**
   * 대상이 0 보다 크면 실패.
   *
   * @param target 대상.
   *
   * @throws IllegalArgumentException 대상이 0보다 클 때.
   */
  public static void notPositive(int target) throws IllegalArgumentException {
    if (0 < target) {
      throw new IllegalArgumentException(format("%s is positive : %d", DEFAULT_TARGET_NAME, target));
    }
  }

  /**
   * 대상이 0 보다 크면 실패.
   *
   * @param target     대상.
   * @param targetName 대상의 이름.
   *
   * @throws IllegalArgumentException 대상이 0보다 클 때.
   */
  public static void notPositive(int target, String targetName) throws IllegalArgumentException {
    if (0 < target) {
      throw new IllegalArgumentException(format("%s is positive : %d", name(targetName), target));
    }
  }

  /**
   * 대상이 0 보다 크면 실패.
   *
   * @param target 대상.
   *
   * @throws IllegalArgumentException 대상이 0보다 클 때.
   */
  public static void notPositive(long target) throws IllegalArgumentException {
    if (0 < target) {
      throw new IllegalArgumentException(format("%s is positive : %d", DEFAULT_TARGET_NAME, target));
    }
  }

  /**
   * 대상이 0 보다 크면 실패.
   *
   * @param target     대상.
   * @param targetName 대상의 이름.
   *
   * @throws IllegalArgumentException 대상이 0보다 클 때.
   */
  public static void notPositive(long target, String targetName) throws IllegalArgumentException {
    if (0 < target) {
      throw new IllegalArgumentException(format("%s is positive : %d", name(targetName), target));
    }
  }

  /**
   * 단정 대상이 {@code null} 이거나 빈 문자열이면 실패.
   *
   * @param target 단정 대상.
   *
   * @throws IllegalArgumentException 단정 대상이 {@code null} 이거나 빈 문자열일 때.
   */
  public static void notEmpty(String target) throws IllegalArgumentException {
    if (null == target) {
      throw new IllegalArgumentException(DEFAULT_TARGET_NAME + " is null.");
    } else if (target.isEmpty()) {
      throw new IllegalArgumentException(DEFAULT_TARGET_NAME + " is empty.");
    }
  }

  /**
   * 단정 대상이 {@code null} 이거나 빈 문자열이면 실패.
   *
   * @param target     단정 대상.
   * @param targetName 단정 대상의 이름.
   *
   * @throws IllegalArgumentException 단정 대상이 {@code null} 이거나 빈 문자열일 때.
   */
  public static void notEmpty(String target, String targetName) throws IllegalArgumentException {
    if (null == target) {
      throw new IllegalArgumentException(name(targetName) + " is null.");
    } else if (target.isEmpty()) {
      throw new IllegalArgumentException(name(targetName) + " is empty.");
    }
  }

  /**
   * 대상 배열이 {@code null}이거나 길이가 0이면 실패.
   *
   * @param target 단정 대상.
   *
   * @throws IllegalArgumentException 대상이 {@code null}이거나 길이가 0일 때.
   */
  public static void notEmpty(byte[] target) throws IllegalArgumentException {
    if (null == target) {
      throw new IllegalArgumentException(DEFAULT_TARGET_NAME + " is null.");
    } else if (0 == target.length) {
      throw new IllegalArgumentException(DEFAULT_TARGET_NAME + " is empty.");
    }
  }

  /**
   * 대상 배열이 {@code null}이거나 길이가 0이면 실패.
   *
   * @param target     단정 대상.
   * @param targetName 단정 대상의 이름.
   *
   * @throws IllegalArgumentException 대상이 {@code null}이거나 길이가 0일 때.
   */
  public static void notEmpty(byte[] target, String targetName) throws IllegalArgumentException {
    if (null == target) {
      throw new IllegalArgumentException(name(targetName) + " is null.");
    } else if (0 == target.length) {
      throw new IllegalArgumentException(name(targetName) + " is empty.");
    }
  }

  public static void noWhitespace(String target) throws IllegalArgumentException {
    noWhitespace(target, DEFAULT_TARGET_NAME);
  }

  public static void noWhitespace(String target, String name) throws IllegalArgumentException {
    if (null == target)
      throw new IllegalArgumentException(name(name) + " is null.");
    if (null == name)
      throw new IllegalArgumentException("name is null.");
    else if (name.isEmpty())
      throw new IllegalArgumentException("name is empty.");

    if (!target.matches("\\S*"))
      throw new IllegalArgumentException(format("%s contains whitespace character(s) : '%s'", name(name), target));
  }

  /**
   * 단정 대상 문자열이 지정한 패턴이 아니면 실패.
   *
   * @param target  단정 대상.
   * @param pattern 비교할 정규 표현식.
   *
   * @throws IllegalArgumentException 단정 대상 문자열이 지정한 패턴이 아닐 때.
   * @see String#matches(String)
   */
  public static void matches(String target, String pattern) throws IllegalArgumentException {
    if (null == target) {
      throw new IllegalArgumentException(DEFAULT_TARGET_NAME + " is null.");
    }
    if (null == pattern) {
      throw new IllegalArgumentException("pattern is null.");
    }

    try {
      if (!target.matches(pattern)) {
        throw new IllegalArgumentException(format("%s does not match : pattern='%s', target='%s'",
            DEFAULT_TARGET_NAME, pattern, target));
      }
    } catch (PatternSyntaxException e) {
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
   * @throws IllegalArgumentException 단정 대상 문자열이 지정한 패턴이 아닐 때.
   * @see String#matches(String)
   */
  public static void matches(String target, String pattern, String targetName) throws IllegalArgumentException {
    if (null == target) {
      throw new IllegalArgumentException(name(targetName) + " is null.");
    }
    if (null == pattern) {
      throw new IllegalArgumentException("pattern is null.");
    }

    try {
      if (!target.matches(pattern)) {
        throw new IllegalArgumentException(format("%s does not match : pattern='%s', target='%s'",
            name(targetName), pattern, target));
      }
    } catch (PatternSyntaxException e) {
      throw new IllegalArgumentException(format("illegal pattern : pattern='%s'", pattern), e);
    }
  }

  /**
   * {@code after or equal to}
   *
   * @param target
   * @param comp
   */
  public static void ae(Instant target, Instant comp) {
    ae(target, comp, DEFAULT_TARGET_NAME);
  }

  /**
   * {@code after or equal to}
   *
   * @param target
   * @param comp
   * @param targetName
   */
  public static void ae(Instant target, Instant comp, String targetName) {
    if (null == target) {
      throw new IllegalArgumentException(name(targetName) + " is null.");
    }
    if (null == comp) {
      throw new IllegalArgumentException("comp is null.");
    }

    if (target.isBefore(comp)) {
      throw new IllegalArgumentException(format("%s is not after or equal to compare : compare=%s, target=%s",
          name(targetName), comp, target));
    }
  }

  /**
   * 대상의 클래스를 검사한다.
   *
   * @param target 검사 대상.
   * @param clz    기대하는 클래스.
   */
  public static void typeOf(Object target, Class clz) {
    typeOf(target, clz, null);
  }

  /**
   * 대상의 클래스를 검사한다.
   *
   * @param target     검사 대상.
   * @param clz        기대하는 클래스.
   * @param targetName 검사 대상의 이름.
   */
  public static void typeOf(Object target, Class clz, String targetName) {
    if (null == clz) {
      throw new IllegalArgumentException("clz is null.");
    } else if (null == target || target.getClass().equals(clz)) {
      return;
    }

    throw new IllegalArgumentException(format("%s is not instance of %s", name(targetName), clz.getName()));
  }

  /**
   * 대상이 컬렉션에 포함되어 있는지 시험한다.
   *
   * @param target     시험 대상.
   * @param collection 컬렉션.
   * @param <T>        대상의 타입.
   *
   * @throws IllegalArgumentException 시험 대상이 컬렉션에 포함되어있지 않을 때.
   */
  public static <T> void in(T target, Collection<T> collection) throws IllegalArgumentException {
    if (null == target) {
      throw new IllegalArgumentException("target is null.");
    }
    if (null == collection) {
      throw new IllegalArgumentException("collection is null.");
    }

    if (!collection.contains(target)) {
      throw new IllegalArgumentException(format("%s is not in collection : target=%s, collection=%s",
          DEFAULT_TARGET_NAME, target, collection));
    }
  }

  /**
   * 대상이 컬렉션에 포함되어 있는지 시험한다.
   *
   * @param target     시험 대상.
   * @param collection 컬렉션.
   * @param targetName 시험 대상의 이름.
   * @param <T>        대상의 타입.
   *
   * @throws IllegalArgumentException 시험 대상이 컬렉션에 포함되어있지 않을 때.
   */
  public static <T> void in(T target, Collection<T> collection, String targetName) throws IllegalArgumentException {
    if (null == target) {
      throw new IllegalArgumentException("target is null.");
    }
    if (null == collection) {
      throw new IllegalArgumentException("collection is null.");
    }

    if (!collection.contains(target)) {
      throw new IllegalArgumentException(format("%s is not in collection : target=%s, collection=%s",
          name(targetName), target, collection));
    }
  }

  protected Arguments() {
    throw new UnsupportedOperationException("does not support instance.");
  }
}
