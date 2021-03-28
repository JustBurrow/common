package kr.lul.common.util;

import static kr.lul.common.util.Arguments.notNull;

/**
 * @author justburrow
 * @since 2021/03/28
 */
public interface ShortConsumer {
  void accept(short value);

  default ShortConsumer andThen(ShortConsumer after) {
    notNull(after, "after");
    return t -> {
      accept(t);
      after.accept(t);
    };
  }
}
