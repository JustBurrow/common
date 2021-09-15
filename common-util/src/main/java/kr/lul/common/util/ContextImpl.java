package kr.lul.common.util;

import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;

/**
 * @author justburrow
 * @since 2021/09/09
 */
public class ContextImpl implements Context {
  private final Map<String, Object> ctx;

  public ContextImpl() {
    this.ctx = new HashMap<>();
  }

  @Override
  public int size() {
    return this.ctx.values().stream()
        .mapToInt(v -> ( v instanceof Context ) ? ( (Context) v ).size() : 1)
        .sum();
  }

  @Override
  public boolean isEmpty() {
    return this.ctx.isEmpty();
  }

  @Override
  public void put(String key, Object value) {
    KEY_VALIDATOR.validate(key);

    if (0 < key.indexOf('.')) {
      String parentKey = key.substring(0, key.indexOf(KEY_DELIMITER));
      String childKey = key.substring(1 + key.indexOf(KEY_DELIMITER));

      Object parent = this.ctx.get(parentKey);
      Context parentCtx;
      if (null == parent) {
        parentCtx = new ContextImpl();
        this.ctx.put(parentKey, parentCtx);
      } else if (parent instanceof Context) {
        parentCtx = (Context) parent;
      } else {
        throw new IllegalStateException(format("already used key : key=%s", key));
      }
      parentCtx.put(childKey, value);
    } else {
      if (this.ctx.containsKey(key))
        throw new IllegalArgumentException("already exist : key=" + key);
      else
        this.ctx.put(key, value);
    }
  }

  @Override
  public Object get(String key) {
    KEY_VALIDATOR.validate(key);

    if (0 < key.indexOf('.')) {
      String parentKey = key.substring(0, key.indexOf(KEY_DELIMITER));
      String childKey = key.substring(1 + key.indexOf(KEY_DELIMITER));

      Object parent = this.ctx.get(parentKey);
      if (null == parent)
        return null;
      else if (parent instanceof Context)
        return ( (Context) parent ).get(childKey);
      else
        return null;
    } else {
      return this.ctx.get(key);
    }
  }

  @Override
  public Object remove(String key) {
    KEY_VALIDATOR.validate(key);

    if (0 < key.indexOf('.')) {
      String parentKey = key.substring(0, key.indexOf(KEY_DELIMITER));
      String childKey = key.substring(1 + key.indexOf(KEY_DELIMITER));
      if (!this.ctx.containsKey(parentKey))
        throw new IllegalStateException("key does not exist : key=" + key);

      Object parent = this.ctx.get(parentKey);
      if (parent instanceof Context) {
        return ( (Context) parent ).remove(childKey);
      } else {
        throw new IllegalStateException("key does not exist : key=" + key);
      }
    } else if (this.ctx.containsKey(key)) {
      Object value = this.ctx.get(key);
      this.ctx.remove(key);
      return value;
    } else {
      throw new IllegalStateException("key does not exist : key=" + key);
    }
  }

  @Override
  public Map<String, Object> toMap() {
    Map<String, Object> map = new HashMap<>();
    this.ctx.forEach((k, v) -> {
      if (v instanceof Context)
        ( (Context) v ).toMap().forEach((k2, v2) -> map.put(k + KEY_DELIMITER + k2, v2));
      else
        map.put(k, v);
    });
    return map;
  }

  @Override
  public String toString() {
    return this.ctx.toString();
  }
}