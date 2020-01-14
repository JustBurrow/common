package kr.lul.common.web.http.status.exception;

/**
 * 일반적인 반환값이 아닌 반환값이 필요할 때 사용.
 *
 * @author justburrow
 * @since 2020/01/14
 */
public class Http2xxException extends HttpException {
  public Http2xxException(final int statusCode) {
    super(statusCode);
  }

  public Http2xxException(final int statusCode, final String message) {
    super(statusCode, message);
  }

  public Http2xxException(final int statusCode, final Throwable cause) {
    super(statusCode, cause);
  }

  public Http2xxException(final int statusCode, final String message, final Throwable cause) {
    super(statusCode, message, cause);
  }
}
