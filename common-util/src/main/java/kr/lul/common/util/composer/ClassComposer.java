package kr.lul.common.util.composer;

import kr.lul.common.util.ComposeException;
import kr.lul.common.util.Composer;

/**
 * @author justburrow
 * @since 2018. 9. 19.
 */
public class ClassComposer implements Composer<Class> {
  @Override
  public String compose(Class source) throws ComposeException {
    return null == source
        ? null
        : source.getName();
  }
}
