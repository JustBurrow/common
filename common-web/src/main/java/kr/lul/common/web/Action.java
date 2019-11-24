package kr.lul.common.web;

public enum Action {
  CREATE("POST"),
  READ("GET"),
  UPDATE("PUT"),
  DELETE("DELETE");

  private final String httpMethod;

  private Action(String httpMethod){
    this.httpMethod = httpMethod;
  }
}