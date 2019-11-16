package kr.lul.common.util.validator;

import kr.lul.common.util.AbstractTargetNameDefinedValidator;
import kr.lul.common.util.ValidationException;

import static java.lang.String.format;

/**
 * @author justburrow
 * @since 2019/11/16
 */
public class PositiveLongValidator extends AbstractTargetNameDefinedValidator<Long> {
  public PositiveLongValidator() {
    this("number");
  }

  public PositiveLongValidator(String targetName) {
    super(targetName);
  }

  public void validate(long target) throws ValidationException {
    if (0L >= target)
      throw new ValidationException(this.targetName, target,
          format("%s is not positive : %d", this.targetName, target));
  }

  @Override
  public void validate(Long target) throws ValidationException {
    if (null == target)
      throw new ValidationException(this.targetName, target, format("%s is null.", this.targetName));

    validate((long) target);
  }
}
