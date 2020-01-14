package kr.lul.common.web.http.status.exception.server;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http5xxException;

/**
 * @author justburrow
 * @since 2020/01/14
 */
public class VariantAlsoNegotiates extends Http5xxException {
  public static final int STATUS_CODE = HttpStatusCodes.VARIANT_ALSO_NEGOTIATES;

  public VariantAlsoNegotiates() {
    super(STATUS_CODE);
  }

  public VariantAlsoNegotiates(final String message) {
    super(STATUS_CODE, message);
  }

  public VariantAlsoNegotiates(final Throwable cause) {
    super(STATUS_CODE, cause);
  }

  public VariantAlsoNegotiates(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }
}
