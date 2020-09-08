package com.bela.demo.models;


public class Todo {
  private String name;
  private boolean isCompleted;
  private int id;

  private static int idCounter = 0;


  public Todo(String name) {
    this.name = name;
    this.isCompleted = false;
    this.id =  ++idCounter;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isCompleted() {
    return isCompleted;
  }

  public void setCompleted(boolean completed) {
    isCompleted = completed;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return name;
  }
}
