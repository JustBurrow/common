package kr.lul.common.util;

import java.util.Objects;

import static java.lang.String.format;
import static kr.lul.common.util.Arguments.notNull;

/**
 * 하나의 연속적인 범위를 지정하기 위한 타입.
 *
 * @param <C> 범위 타입.
 *
 * @author justburrow
 * @since 2019/11/16
 */
public class ContinuousRange<C extends Comparable<C>> implements Range<C> {
  private final C lowerBound;
  private final boolean includeLowerBound;
  private final C upperBound;
  private final boolean includeUpperBound;

  public ContinuousRange() {
    this(null, false, null, false);
  }

  public ContinuousRange(C lowerBound, C upperBound) {
    this(lowerBound, true, upperBound, false);
  }

  public ContinuousRange(C lowerBound, boolean includeLowerBound, C upperBound, boolean includeUpperBound) {
    this.lowerBound = lowerBound;
    this.upperBound = upperBound;

    if (null != lowerBound && null != upperBound && 0 > upperBound.compareTo(lowerBound))
      throw new IllegalArgumentException(format("upper bound is less than lower bound : lowerBound=%s upperBound=%s",
          lowerBound, upperBound));

    this.includeLowerBound = includeLowerBound;
    this.includeUpperBound = includeUpperBound;
  }

  public C getLowerBound() {
    return this.lowerBound;
  }

  public boolean isIncludeLowerBound() {
    return this.includeLowerBound;
  }

  public C getUpperBound() {
    return this.upperBound;
  }

  public boolean isIncludeUpperBound() {
    return this.includeUpperBound;
  }

  @Override
  public boolean isInclude(C comparee) {
    notNull(comparee, "comparee");

    boolean inRange;

    if (null == this.lowerBound) {
      inRange = true;
    } else {
      inRange = this.includeLowerBound
          ? 0 >= this.lowerBound.compareTo(comparee)
          : 0 > this.lowerBound.compareTo(comparee);
    }

    if (null != this.upperBound) {
      inRange &= this.includeUpperBound
          ? 0 <= this.upperBound.compareTo(comparee)
          : 0 < this.upperBound.compareTo(comparee);
    }

    return inRange;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof ContinuousRange)) return false;
    ContinuousRange<?> that = (ContinuousRange<?>) o;
    return this.includeLowerBound == that.includeLowerBound &&
        this.includeUpperBound == that.includeUpperBound &&
        Objects.equals(this.lowerBound, that.lowerBound) &&
        Objects.equals(this.upperBound, that.upperBound);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.lowerBound, this.includeLowerBound, this.upperBound, this.includeUpperBound);
  }

  @Override
  public String toString() {
    return new StringBuilder()
        .append(this.includeLowerBound ? '[' : '(')
        .append(null == this.lowerBound ? "-\u221E" : this.lowerBound)
        .append(',')
        .append(null == this.upperBound ? '\u221E' : this.upperBound)
        .append(this.includeUpperBound ? ']' : ')')
        .toString();
  }
}
