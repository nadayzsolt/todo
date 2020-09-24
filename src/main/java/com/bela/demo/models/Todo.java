package com.bela.demo.models;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.NoArgsConstructor;

@Entity
public class Todo {
  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private int id;
  private String name;
  private boolean completed;
  @ManyToOne (cascade = CascadeType.PERSIST)
  private Assignee assignee;

  public Todo(String name, Assignee assignee) {
    this.name = name;
    this.assignee = assignee;
  }

  public Todo(String name) {
    this.name = name;
  }

  public Todo() {}

  public String getName() {
    return name;
  }

  public boolean isCompleted() {
    return this.completed;
  }

  public void setCompleted(boolean value) {
    this.completed = value;
  }

  public int getId() {
    return id;
  }

  @Override
  public String toString() {
    return name;
  }
}
