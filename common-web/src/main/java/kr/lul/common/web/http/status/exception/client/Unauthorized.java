package kr.lul.common.web.http.status.exception.client;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http4xxException;

/**
 * HTTP Status 401
 *
 * @author justburrow
 * @since 2020/01/14
 */
public class Unauthorized extends Http4xxException {
  public static final int STATUS_CODE = HttpStatusCodes.UNAUTHORIZED;

  public Unauthorized() {
    super(STATUS_CODE);
  }

  public Unauthorized(final String message) {
    super(STATUS_CODE, message);
  }

  public Unauthorized(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }

  public Unauthorized(final Throwable cause) {
    super(STATUS_CODE, cause);
  }
}
