package kr.lul.common.web.http.status.exception.success;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http2xxException;

/**
 * http status 200.
 *
 * @author justburrow
 * @since 2020/01/14
 */
public class OK extends Http2xxException {
  public static final int STATUS_CODE = HttpStatusCodes.OK;

  public OK() {
    super(STATUS_CODE);
  }

  public OK(final String message) {
    super(STATUS_CODE, message);
  }

  public OK(final Throwable cause) {
    super(STATUS_CODE, cause);
  }

  public OK(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }
}
