package kr.lul.common.util.validator;

import kr.lul.common.util.AbstractTargetNameDefinedValidator;
import kr.lul.common.util.ValidationException;

import static java.lang.String.format;
import static kr.lul.common.util.Arguments.notNull;

/**
 * @author justburrow
 * @since 2019/11/16
 */
public class LessThanValidator<C extends Comparable<C>> extends AbstractTargetNameDefinedValidator<C> {
  private C upperBound;

  public LessThanValidator(String targetName, C upperBound) {
    super(targetName);

    notNull(upperBound, "upperBound");
    this.upperBound = upperBound;
  }

  @Override
  public C validate(C target) throws ValidationException {
    if (null == target)
      throw new ValidationException(this.targetName, null, this.targetName + " is null.");

    if (this.upperBound == target || 0 >= this.upperBound.compareTo(target))
      throw new ValidationException(this.targetName, target,
          format("%s is not less than upper bound : %s=%s, upperBound=%s",
              this.targetName, this.targetName, target, this.upperBound));

    return target;
  }

  @Override
  public String toString() {
    return format("%s{targetName='%s', upperBound=%s}",
        LessThanValidator.class.getSimpleName(), this.targetName, this.upperBound);
  }
}
