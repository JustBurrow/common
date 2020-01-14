package kr.lul.common.web.http.status.exception.client;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http4xxException;

/**
 * http status 403
 *
 * @author justburrow
 * @since 2020/01/14
 */
public class Forbidden extends Http4xxException {
  public static final int STATUS_CODE = HttpStatusCodes.FORBIDDEN;

  public Forbidden() {
    super(STATUS_CODE);
  }

  public Forbidden(final String message) {
    super(STATUS_CODE, message);
  }

  public Forbidden(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }

  public Forbidden(final Throwable cause) {
    super(STATUS_CODE, cause);
  }
}
