package kr.lul.common.web.api;

import java.util.Objects;

import static kr.lul.common.util.Arguments.notNull;

/**
 * @author justburrow
 * @since 2019/11/09
 */
public class Api {
  private final Action action;
  private final String namespace;
  private final String name;

  public Api(final Action action, final String namespace, final String name) {
    notNull(action, "action");
    notNull(namespace, "namespace");
    notNull(name, "name");

    this.action = action;
    this.namespace = namespace;
    this.name = name;
  }

  public Action getAction() {
    return this.action;
  }

  public String getNamespace() {
    return this.namespace;
  }

  public String getName() {
    return this.name;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) return true;
    if (!(o instanceof Api)) return false;
    final Api that = (Api) o;
    return this.action == that.action
               && this.namespace.equals(that.namespace)
               && this.name.equals(that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.action, this.namespace, this.name);
  }

  @Override
  public String toString() {
    return String.format("%s %s%s", this.action, this.namespace, this.name);
  }
}
