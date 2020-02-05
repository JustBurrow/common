package kr.lul.common.web.http.status.exception.client;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http4xxException;

/**
 * http status 424
 *
 * @author justburrow
 * @since 2020/01/14
 */
public class FailedDependency extends Http4xxException {
  public static final int STATUS_CODE = HttpStatusCodes.FAILED_DEPENDENCY;

  public FailedDependency() {
    super(STATUS_CODE);
  }

  public FailedDependency(final String message) {
    super(STATUS_CODE, message);
  }

  public FailedDependency(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }

  public FailedDependency(final Throwable cause) {
    super(STATUS_CODE, cause);
  }
}