package kr.lul.common.web.http.status.exception.success;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http2xxException;

/**
 * @author justburrow
 * @since 2020/01/14
 */
public class MultiStatus extends Http2xxException {
  public static final int STATUS_CODE = HttpStatusCodes.MULTI_STATUS;

  public MultiStatus() {
    super(STATUS_CODE);
  }

  public MultiStatus(final String message) {
    super(STATUS_CODE, message);
  }

  public MultiStatus(final Throwable cause) {
    super(STATUS_CODE, cause);
  }

  public MultiStatus(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }
}
