package kr.lul.common.util.validator;

import kr.lul.common.util.AbstractTargetNameDefinedValidator;
import kr.lul.common.util.ValidationException;

import java.util.regex.Pattern;

import static java.lang.String.format;
import static kr.lul.common.util.Arguments.matches;
import static kr.lul.common.util.Arguments.notNull;

/**
 * @author justburrow
 * @since 2019/11/16
 */
public class RegexValidator<T> extends AbstractTargetNameDefinedValidator<String> {
  private String regex;

  public RegexValidator(String target, String regex) {
    super(target);

    Pattern.compile(regex);
    this.regex = regex;
  }

  public String getRegex() {
    return this.regex;
  }

  @Override
  public void validate(String target) throws ValidationException {
    try {
      notNull(target, this.targetName);
      matches(target, this.regex, this.targetName);
    } catch (IllegalArgumentException e) {
      throw new ValidationException(this.targetName, target, e);
    }
  }

  @Override
  public String toString() {
    return format("%s{targetName='%s', regex='%s'}}", RegexValidator.class.getSimpleName(), this.targetName, this.regex);
  }
}
