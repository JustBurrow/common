package kr.lul.common.web.http.status.exception.informationalresponse;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http1xxException;

/**
 * @author justburrow
 * @since 2020/01/14
 */
public class EarlyHints extends Http1xxException {
  public static final int STATUS_CODE = HttpStatusCodes.EARLY_HINTS;

  public EarlyHints() {
    super(STATUS_CODE);
  }

  public EarlyHints(final String message) {
    super(STATUS_CODE, message);
  }

  public EarlyHints(final Throwable cause) {
    super(STATUS_CODE, cause);
  }

  public EarlyHints(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }
}
