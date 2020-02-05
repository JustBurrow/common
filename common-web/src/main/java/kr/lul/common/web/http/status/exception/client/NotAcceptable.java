package kr.lul.common.web.http.status.exception.client;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http4xxException;

/**
 * http status 406
 *
 * @author justburrow
 * @since 2020/01/14
 */
public class NotAcceptable extends Http4xxException {
  public static final int STATUS_CODE = HttpStatusCodes.NOT_ACCEPTABLE;

  public NotAcceptable() {
    super(STATUS_CODE);
  }

  public NotAcceptable(final String message) {
    super(STATUS_CODE, message);
  }

  public NotAcceptable(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }

  public NotAcceptable(final Throwable cause) {
    super(STATUS_CODE, cause);
  }
}