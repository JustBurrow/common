package kr.lul.common.web.http.status.exception.client;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http4xxException;

/**
 * http status 409
 *
 * @author justburrow
 * @since 2020/01/14
 */
public class Conflict extends Http4xxException {
  public static final int STATUS_CODE = HttpStatusCodes.CONFLICT;

  public Conflict() {
    super(STATUS_CODE);
  }

  public Conflict(final String message) {
    super(STATUS_CODE, message);
  }

  public Conflict(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }

  public Conflict(final Throwable cause) {
    super(STATUS_CODE, cause);
  }
}
