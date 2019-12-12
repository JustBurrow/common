package kr.lul.common.data;

import java.util.Objects;

/**
 * {@link Context}를 전달할 때 사용할 수 있는 컨테이너.
 *
 * @author justburrow
 * @since 2019/12/12
 */
public class ContextContainer {
  protected final Context context;

  public ContextContainer(Context context) {
    if (null == context)
      throw new IllegalArgumentException("context is null.");

    this.context = context;
  }

  public Context getContext() {
    return this.context;
  }

  @Override
  public boolean equals(Object o) {
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
