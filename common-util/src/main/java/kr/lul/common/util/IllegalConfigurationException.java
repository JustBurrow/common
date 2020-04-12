package kr.lul.common.util;

/**
 * 설정이 잘못된 경우의 예외.
 *
 * @author justburrow
 * @since 2020/04/12
 */
public class IllegalConfigurationException extends RuntimeException {
  public IllegalConfigurationException() {
    super();
  }

  public IllegalConfigurationException(final String message) {
    super(message);
  }

  public IllegalConfigurationException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public IllegalConfigurationException(final Throwable cause) {
    super(cause);
  }
}
