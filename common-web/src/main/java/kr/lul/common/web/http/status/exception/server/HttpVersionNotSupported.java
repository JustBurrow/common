package kr.lul.common.web.http.status.exception.server;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http5xxException;

/**
 * @author justburrow
 * @since 2020/01/14
 */
public class HttpVersionNotSupported extends Http5xxException {
  public static final int STATUS_CODE = HttpStatusCodes.HTTP_VERSION_NOT_SUPPORTED;

  public HttpVersionNotSupported() {
    super(STATUS_CODE);
  }

  public HttpVersionNotSupported(final String message) {
    super(STATUS_CODE, message);
  }

  public HttpVersionNotSupported(final Throwable cause) {
    super(STATUS_CODE, cause);
  }

  public HttpVersionNotSupported(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }
}
