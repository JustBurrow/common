package kr.lul.common.util.composer;

import kr.lul.common.util.ComposeException;
import kr.lul.common.util.Composer;

import java.time.Period;

/**
 * @author justburrow
 * @since 2018. 9. 24.
 */
public class PeriodComposer implements Composer<Period> {
  @Override
  public String compose(Period period) throws ComposeException {
    return null == period
        ? null
        : period.toString();
  }
}
