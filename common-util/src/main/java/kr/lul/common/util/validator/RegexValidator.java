package kr.lul.common.util.validator;

import kr.lul.common.util.AbstractTargetNameDefinedValidator;
import kr.lul.common.util.ValidationException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.String.format;
import static kr.lul.common.util.Arguments.notEmpty;
import static kr.lul.common.util.Arguments.notNull;
import static kr.lul.common.util.Texts.singleQuote;

/**
 * 정규표현식으로 문자열을 검증하는 검증기.
 *
 * @author justburrow
 * @since 2019/11/16
 */
public class RegexValidator extends AbstractTargetNameDefinedValidator<String> {
  private String regex;
  private Pattern pattern;
  private int flags;

  /**
   * 기본 옵션을 사용.
   *
   * @param target 대상 오브젝트 이름.
   * @param regex  정규표현식.
   */
  public RegexValidator(final String target, final String regex) {
    this(target, regex, 0);
  }

  /**
   * 정규표현식 옵션을 사용.
   *
   * @param target 대상 오브젝트 이름.
   * @param regex  정규표현식.
   * @param flags  정규표현식 옵션.
   *
   * @see Pattern#compile(String, int) 참고.
   */
  public RegexValidator(final String target, final String regex, final int flags) {
    super(target);
    notEmpty(regex, "regex");

    this.regex = regex;
    this.pattern = Pattern.compile(regex, flags);
    this.flags = flags;
  }

  public String getRegex() {
    return this.regex;
  }

  public Pattern getPattern() {
    return this.pattern;
  }

  public int getFlags() {
    return this.flags;
  }

  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // kr.lul.common.util.Validator
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  @Override
  public String validate(final String target) throws ValidationException {
    try {
      notNull(target, this.targetName);

      final Matcher matcher = this.pattern.matcher(target);
      if (!matcher.matches())
        throw new ValidationException(this.targetName, target, format("illegal %s pattern : %s=%s, pattern=%s",
            this.targetName, this.targetName, singleQuote(target), this.pattern));

      return target;
    } catch (final IllegalArgumentException e) {
      throw new ValidationException(this.targetName, target, e);
    }
  }

  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // java.lang.Object
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  @Override
  public String toString() {
    return new StringBuilder(RegexValidator.class.getSimpleName())
        .append("{targetName=").append(singleQuote(this.targetName))
        .append("regex=").append(singleQuote(this.regex))
        .append(", pattern=").append(this.pattern)
        .append(", flags=").append(this.flags)
        .append('}').toString();
  }
}
