package kr.lul.common.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author justburrow
 * @since 2021/09/09
 */
public class ContextImpl implements Context {
  private final Map<String, Object> map;

  public ContextImpl() {
    this.map = new HashMap<>();
  }

  @Override
  public int size() {
    return 0;
  }

  @Override
  public Object put(String key, Object obj) {
    return null;
  }

  @Override
  public Object get(String key) {
    return null;
  }

  @Override
  public Object remove(String key) {
    return null;
  }

  @Override
  public Map<String, Object> toMap() {
    return null;
  }
}