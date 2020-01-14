package kr.lul.common.web.http.status.exception.success;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http2xxException;

/**
 * @author justburrow
 * @since 2020/01/14
 */
public class AlreadyReported extends Http2xxException {
  public static final int STATUS_CODE = HttpStatusCodes.ALREADY_REPORTED;

  public AlreadyReported() {
    super(STATUS_CODE);
  }

  public AlreadyReported(final String message) {
    super(STATUS_CODE, message);
  }

  public AlreadyReported(final Throwable cause) {
    super(STATUS_CODE, cause);
  }

  public AlreadyReported(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }
}
