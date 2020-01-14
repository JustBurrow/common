package kr.lul.common.web.http.status.exception.redirection;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http3xxException;

/**
 * @author justburrow
 * @since 2020/01/14
 */
public class PermanentRedirect extends Http3xxException {
  public static final int STATUS_CODE = HttpStatusCodes.PERMANENT_REDIRECT;

  public PermanentRedirect() {
    super(STATUS_CODE);
  }

  public PermanentRedirect(final String message) {
    super(STATUS_CODE, message);
  }

  public PermanentRedirect(final Throwable cause) {
    super(STATUS_CODE, cause);
  }

  public PermanentRedirect(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }
}
