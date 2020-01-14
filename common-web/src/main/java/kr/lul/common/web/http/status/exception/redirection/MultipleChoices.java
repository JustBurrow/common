package kr.lul.common.web.http.status.exception.redirection;

import kr.lul.common.web.http.status.HttpStatusCodes;
import kr.lul.common.web.http.status.exception.Http3xxException;

/**
 * @author justburrow
 * @since 2020/01/14
 */
public class MultipleChoices extends Http3xxException {
  public static final int STATUS_CODE = HttpStatusCodes.MULTIPLE_CHOICES;

  public MultipleChoices() {
    super(STATUS_CODE);
  }

  public MultipleChoices(final String message) {
    super(STATUS_CODE, message);
  }

  public MultipleChoices(final Throwable cause) {
    super(STATUS_CODE, cause);
  }

  public MultipleChoices(final String message, final Throwable cause) {
    super(STATUS_CODE, message, cause);
  }
}
