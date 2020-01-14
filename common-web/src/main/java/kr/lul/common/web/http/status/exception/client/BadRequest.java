package kr.lul.common.web.http.status.exception.client;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http4xxException;

/**
 * HTTP Status 400
 *
 * @author justburrow
 * @since 2020/01/14
 */
public class BadRequest extends Http4xxException {
  public static final int STATUS_CODE = HttpStatusCodes.BAD_REQUEST;

  public BadRequest() {
    super(STATUS_CODE);
  }

  public BadRequest(final String message) {
    super(STATUS_CODE, message);
  }

  public BadRequest(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }

  public BadRequest(final Throwable cause) {
    super(STATUS_CODE, cause);
  }
}
