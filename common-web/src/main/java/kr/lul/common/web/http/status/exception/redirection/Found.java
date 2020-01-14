package kr.lul.common.web.http.status.exception.redirection;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http3xxException;

/**
 * @author justburrow
 * @since 2020/01/14
 */
public class Found extends Http3xxException {
  public static final int STATUS_CODE = HttpStatusCodes.FOUND;

  public Found() {
    super(STATUS_CODE);
  }

  public Found(final String message) {
    super(STATUS_CODE, message);
  }

  public Found(final Throwable cause) {
    super(STATUS_CODE, cause);
  }

  public Found(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }
}
