package kr.lul.common.util;

/**
 * 비활성화된 어떤 속성으로 인한 예외.
 *
 * @author justburrow
 * @since 2020/01/15
 */
public class DisabledPropertyException extends IllegalStateException {
  private String property;

  public DisabledPropertyException(final String property) {
    this(property, property + " is disabled.");
  }

  public DisabledPropertyException(final String property, final String message) {
    super(message);
    this.property = property;
  }

  public DisabledPropertyException(final String property, final Throwable cause) {
    super(cause);
    this.property = property;
  }

  public DisabledPropertyException(final String property, final String message, final Throwable cause) {
    super(message, cause);
    this.property = property;
  }

  /**
   * @return 비활성화된 속성 이름.
   */
  public String getProperty() {
    return this.property;
  }
}
