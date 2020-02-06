package main;

import flow.IAction;

public class TextAction implements IAction<String> {
  private String value;

  public TextAction(String value) {
    this.value = value;
  }

  public String execute() {
    return value;
  }

  public String getType() {
    return "TEXT";
  }
}
