package kr.lul.common.web.http.status.exception.client;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http4xxException;

/**
 * http status 404
 *
 * @author justburrow
 * @since 2020/01/14
 */
public class NotFound extends Http4xxException {
  public static final int STATUS_CODE = HttpStatusCodes.NOT_FOUND;

  public NotFound() {
    super(STATUS_CODE);
  }

  public NotFound(final String message) {
    super(STATUS_CODE, message);
  }

  public NotFound(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }

  public NotFound(final Throwable cause) {
    super(STATUS_CODE, cause);
  }
}
