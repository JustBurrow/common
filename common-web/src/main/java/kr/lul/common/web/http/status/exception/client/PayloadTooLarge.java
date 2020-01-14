package kr.lul.common.web.http.status.exception.client;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http4xxException;

/**
 * http status 413
 *
 * @author justburrow
 * @since 2020/01/14
 */
public class PayloadTooLarge extends Http4xxException {
  public static final int STATUS_CODE = HttpStatusCodes.PAYLOAD_TOO_LARGE;

  public PayloadTooLarge() {
    super(STATUS_CODE);
  }

  public PayloadTooLarge(final String message) {
    super(STATUS_CODE, message);
  }

  public PayloadTooLarge(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }

  public PayloadTooLarge(final Throwable cause) {
    super(STATUS_CODE, cause);
  }
}
