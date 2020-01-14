package kr.lul.common.web.http.status.exception;

/**
 * Client request error.
 *
 * @author justburrow
 * @since 2020/01/14
 */
public class Http4xxException extends HttpException {
  public Http4xxException(final int statusCode) {
    super(statusCode);
  }

  public Http4xxException(final int statusCode, final String message) {
    super(statusCode, message);
  }

  public Http4xxException(final int statusCode, final Throwable cause) {
    super(statusCode, cause);
  }

  public Http4xxException(final int statusCode, final String message, final Throwable cause) {
    super(statusCode, message, cause);
  }
}
