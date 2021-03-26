package kr.lul.common.logging;

import kr.lul.common.util.Anchor;

/**
 * @author justburrow
 * @since 2021/03/26
 */
public abstract class CommonLoggingAnchor extends Anchor {
  public static final Package PACKAGE = CommonLoggingAnchor.class.getPackage();
  public static final String PACKAGE_NAME = CommonLoggingAnchor.class.getPackageName();

  protected CommonLoggingAnchor() {
    throw new UnsupportedOperationException();
  }
}
