package kr.lul.common.web.http.status.exception.informationalresponse;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http1xxException;

/**
 * @author justburrow
 * @since 2020/01/14
 */
public class Processing extends Http1xxException {
  public static final int STATUS_CODE = HttpStatusCodes.PROCESSING;

  public Processing() {
    super(STATUS_CODE);
  }

  public Processing(final String message) {
    super(STATUS_CODE, message);
  }

  public Processing(final Throwable cause) {
    super(STATUS_CODE, cause);
  }

  public Processing(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }
}
