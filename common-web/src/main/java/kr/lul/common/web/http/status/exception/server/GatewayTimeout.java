package kr.lul.common.web.http.status.exception.server;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http5xxException;

/**
 * @author justburrow
 * @since 2020/01/14
 */
public class GatewayTimeout extends Http5xxException {
  public static final int STATUS_CODE = HttpStatusCodes.GATEWAY_TIMEOUT;

  public GatewayTimeout() {
    super(STATUS_CODE);
  }

  public GatewayTimeout(final String message) {
    super(STATUS_CODE, message);
  }

  public GatewayTimeout(final Throwable cause) {
    super(STATUS_CODE, cause);
  }

  public GatewayTimeout(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }
}
