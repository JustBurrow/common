package kr.lul.common.util;

import static kr.lul.common.util.Arguments.noWhitespace;
import static kr.lul.common.util.Arguments.notEmpty;

/**
 * @author justburrow
 * @since 2019/11/16
 */
public abstract class AbstractTargetNameDefinedValidator<T> implements Validator<T> {
  protected final String targetName;

  public AbstractTargetNameDefinedValidator(String targetName) {
    notEmpty(targetName, "targetName");

    this.targetName = noWhitespace(targetName, "targetName");
  }

  public String getTargetName() {
    return this.targetName;
  }
}
