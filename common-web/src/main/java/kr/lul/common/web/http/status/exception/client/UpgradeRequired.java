package kr.lul.common.web.http.status.exception.client;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http4xxException;

/**
 * http status 426
 *
 * @author justburrow
 * @since 2020/01/14
 */
public class UpgradeRequired extends Http4xxException {
  public static final int STATUS_CODE = HttpStatusCodes.UPGRADE_REQUIRED;

  public UpgradeRequired() {
    super(STATUS_CODE);
  }

  public UpgradeRequired(final String message) {
    super(STATUS_CODE, message);
  }

  public UpgradeRequired(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }

  public UpgradeRequired(final Throwable cause) {
    super(STATUS_CODE, cause);
  }
}
