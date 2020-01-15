package kr.lul.common.data;

import java.util.Objects;
import java.util.UUID;

import static kr.lul.common.util.Arguments.notNull;

/**
 * {@link Context}를 전달할 때 사용할 수 있는 컨테이너.
 *
 * @author justburrow
 * @since 2019/12/12
 */
public class ContextContainer {
  protected final Context context;

  public ContextContainer(final UUID id) {
    notNull(id, "id");

    this.context = new Context(id);
  }

  public ContextContainer(final Context context) {
    notNull(context, "context");

    this.context = context;
  }

  public ContextContainer(final ContextContainer container) {
    notNull(container, "container");
    notNull(container.context, "container.context");

    this.context = container.context;
  }

  public Context getContext() {
    return this.context;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) return true;
    return this.context.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.context);
  }

  @Override
  public String toString() {
    return this.context.toString();
  }
}
