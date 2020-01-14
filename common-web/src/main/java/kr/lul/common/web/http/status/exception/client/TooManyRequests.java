package kr.lul.common.web.http.status.exception.client;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http4xxException;

/**
 * http status 429
 *
 * @author justburrow
 * @since 2020/01/14
 */
public class TooManyRequests extends Http4xxException {
  public static final int STATUS_CODE = HttpStatusCodes.TOO_MANY_REQUESTS;

  public TooManyRequests() {
    super(STATUS_CODE);
  }

  public TooManyRequests(final String message) {
    super(STATUS_CODE, message);
  }

  public TooManyRequests(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }

  public TooManyRequests(final Throwable cause) {
    super(STATUS_CODE, cause);
  }
}
