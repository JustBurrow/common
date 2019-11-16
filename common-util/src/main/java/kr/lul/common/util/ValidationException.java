package kr.lul.common.util;

import static java.lang.String.format;

/**
 * 검증 실패 오류.
 *
 * @author justburrow
 * @since 2019/11/16
 */
public class ValidationException extends RuntimeException {
  public static final String TARGET_UNDEFINED = "UNDEFINED";
  /**
   * 검증 대상의 이름.
   */
  private final String targetName;
  /**
   * 검증에 실패한 값.
   */
  private final Object target;

  public ValidationException(Object target) {
    this(TARGET_UNDEFINED, target);
  }

  public ValidationException(String targetName, Object target) {
    this(TARGET_UNDEFINED, target, "unknown reason.");
  }

  public ValidationException(String targetName, Object target, String message) {
    super(message);

    if (null == targetName || targetName.isEmpty())
      this.targetName = TARGET_UNDEFINED;
    else
      this.targetName = targetName;

    this.target = target;
  }

  public ValidationException(String targetName, Object target, Throwable cause) {
    super(cause);

    if (null == targetName || targetName.isEmpty())
      this.targetName = TARGET_UNDEFINED;
    else
      this.targetName = targetName;

    this.target = target;
  }

  public ValidationException(String targetName, Object target, String message, Throwable cause) {
    super(message, cause);

    if (null == targetName || targetName.isEmpty())
      this.targetName = TARGET_UNDEFINED;
    else
      this.targetName = targetName;

    this.target = target;
  }

  public String getTargetName() {
    return this.targetName;
  }

  public Object getTarget() {
    return this.target;
  }

  @Override
  public String toString() {
    return format("targetName='%s', target=%s, message=%s", this.targetName, this.target, getMessage());
  }
}
