package kr.lul.common.web.http.status.exception.redirection;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http3xxException;

/**
 * @author justburrow
 * @since 2020/01/14
 */
public class SeeOther extends Http3xxException {
  public static final int STATUS_CODE = HttpStatusCodes.SEE_OTHER;

  public SeeOther() {
    super(STATUS_CODE);
  }

  public SeeOther(final String message) {
    super(STATUS_CODE, message);
  }

  public SeeOther(final Throwable cause) {
    super(STATUS_CODE, cause);
  }

  public SeeOther(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }
}
