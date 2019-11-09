package kr.lul.common.util;

/**
 * @author justburrow
 * @since 2019/11/04
 */
public class ComposeException extends RuntimeException {
  public ComposeException() {
  }

  public ComposeException(String message) {
    super(message);
  }

  public ComposeException(String message, Throwable cause) {
    super(message, cause);
  }

  public ComposeException(Throwable cause) {
    super(cause);
  }
}
