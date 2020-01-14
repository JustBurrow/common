package kr.lul.common.web.http.status.exception.success;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http2xxException;

/**
 * @author justburrow
 * @since 2020/01/14
 */
public class PartialContent extends Http2xxException {
  public static final int STATUS_CODE = HttpStatusCodes.PARTIAL_CONTENT;

  public PartialContent() {
    super(STATUS_CODE);
  }

  public PartialContent(final String message) {
    super(STATUS_CODE, message);
  }

  public PartialContent(final Throwable cause) {
    super(STATUS_CODE, cause);
  }

  public PartialContent(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }
}
