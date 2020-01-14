package kr.lul.common.web.http.status.exception.server;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http5xxException;

/**
 * @author justburrow
 * @since 2020/01/15
 */
public class NotExtended extends Http5xxException {
  public static final int STATUS_CODE = HttpStatusCodes.NOT_EXTENDED;

  public NotExtended() {
    super(STATUS_CODE);
  }

  public NotExtended(final String message) {
    super(STATUS_CODE, message);
  }

  public NotExtended(final Throwable cause) {
    super(STATUS_CODE, cause);
  }

  public NotExtended(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }
}
