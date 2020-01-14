package kr.lul.common.web.http.status.exception;

/**
 * @author justburrow
 * @since 2020/01/14
 */
public class Http3xxException extends HttpException {
  public Http3xxException(final int statusCode) {
    super(statusCode);
  }

  public Http3xxException(final int statusCode, final String message) {
    super(statusCode, message);
  }

  public Http3xxException(final int statusCode, final Throwable cause) {
    super(statusCode, cause);
  }

  public Http3xxException(final int statusCode, final String message, final Throwable cause) {
    super(statusCode, message, cause);
  }
}
