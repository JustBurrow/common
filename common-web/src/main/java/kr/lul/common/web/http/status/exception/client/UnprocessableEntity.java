package kr.lul.common.web.http.status.exception.client;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http4xxException;

/**
 * http status 422
 *
 * @author justburrow
 * @since 2020/01/14
 */
public class UnprocessableEntity extends Http4xxException {
  public static final int STATUS_CODE = HttpStatusCodes.UNPROCESSABLE_ENTITY;

  public UnprocessableEntity() {
    super(STATUS_CODE);
  }

  public UnprocessableEntity(final String message) {
    super(STATUS_CODE, message);
  }

  public UnprocessableEntity(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }

  public UnprocessableEntity(final Throwable cause) {
    super(STATUS_CODE, cause);
  }
}
