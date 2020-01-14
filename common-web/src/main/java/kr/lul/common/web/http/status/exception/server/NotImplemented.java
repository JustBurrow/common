package kr.lul.common.web.http.status.exception.server;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http5xxException;

/**
 * @author justburrow
 * @since 2020/01/14
 */
public class NotImplemented extends Http5xxException {
  public static final int STATUS_CODE = HttpStatusCodes.NOT_IMPLEMENTED;

  public NotImplemented() {
    super(STATUS_CODE);
  }

  public NotImplemented(final String message) {
    super(STATUS_CODE, message);
  }

  public NotImplemented(final Throwable cause) {
    super(STATUS_CODE, cause);
  }

  public NotImplemented(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }
}
