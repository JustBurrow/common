package kr.lul.common.web.http.status.exception.server;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http5xxException;

/**
 * @author justburrow
 * @since 2020/01/14
 */
public class InsufficientStorage extends Http5xxException {
  public static final int STATUS_CODE = HttpStatusCodes.INSUFFICIENT_STORAGE;

  public InsufficientStorage() {
    super(STATUS_CODE);
  }

  public InsufficientStorage(final String message) {
    super(STATUS_CODE, message);
  }

  public InsufficientStorage(final Throwable cause) {
    super(STATUS_CODE, cause);
  }

  public InsufficientStorage(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }
}
