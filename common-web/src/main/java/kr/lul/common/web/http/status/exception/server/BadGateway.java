package kr.lul.common.web.http.status.exception.server;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http5xxException;

/**
 * @author justburrow
 * @since 2020/01/14
 */
public class BadGateway extends Http5xxException {
  public static final int STATUS_CODE = HttpStatusCodes.BAD_GATEWAY;

  public BadGateway() {
    super(STATUS_CODE);
  }

  public BadGateway(final String message) {
    super(STATUS_CODE, message);
  }

  public BadGateway(final Throwable cause) {
    super(STATUS_CODE, cause);
  }

  public BadGateway(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }
}
