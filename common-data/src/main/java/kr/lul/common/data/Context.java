package kr.lul.common.data;

import java.util.Objects;
import java.util.UUID;

import static java.util.UUID.randomUUID;
import static kr.lul.common.util.Arguments.notNull;

/**
 * 컨텍스트.
 *
 * @author justburrow
 * @since 2019/12/12
 */
public class Context {
  /**
   * 컨텍스트 ID.
   */
  protected final UUID id;

  public Context() {
    this(randomUUID());
  }

  public Context(final UUID id) {
    notNull(id, "id");

    this.id = id;
  }

  public Context(final Context context) {
    this(context.id);
  }

  public UUID getId() {
    return this.id;
  }

  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // java.lang.Object
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  @Override
  public boolean equals(final Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    return this.id.equals(((Context) o).id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id);
  }

  @Override
  public String toString() {
    return this.id.toString();
  }
}
