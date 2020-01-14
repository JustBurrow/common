package kr.lul.common.web.http.status.exception.client;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http4xxException;

/**
 * http status 421
 *
 * @author justburrow
 * @since 2020/01/14
 */
public class MisdirectedRequest extends Http4xxException {
  public static final int STATUS_CODE = HttpStatusCodes.MISDIRECTED_REQUEST;

  public MisdirectedRequest() {
    super(STATUS_CODE);
  }

  public MisdirectedRequest(final String message) {
    super(STATUS_CODE, message);
  }

  public MisdirectedRequest(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }

  public MisdirectedRequest(final Throwable cause) {
    super(STATUS_CODE, cause);
  }
}
