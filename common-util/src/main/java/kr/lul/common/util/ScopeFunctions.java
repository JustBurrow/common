package kr.lul.common.util;

import java.util.function.Consumer;
import java.util.function.Function;

import static kr.lul.common.util.Arguments.notNull;

/**
 * @author justburrow
 * @see <a  href="https://kotlinlang.org/docs/scope-functions.html">Scope functions</a>
 * @since 2021/03/28
 */
public abstract class ScopeFunctions {
  /**
   * @param it    컨텍스트 오브젝트.
   * @param block 블록.
   * @param <T>   컨텍스트 오브젝트 타입.
   *
   * @see <a href="https://kotlinlang.org/docs/scope-functions.html#let">let</a>
   */
  public static <T> void let(final T it, Consumer<T> block) {
    notNull(block, "block")
        .accept(it);
  }

  /**
   * @param it    컨텍스트 오브젝트.
   * @param block 블록.
   * @param <T>   컨텍스트 오브젝트 타입.
   * @param <R>   블록 리턴 타입.
   *
   * @see <a href="https://kotlinlang.org/docs/scope-functions.html#let">let</a>
   */
  public static <T, R> R let(final T it, Function<T, R> block) {
    return notNull(block, "block")
               .apply(it);
  }

  public static <T> void with(final T it, Consumer<T> block) {
    notNull(block, "block")
        .accept(it);
  }

  /**
   * @param it    컨텍스트 오브젝트.
   * @param block 블록.
   * @param <T>   컨텍스트 오브젝트 타입.
   *
   * @see <a href="https://kotlinlang.org/docs/scope-functions.html#also">also</a>
   */
  public static <T> T also(final T it, Consumer<T> block) {
    notNull(block, "block")
        .accept(it);
    return it;
  }

  public ScopeFunctions() {
    throw new UnsupportedOperationException();
  }
}
