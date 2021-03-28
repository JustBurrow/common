package kr.lul.common.util;

import java.util.function.*;

import static kr.lul.common.util.Arguments.notNull;

/**
 * @author justburrow
 * @see <a  href="https://kotlinlang.org/docs/scope-functions.html">Scope functions</a>
 * @since 2021/03/28
 */
public abstract class ScopeFunctions {
  public static void let(final boolean it, BooleanConsumer block) {
    notNull(block, "block")
        .accept(it);
  }

  public static void let(final byte it, ByteConsumer block) {
    notNull(block, "block")
        .accept(it);
  }

  public static void let(final short it, ShortConsumer block) {
    notNull(block, "block")
        .accept(it);
  }

  public static void let(final int it, IntConsumer block) {
    notNull(block, "block")
        .accept(it);
  }

  public static void let(final long it, LongConsumer block) {
    notNull(block, "block")
        .accept(it);
  }

  public static void let(final float it, FloatConsumer block) {
    notNull(block, "block")
        .accept(it);
  }

  public static void let(final double it, DoubleConsumer block) {
    notNull(block, "block")
        .accept(it);
  }

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

  public static <R> R let(final int it, IntFunction<R> block) {
    return notNull(block, "block")
               .apply(it);
  }

  public static <R> R let(final long it, LongFunction<R> block) {
    return notNull(block, "block")
               .apply(it);
  }

  public static <R> R let(final double it, DoubleFunction<R> block) {
    return notNull(block, "block")
               .apply(it);
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

  public static void with(final int it, IntConsumer block) {
    notNull(block, "block")
        .accept(it);
  }

  public static void with(final long it, LongConsumer block) {
    notNull(block, "block")
        .accept(it);
  }

  public static void with(final double it, DoubleConsumer block) {
    notNull(block, "block")
        .accept(it);
  }

  public static <T> void with(final T it, Consumer<T> block) {
    notNull(block, "block")
        .accept(it);
  }

  public static boolean also(final boolean it, BooleanConsumer block) {
    notNull(block, "block")
        .accept(it);
    return it;
  }

  public static byte also(final byte it, ByteConsumer block) {
    notNull(block, "block")
        .accept(it);
    return it;
  }

  public static short also(final short it, ShortConsumer block) {
    notNull(block, "block")
        .accept(it);
    return it;
  }

  public static int also(final int it, IntConsumer block) {
    notNull(block, "block")
        .accept(it);
    return it;
  }

  public static long also(final long it, LongConsumer block) {
    notNull(block, "block")
        .accept(it);
    return it;
  }

  public static float also(final float it, FloatConsumer block) {
    notNull(block, "block")
        .accept(it);
    return it;
  }

  public static double also(final double it, DoubleConsumer block) {
    notNull(block, "block")
        .accept(it);
    return it;
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
