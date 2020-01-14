package kr.lul.common.web.http.status.exception.success;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http2xxException;

/**
 * @author justburrow
 * @since 2020/01/14
 */
public class NoContent extends Http2xxException {
  public static final int STATUS_CODE = HttpStatusCodes.NO_CONTENT;

  public NoContent() {
    super(STATUS_CODE);
  }

  public NoContent(final String message) {
    super(STATUS_CODE, message);
  }

  public NoContent(final Throwable cause) {
    super(STATUS_CODE, cause);
  }

  public NoContent(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }
}
