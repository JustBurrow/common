package kr.lul.common.data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static kr.lul.common.util.Arguments.notNull;

/**
 * @author justburrow
 * @since 2019/11/24
 */
public class UuidContext implements Context<UUID> {
  private UUID id;
  private final Map<String, Serializable> properties;

  public UuidContext(UUID id) {
    notNull(id, "id");
    this.id = id;

    this.properties = new HashMap<>();
  }

  @Override
  public UUID id() {
    return this.id;
  }

  @Override
  public <P extends Serializable> P put(String name, P value) {
    notNull(name, "name");

    synchronized (this.properties) {
      return (P) this.properties.put(name, value);
    }
  }

  @Override
  public Object get(String name) {
    notNull(name, "name");

    synchronized (this.properties) {
      return this.properties.get(name);
    }
  }

  @Override
  public <P extends Serializable> P get(String name, Class<P> type) {
    notNull(name, "name");

    synchronized (this.properties) {
      return (P) this.properties.get(name);
    }
  }
}
