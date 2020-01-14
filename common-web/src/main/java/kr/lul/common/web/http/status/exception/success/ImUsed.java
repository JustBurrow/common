package kr.lul.common.web.http.status.exception.success;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http2xxException;

/**
 * @author justburrow
 * @since 2020/01/14
 */
public class ImUsed extends Http2xxException {
  public static final int STATUS_CODE = HttpStatusCodes.IM_USED;

  public ImUsed() {
    super(STATUS_CODE);
  }

  public ImUsed(final String message) {
    super(STATUS_CODE, message);
  }

  public ImUsed(final Throwable cause) {
    super(STATUS_CODE, cause);
  }

  public ImUsed(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }
}
