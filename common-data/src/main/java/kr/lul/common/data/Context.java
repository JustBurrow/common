package kr.lul.common.data;

import java.io.Serializable;
import java.util.UUID;

import static kr.lul.common.util.Arguments.notNull;

/**
 * @author justburrow
 * @since 2019/11/24
 */
public class Context implements Serializable {
  private UUID id;

  public Context() {
    this(UUID.randomUUID());
  }

  public Context(UUID id) {
    notNull(id, "id");
    this.id = id;
  }

  public UUID id() {
    return this.id;
  }
}
