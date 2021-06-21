package kr.lul.common.web.api;

public enum Action {
  CREATE("POST"),
  READ("GET"),
  UPDATE("PUT"),
  DELETE("DELETE");

  private final String httpMethod;

  Action(final String httpMethod) {
    this.httpMethod = httpMethod;
  }
}
