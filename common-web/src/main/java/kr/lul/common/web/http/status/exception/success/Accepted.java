package kr.lul.common.web.http.status.exception.success;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http2xxException;

/**
 * @author justburrow
 * @since 2020/01/14
 */
public class Accepted extends Http2xxException {
  public static final int STATUS_CODE = HttpStatusCodes.ACCEPTED;

  public Accepted() {
    super(STATUS_CODE);
  }

  public Accepted(final String message) {
    super(STATUS_CODE, message);
  }

  public Accepted(final Throwable cause) {
    super(STATUS_CODE, cause);
  }

  public Accepted(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }
}
