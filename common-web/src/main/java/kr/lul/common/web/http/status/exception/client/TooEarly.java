package kr.lul.common.web.http.status.exception.client;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http4xxException;

/**
 * http status 425
 *
 * @author justburrow
 * @since 2020/01/14
 */
public class TooEarly extends Http4xxException {
  public static final int STATUS_CODE = HttpStatusCodes.TOO_EARLY;

  public TooEarly() {
    super(STATUS_CODE);
  }

  public TooEarly(final String message) {
    super(STATUS_CODE, message);
  }

  public TooEarly(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }

  public TooEarly(final Throwable cause) {
    super(STATUS_CODE, cause);
  }
}
