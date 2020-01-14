package kr.lul.common.web.http.status.exception.server;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http5xxException;

/**
 * @author justburrow
 * @since 2020/01/14
 */
public class InternalServerError extends Http5xxException {
  public static final int STATUS_CODE = HttpStatusCodes.INTERNAL_SERVER_ERROR;

  public InternalServerError() {
    super(STATUS_CODE);
  }

  public InternalServerError(final String message) {
    super(STATUS_CODE, message);
  }

  public InternalServerError(final Throwable cause) {
    super(STATUS_CODE, cause);
  }

  public InternalServerError(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }
}
