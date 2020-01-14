package kr.lul.common.web.http.status.exception.informationalresponse;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http1xxException;

/**
 * @author justburrow
 * @since 2020/01/14
 */
public class SwitchingProtocols extends Http1xxException {
  public static final int STATUS_CODE = HttpStatusCodes.SWITCHING_PROTOCOLS;

  public SwitchingProtocols() {
    super(STATUS_CODE);
  }

  public SwitchingProtocols(final String message) {
    super(STATUS_CODE, message);
  }

  public SwitchingProtocols(final Throwable cause) {
    super(STATUS_CODE, cause);
  }

  public SwitchingProtocols(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }
}
