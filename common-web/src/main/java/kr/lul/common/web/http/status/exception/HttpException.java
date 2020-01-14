package kr.lul.common.web.http.status.exception;

/**
 * @author justburrow
 * @since 2020/01/14
 */
public class HttpException extends RuntimeException {
  protected int statusCode;

  public HttpException(final int statusCode) {
    this.statusCode = statusCode;
  }

  public HttpException(final int statusCode, final String message) {
    super(message);
    this.statusCode = statusCode;
  }

  public HttpException(final int statusCode, final String message, final Throwable cause) {
    super(message, cause);
    this.statusCode = statusCode;
  }

  public HttpException(final int statusCode, final Throwable cause) {
    super(cause);
    this.statusCode = statusCode;
  }

  public int getStatusCode() {
    return this.statusCode;
  }
}
