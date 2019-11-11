package kr.lul.common.web;

import java.util.Objects;

import static kr.lul.common.util.Arguments.notNull;

/**
 * @author justburrow
 * @since 2019/11/09
 */
public class Api {
  private final String namespace;
  private final String name;

  public Api(String namespace, String name) {
    notNull(namespace, "namespace");
    notNull(name, "name");

    this.namespace = namespace;
    this.name = name;
  }

  public String getNamespace() {
    return this.namespace;
  }

  public String getName() {
    return this.name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Api)) return false;
    Api that = (Api) o;
    return this.namespace.equals(that.namespace) && this.name.equals(that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.namespace, this.name);
  }

  @Override
  public String toString() {
    return this.namespace + this.name;
  }
}
