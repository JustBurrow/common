package kr.lul.common.web.http.status.exception.redirection;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http3xxException;

/**
 * @author justburrow
 * @since 2020/01/14
 */
public class TemporaryRedirect extends Http3xxException {
  public static final int STATUS_CODE = HttpStatusCodes.TEMPORARY_REDIRECT;

  public TemporaryRedirect() {
    super(STATUS_CODE);
  }

  public TemporaryRedirect(final String message) {
    super(STATUS_CODE, message);
  }

  public TemporaryRedirect(final Throwable cause) {
    super(STATUS_CODE, cause);
  }

  public TemporaryRedirect(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }
}
