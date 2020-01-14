package kr.lul.common.web.http.status.exception.client;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http4xxException;

/**
 * http status 451.
 *
 * @author justburrow
 * @since 2020/01/14
 */
public class UnavailableForLegalReasons extends Http4xxException {
  public static final int STATUS_CODE = HttpStatusCodes.UNAVAILABLE_FOR_LEGAL_REASONS;

  public UnavailableForLegalReasons() {
    super(STATUS_CODE);
  }

  public UnavailableForLegalReasons(final String message) {
    super(STATUS_CODE, message);
  }

  public UnavailableForLegalReasons(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }

  public UnavailableForLegalReasons(final Throwable cause) {
    super(STATUS_CODE, cause);
  }
}
