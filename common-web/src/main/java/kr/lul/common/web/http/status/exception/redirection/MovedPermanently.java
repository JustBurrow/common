package kr.lul.common.web.http.status.exception.redirection;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http3xxException;

/**
 * @author justburrow
 * @since 2020/01/14
 */
public class MovedPermanently extends Http3xxException {
  public static final int STATUS_CODE = HttpStatusCodes.MOVED_PERMANENTLY;

  public MovedPermanently() {
    super(STATUS_CODE);
  }

  public MovedPermanently(final String message) {
    super(STATUS_CODE, message);
  }

  public MovedPermanently(final Throwable cause) {
    super(STATUS_CODE, cause);
  }

  public MovedPermanently(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }
}
