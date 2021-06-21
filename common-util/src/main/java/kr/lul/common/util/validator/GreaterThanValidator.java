package kr.lul.common.util.validator;

import kr.lul.common.util.AbstractTargetNameDefinedValidator;
import kr.lul.common.util.ValidationException;

import static java.lang.String.format;
import static kr.lul.common.util.Arguments.notNull;

/**
 * @author justburrow
 * @since 2019/11/16
 */
public class GreaterThanValidator<C extends Comparable<C>> extends AbstractTargetNameDefinedValidator<C> {
  private C lowerBound;

  public GreaterThanValidator(String targetName, C lowerBound) {
    super(targetName);
    notNull(lowerBound, "lowerBound");

    this.lowerBound = lowerBound;
  }

  @Override
  public C validate(C target) throws ValidationException {
    if (null == target)
      throw new ValidationException(this.targetName, null, this.targetName + " is null.");

    if (this.lowerBound == target || 0 <= this.lowerBound.compareTo(target))
      throw new ValidationException(this.targetName, target,
          format("%s is not greater than lower bound : %s=%s, lowerBound=%s",
              this.targetName, this.targetName, target, this.lowerBound));

    return target;
  }

  @Override
  public String toString() {
    return format("%s{targetName='%s', lowerBound=%s}",
        GreaterThanValidator.class.getSimpleName(), this.targetName, this.lowerBound);
  }
}
