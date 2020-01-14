package kr.lul.common.web.http.status.exception.client;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http4xxException;

/**
 * http status 417
 *
 * @author justburrow
 * @since 2020/01/14
 */
public class ExpectationFailed extends Http4xxException {
  public static final int STATUS_CODE = HttpStatusCodes.EXPECTATION_FAILED;

  public ExpectationFailed() {
    super(STATUS_CODE);
  }

  public ExpectationFailed(final String message) {
    super(STATUS_CODE, message);
  }

  public ExpectationFailed(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }

  public ExpectationFailed(final Throwable cause) {
    super(STATUS_CODE, cause);
  }
}
