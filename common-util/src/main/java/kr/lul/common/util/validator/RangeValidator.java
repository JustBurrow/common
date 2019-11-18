package kr.lul.common.util.validator;

import kr.lul.common.util.AbstractTargetNameDefinedValidator;
import kr.lul.common.util.Range;
import kr.lul.common.util.ValidationException;

import static java.lang.String.format;
import static kr.lul.common.util.Arguments.notNull;

/**
 * @author justburrow
 * @since 2019/11/19
 */
public class RangeValidator<T extends Comparable<T>> extends AbstractTargetNameDefinedValidator<T> {
  private Range<T> range;

  public RangeValidator(String targetName, Range<T> range) {
    super(targetName);

    notNull(range, "range");
    this.range = range;
  }

  @Override
  public void validate(T target) throws ValidationException {
    try {
      if (!this.range.isInclude(target)) {
        throw new ValidationException(this.targetName, target,
            format("%s is out of range : %s=%s, range=%s", this.targetName, this.targetName, target, this.range));
      }
    } catch (IllegalArgumentException e) {
      throw new ValidationException(this.targetName, target, e);
    }
  }

  @Override
  public String toString() {
    return format("%s{targetName='%s', range=%s}", RangeValidator.class.getSimpleName(), this.targetName, this.range);
  }
}
