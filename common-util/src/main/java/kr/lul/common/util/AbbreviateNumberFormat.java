package kr.lul.common.util;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static java.util.Arrays.stream;
import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.toUnmodifiableList;
import static kr.lul.common.util.Arguments.notEmpty;
import static kr.lul.common.util.Arguments.positive;

/**
 * @author justburrow
 * @since 2020/05/20
 */
public class AbbreviateNumberFormat {
  /**
   * 숫자 단위.
   */
  public static class Unit implements Comparable<Unit> {
    /**
     * 단위 표기.
     */
    private final String label;
    /**
     * 단위 크기.
     */
    private final long scale;

    public Unit(final String label, final long scale) {
      notEmpty(label, "label");
      positive(scale, "scale");

      this.label = label;
      this.scale = scale;
    }

    public String getLabel() {
      return this.label;
    }

    public long getScale() {
      return this.scale;
    }

    @Override
    public int compareTo(final Unit o) {
      return Long.compare(this.scale, o.scale);
    }

    @Override
    public boolean equals(final Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      final Unit unit = (Unit) o;
      return this.scale == unit.scale &&
                 this.label.equals(unit.label);
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.label, this.scale);
    }

    @Override
    public String toString() {
      return "1" + this.label + "=" + this.scale;
    }
  }

  /**
   * 10^3 = 1,000
   */
  public static final Unit DECIMAL_KILO = new Unit("K", 1_000L);
  /**
   * 10^6 = 1,000,000
   */
  public static final Unit DECIMAL_MEGA = new Unit("M", 1_000_000L);
  /**
   * 10^9 = 1,000,000,000
   */
  public static final Unit DECIMAL_GIGA = new Unit("G", 1_000_000_000L);
  /**
   * 10^12 = 1,000,000,000,000
   */
  public static final Unit DECIMAL_TERA = new Unit("T", 1_000_000_000_000L);
  /**
   * 10^15 = 1,000,000,000,000,000
   */
  public static final Unit DECIMAL_PETA = new Unit("P", 1_000_000_000_000_000L);
  /**
   * 10^18 = 1,000,000,000,000,000,000
   */
  public static final Unit DECIMAL_EXA = new Unit("E", 1_000_000_000_000_000_000L);

  /**
   * 1000 단위의 10진법용 포맷.
   */
  public static final AbbreviateNumberFormat DECIMAL_FORMAT =
      new AbbreviateNumberFormat(DECIMAL_KILO, DECIMAL_MEGA, DECIMAL_GIGA, DECIMAL_TERA, DECIMAL_PETA, DECIMAL_EXA);

  /**
   * 2^10 = 1,024
   */
  public static final Unit BINARY_KILO = new Unit("K", 1_024L);
  /**
   * 2^20 = 1,048,576
   */
  public static final Unit BINARY_MEGA = new Unit("M", 1_048_576L);
  /**
   * 2^30 = 1,073,741,824
   */
  public static final Unit BINARY_GIGA = new Unit("G", 1_073_741_824L);
  /**
   * 2^40 = 1,099,511,627,776
   */
  public static final Unit BINARY_TERA = new Unit("T", 1_099_511_627_776L);
  /**
   * 2^50 = 1,125,899,906,842,624
   */
  public static final Unit BINARY_PETA = new Unit("P", 1_125_899_906_842_624L);
  /**
   * 2^60 = 1,152,921,504,606,846,976
   */
  public static final Unit BINARY_EXA = new Unit("E", 1_152_921_504_606_846_976L);
  /**
   * 2^10 단위의 2진법용 포맷.
   */
  public static final AbbreviateNumberFormat BINARY_FORMAT =
      new AbbreviateNumberFormat(BINARY_KILO, BINARY_MEGA, BINARY_GIGA, BINARY_TERA, BINARY_PETA, BINARY_EXA);

  /**
   * 오름차순 정리한 단위.
   */
  private List<Unit> units;

  public AbbreviateNumberFormat(final Unit... units) {
    notEmpty(units, "units");

    if (units.length != Set.of(units).size()) {
      throw new IllegalArgumentException("there are duplicated unit(s) : " + Arrays.toString(units));
    }

    this.units = stream(units)
                     .sorted(reverseOrder())
                     .collect(toUnmodifiableList());
  }

  public AbbreviateNumberFormat(final List<Unit> units) {
    notEmpty(units, "units");

    if (units.size() != Set.copyOf(units).size()) {
      throw new IllegalArgumentException("there are duplicated unit(s) : " + units);
    }

    this.units = units.stream()
                     .sorted(reverseOrder())
                     .collect(toUnmodifiableList());
  }

  /**
   * @return 사용 가능한 단위.
   */
  public List<Unit> getUnits() {
    return this.units;
  }

  /**
   * 숫자를 생략한 문자열로 변환.
   *
   * ex) 1234 -&gt; 1K, 1234567 -&gt; 1M
   *
   * @param number 숫자.
   *
   * @return 생략한 문자열.
   */
  public String abbreviate(final long number) {
    for (final Unit unit : this.units) {
      if (0L < number && unit.scale <= number)
        return (number / unit.scale) + unit.label;
      else if (number <= -unit.scale)
        return (number / unit.scale) + unit.label;
    }
    return Long.toString(number);
  }

  @Override
  public String toString() {
    return this.units.toString();
  }
}
