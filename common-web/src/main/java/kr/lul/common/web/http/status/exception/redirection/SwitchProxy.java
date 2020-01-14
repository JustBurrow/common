package kr.lul.common.web.http.status.exception.redirection;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http3xxException;

/**
 * @author justburrow
 * @since 2020/01/14
 */
public class SwitchProxy extends Http3xxException {
  public static final int STATUS_CODE = HttpStatusCodes.SWITCH_PROXY;

  public SwitchProxy() {
    super(STATUS_CODE);
  }

  public SwitchProxy(final String message) {
    super(STATUS_CODE, message);
  }

  public SwitchProxy(final Throwable cause) {
    super(STATUS_CODE, cause);
  }

  public SwitchProxy(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }
}
