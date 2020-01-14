package kr.lul.common.web.http.status.exception.client;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http4xxException;

/**
 * http status 411
 *
 * @author justburrow
 * @since 2020/01/14
 */
public class LengthRequired extends Http4xxException {
  public static final int STATUS_CODE = HttpStatusCodes.LENGTH_REQUIRED;

  public LengthRequired() {
    super(STATUS_CODE);
  }

  public LengthRequired(final String message) {
    super(STATUS_CODE, message);
  }

  public LengthRequired(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }

  public LengthRequired(final Throwable cause) {
    super(STATUS_CODE, cause);
  }
}
