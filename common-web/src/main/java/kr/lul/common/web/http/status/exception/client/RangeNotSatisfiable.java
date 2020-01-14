package kr.lul.common.web.http.status.exception.client;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http4xxException;

/**
 * http status 416
 *
 * @author justburrow
 * @since 2020/01/14
 */
public class RangeNotSatisfiable extends Http4xxException {
  public static final int STATUS_CODE = HttpStatusCodes.RANGE_NOT_SATISFIABLE;

  public RangeNotSatisfiable() {
    super(STATUS_CODE);
  }

  public RangeNotSatisfiable(final String message) {
    super(STATUS_CODE, message);
  }

  public RangeNotSatisfiable(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }

  public RangeNotSatisfiable(final Throwable cause) {
    super(STATUS_CODE, cause);
  }
}
