package kr.lul.common.web.http.status.exception.redirection;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http3xxException;

/**
 * @author justburrow
 * @since 2020/01/14
 */
public class NotModified extends Http3xxException {
  public static final int STATUS_CODE = HttpStatusCodes.NOT_MODIFIED;

  public NotModified() {
    super(STATUS_CODE);
  }

  public NotModified(final String message) {
    super(STATUS_CODE, message);
  }

  public NotModified(final Throwable cause) {
    super(STATUS_CODE, cause);
  }

  public NotModified(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }
}
