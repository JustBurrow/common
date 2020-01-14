package kr.lul.common.web.http.status.exception.informationalresponse;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http1xxException;

/**
 * @author justburrow
 * @since 2020/01/14
 */
public class Continue extends Http1xxException {
  public static final int STATUS_CODE = HttpStatusCodes.CONTINUE;

  public Continue() {
    super(STATUS_CODE);
  }

  public Continue(final String message) {
    super(STATUS_CODE, message);
  }

  public Continue(final Throwable cause) {
    super(STATUS_CODE, cause);
  }

  public Continue(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }
}
