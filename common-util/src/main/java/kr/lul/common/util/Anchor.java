package kr.lul.common.util;

/**
 * 코드에서 {@link Package}에 접근할 수 있는 수단을 제공는 클래스.
 * Springframework 등에서 {@link String}을 사용하지 않고 패키지를 지정할 때 사용.
 *
 * @author justburrow
 * @since 2019/11/04
 */
public abstract class Anchor {
  protected Anchor() {
    throw new UnsupportedOperationException("does not support instance.");
  }
}
