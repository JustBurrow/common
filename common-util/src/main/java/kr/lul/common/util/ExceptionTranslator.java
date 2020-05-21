package kr.lul.common.util;

import java.util.function.Function;

import static kr.lul.common.util.Arguments.notNull;

/**
 * 예외를 변환한다.
 *
 * @author justburrow
 * @since 2020/05/21
 */
public abstract class ExceptionTranslator {
  public interface TryBlock {
    void doTry() throws Throwable;
  }

  /**
   * 예외를 원하는 예외로 변환해서 던진다.
   *
   * @param tryBlock 예외가 발생할 수 있는 로직.
   * @param thrower  던지고 싶은 예외로 변환하는 로직.
   * @param <C>      cause
   * @param <E>      exception
   *
   * @throws E 변환된 예외.
   */
  public static <C extends Throwable, E extends Throwable> void translate(
      final TryBlock tryBlock,
      final Function<Throwable, C> thrower) throws E {
    notNull(tryBlock, "tryBlock");
    notNull(thrower, "thrower");

    try {
      tryBlock.doTry();
    } catch (final Throwable cause) {
      //noinspection unchecked
      throw (E) thrower.apply(cause);
    }
  }

  protected ExceptionTranslator() {
    throw new UnsupportedOperationException();
  }
}
