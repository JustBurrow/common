package kr.lul.common.web.http.status.exception.redirection;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http3xxException;

/**
 * @author justburrow
 * @since 2020/01/14
 */
public class UseProxy extends Http3xxException {
  public static final int STATUS_CODE = HttpStatusCodes.USE_PROXY;

  public UseProxy() {
    super(STATUS_CODE);
  }

  public UseProxy(final String message) {
    super(STATUS_CODE, message);
  }

  public UseProxy(final Throwable cause) {
    super(STATUS_CODE, cause);
  }

  public UseProxy(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }
}
