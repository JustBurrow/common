package kr.lul.common.util;

import static kr.lul.common.util.Arguments.notNull;

/**
 * @author justburrow
 * @since 2021/03/28
 */
public interface FloatConsumer {
  void accept(float value);

  default FloatConsumer andThen(FloatConsumer after) {
    notNull(after, "after");
    return t -> {
      accept(t);
      after.accept(t);
    };
  }
}
