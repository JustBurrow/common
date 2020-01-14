package kr.lul.common.web.http.status.exception.client;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http4xxException;

/**
 * http status 412
 *
 * @author justburrow
 * @since 2020/01/14
 */
public class PreconditionFailed extends Http4xxException {
  public static final int STATUS_CODE = HttpStatusCodes.PRECONDITION_FAILED;

  public PreconditionFailed() {
    super(STATUS_CODE);
  }

  public PreconditionFailed(final String message) {
    super(STATUS_CODE, message);
  }

  public PreconditionFailed(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }

  public PreconditionFailed(final Throwable cause) {
    super(STATUS_CODE, cause);
  }
}
