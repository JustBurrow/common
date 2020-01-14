package kr.lul.common.web.http.status.exception.client;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http4xxException;

/**
 * http status 408
 *
 * @author justburrow
 * @since 2020/01/14
 */
public class RequestTimeout extends Http4xxException {
  public static final int STATUS_CODE = HttpStatusCodes.REQUEST_TIMEOUT;

  public RequestTimeout() {
    super(STATUS_CODE);
  }

  public RequestTimeout(final String message) {
    super(STATUS_CODE, message);
  }

  public RequestTimeout(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }

  public RequestTimeout(final Throwable cause) {
    super(STATUS_CODE, cause);
  }
}
