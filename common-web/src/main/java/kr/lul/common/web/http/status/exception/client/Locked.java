package kr.lul.common.web.http.status.exception.client;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http4xxException;

/**
 * http status 423
 *
 * @author justburrow
 * @since 2020/01/14
 */
public class Locked extends Http4xxException {
  public static final int STATUS_CODE = HttpStatusCodes.LOCKED;

  public Locked() {
    super(STATUS_CODE);
  }

  public Locked(final String message) {
    super(STATUS_CODE, message);
  }

  public Locked(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }

  public Locked(final Throwable cause) {
    super(STATUS_CODE, cause);
  }
}
