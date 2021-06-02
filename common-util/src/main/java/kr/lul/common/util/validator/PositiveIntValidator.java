package kr.lul.common.util.validator;

import kr.lul.common.util.AbstractTargetNameDefinedValidator;
import kr.lul.common.util.ValidationException;

import static java.lang.String.format;

/**
 * @author justburrow
 * @since 2021/06/02
 */
public class PositiveIntValidator extends AbstractTargetNameDefinedValidator<Integer> {
  public PositiveIntValidator() {
    this("number");
  }

  public PositiveIntValidator(String targetName) {
    super(targetName);
  }

  public int validate(int target) throws ValidationException {
    if (0L >= target)
      throw new ValidationException(this.targetName, target,
          format("%s is not positive : %d", this.targetName, target));

    return target;
  }

  @Override
  public Integer validate(Integer target) throws ValidationException {
    if (null == target)
      throw new ValidationException(this.targetName, target, format("%s is null.", this.targetName));

    return validate((int) target);
  }
}