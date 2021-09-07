package kr.lul.common.util;

/**
 * @author justburrow
 * @since 2021/09/07
 */
public abstract class ComparableUtils {
  @SafeVarargs
  public static <C extends Comparable<C>> C max(C arg0, C arg1, C... extra) {
    C max = 0 < arg0.compareTo(arg1)
        ? arg0
        : arg1;

    for (C a : extra) {
      if (0 < a.compareTo(max))
        max = a;
    }

    return max;
  }

  @SafeVarargs
  public static <C extends Comparable<C>> C min(C arg0, C arg1, C... extra) {
    C max = 0 > arg0.compareTo(arg1)
        ? arg0
        : arg1;

    for (C a : extra) {
      if (0 > a.compareTo(max))
        max = a;
    }

    return max;
  }

  protected ComparableUtils() {
    throw new UnsupportedOperationException();
  }
}