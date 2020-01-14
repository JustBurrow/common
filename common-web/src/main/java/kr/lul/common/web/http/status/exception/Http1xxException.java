package kr.lul.common.web.http.status.exception;

/**
 * 1XX Informational response.
 *
 * @author justburrow
 * @since 2020/01/14
 */
public class Http1xxException extends HttpException {
  public Http1xxException(final int statusCode) {
    super(statusCode);
  }

  public Http1xxException(final int statusCode, final String message) {
    super(statusCode, message);
  }

  public Http1xxException(final int statusCode, final Throwable cause) {
    super(statusCode, cause);
  }

  public Http1xxException(final int statusCode, final String message, final Throwable cause) {
    super(statusCode, message, cause);
  }
}
