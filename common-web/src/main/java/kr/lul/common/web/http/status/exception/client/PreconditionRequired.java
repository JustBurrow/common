package kr.lul.common.web.http.status.exception.client;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http4xxException;

/**
 * http status 428.
 *
 * @author justburrow
 * @since 2020/01/14
 */
public class PreconditionRequired extends Http4xxException {
  public static final int STATUS_CODE = HttpStatusCodes.PRECONDITION_REQUIRED;

  public PreconditionRequired() {
    super(STATUS_CODE);
  }

  public PreconditionRequired(final String message) {
    super(STATUS_CODE, message);
  }

  public PreconditionRequired(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }

  public PreconditionRequired(final Throwable cause) {
    super(STATUS_CODE, cause);
  }
}
