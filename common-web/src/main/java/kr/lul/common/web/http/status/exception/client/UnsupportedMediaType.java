package kr.lul.common.web.http.status.exception.client;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http4xxException;

/**
 * http status 415
 *
 * @author justburrow
 * @since 2020/01/14
 */
public class UnsupportedMediaType extends Http4xxException {
  public static final int STATUS_CODE = HttpStatusCodes.UNSUPPORTED_MEDIA_TYPE;

  public UnsupportedMediaType() {
    super(STATUS_CODE);
  }

  public UnsupportedMediaType(final String message) {
    super(STATUS_CODE, message);
  }

  public UnsupportedMediaType(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }

  public UnsupportedMediaType(final Throwable cause) {
    super(STATUS_CODE, cause);
  }
}
