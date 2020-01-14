package kr.lul.common.web.http.status.exception.server;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http5xxException;

/**
 * @author justburrow
 * @since 2020/01/15
 */
public class NetworkAuthenticationRequired extends Http5xxException {
  public static final int STATUS_CODE = HttpStatusCodes.NETWORK_AUTHENTICATION_REQUIRED;

  public NetworkAuthenticationRequired() {
    super(STATUS_CODE);
  }

  public NetworkAuthenticationRequired(final String message) {
    super(STATUS_CODE, message);
  }

  public NetworkAuthenticationRequired(final Throwable cause) {
    super(STATUS_CODE, cause);
  }

  public NetworkAuthenticationRequired(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }
}
