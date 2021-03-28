package kr.lul.common.util;

import static kr.lul.common.util.Arguments.notNull;

/**
 * @author justburrow
 * @since 2021/03/28
 */
public interface BooleanConsumer {
  void accept(boolean value);

  default BooleanConsumer andThen(BooleanConsumer after) {
    notNull(after, "after");
    return t -> {
      accept(t);
      after.accept(t);
    };
  }
}
