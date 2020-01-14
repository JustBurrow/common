package kr.lul.common.web.http.status.exception.client;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http4xxException;

/**
 * http status 431.
 *
 * @author justburrow
 * @since 2020/01/14
 */
public class RequestHeaderFieldsTooLarge extends Http4xxException {
  public static final int STATUS_CODE = HttpStatusCodes.REQUEST_HEADER_FIELDS_TOO_LARGE;

  public RequestHeaderFieldsTooLarge() {
    super(STATUS_CODE);
  }

  public RequestHeaderFieldsTooLarge(final String message) {
    super(STATUS_CODE, message);
  }

  public RequestHeaderFieldsTooLarge(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }

  public RequestHeaderFieldsTooLarge(final Throwable cause) {
    super(STATUS_CODE, cause);
  }
}
