package kr.lul.common.web.http.status.exception.client;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http4xxException;

/**
 * http status 410
 *
 * @author justburrow
 * @since 2020/01/14
 */
public class Gone extends Http4xxException {
  public static final int STATUS_CODE = HttpStatusCodes.GONE;

  public Gone() {
    super(STATUS_CODE);
  }

  public Gone(final String message) {
    super(STATUS_CODE, message);
  }

  public Gone(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }

  public Gone(final Throwable cause) {
    super(STATUS_CODE, cause);
  }
}
