package kr.lul.common.web.http.status.exception.server;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http5xxException;

/**
 * @author justburrow
 * @since 2020/01/14
 */
public class ServiceUnavailable extends Http5xxException {
  public static final int STATUS_CODE = HttpStatusCodes.SERVICE_UNAVAILABLE;

  public ServiceUnavailable() {
    super(STATUS_CODE);
  }

  public ServiceUnavailable(final String message) {
    super(STATUS_CODE, message);
  }

  public ServiceUnavailable(final Throwable cause) {
    super(STATUS_CODE, cause);
  }

  public ServiceUnavailable(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }
}
