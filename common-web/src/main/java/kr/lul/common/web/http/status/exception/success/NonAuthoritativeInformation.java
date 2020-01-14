package kr.lul.common.web.http.status.exception.success;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http2xxException;

/**
 * @author justburrow
 * @since 2020/01/14
 */
public class NonAuthoritativeInformation extends Http2xxException {
  public static final int STATUS_CODE = HttpStatusCodes.NON_AUTHORITATIVE_INFORMATION;

  public NonAuthoritativeInformation() {
    super(STATUS_CODE);
  }

  public NonAuthoritativeInformation(final String message) {
    super(STATUS_CODE, message);
  }

  public NonAuthoritativeInformation(final Throwable cause) {
    super(STATUS_CODE, cause);
  }

  public NonAuthoritativeInformation(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }
}
