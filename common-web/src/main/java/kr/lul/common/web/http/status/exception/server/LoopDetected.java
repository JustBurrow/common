package kr.lul.common.web.http.status.exception.server;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http5xxException;

/**
 * @author justburrow
 * @since 2020/01/14
 */
public class LoopDetected extends Http5xxException {
  public static final int STATUS_CODE = HttpStatusCodes.LOOP_DETECTED;

  public LoopDetected() {
    super(STATUS_CODE);
  }

  public LoopDetected(final String message) {
    super(STATUS_CODE, message);
  }

  public LoopDetected(final Throwable cause) {
    super(STATUS_CODE, cause);
  }

  public LoopDetected(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }
}
