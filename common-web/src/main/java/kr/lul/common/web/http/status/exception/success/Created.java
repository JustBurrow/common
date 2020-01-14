package kr.lul.common.web.http.status.exception.success;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http2xxException;

/**
 * @author justburrow
 * @since 2020/01/14
 */
public class Created extends Http2xxException {
  public static final int STATUS_CODE = HttpStatusCodes.CREATED;

  public Created() {
    super(STATUS_CODE);
  }

  public Created(final String message) {
    super(STATUS_CODE, message);
  }

  public Created(final Throwable cause) {
    super(STATUS_CODE, cause);
  }

  public Created(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }
}
