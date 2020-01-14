package kr.lul.common.web.http.status.exception.client;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http4xxException;

/**
 * http status 405
 *
 * @author justburrow
 * @since 2020/01/14
 */
public class MethodNotAllowed extends Http4xxException {
  public static final int STATUS_CODE = HttpStatusCodes.METHOD_NOT_ALLOWED;

  public MethodNotAllowed() {
    super(STATUS_CODE);
  }

  public MethodNotAllowed(final String message) {
    super(STATUS_CODE, message);
  }

  public MethodNotAllowed(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }

  public MethodNotAllowed(final Throwable cause) {
    super(STATUS_CODE, cause);
  }
}
