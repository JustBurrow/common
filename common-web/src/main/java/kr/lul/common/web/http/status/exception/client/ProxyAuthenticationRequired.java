package kr.lul.common.web.http.status.exception.client;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http4xxException;

/**
 * http status 407.
 *
 * @author justburrow
 * @since 2020/01/14
 */
public class ProxyAuthenticationRequired extends Http4xxException {
  public static final int STATUS_CODE = HttpStatusCodes.PROXY_AUTHENTICATION_REQUIRED;

  public ProxyAuthenticationRequired() {
    super(STATUS_CODE);
  }

  public ProxyAuthenticationRequired(final String message) {
    super(STATUS_CODE, message);
  }

  public ProxyAuthenticationRequired(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }

  public ProxyAuthenticationRequired(final Throwable cause) {
    super(STATUS_CODE, cause);
  }
}
