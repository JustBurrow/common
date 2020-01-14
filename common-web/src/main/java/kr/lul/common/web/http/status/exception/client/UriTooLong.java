package kr.lul.common.web.http.status.exception.client;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http4xxException;

/**
 * http status 414
 *
 * @author justburrow
 * @since 2020/01/14
 */
public class UriTooLong extends Http4xxException {
  public static final int STATUS_CODE = HttpStatusCodes.URI_TOO_LONG;

  public UriTooLong() {
    super(STATUS_CODE);
  }

  public UriTooLong(final String message) {
    super(STATUS_CODE, message);
  }

  public UriTooLong(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }

  public UriTooLong(final Throwable cause) {
    super(STATUS_CODE, cause);
  }
}
