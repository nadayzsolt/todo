package com.bela.demo.services;

import com.bela.demo.models.Todo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
  private List<Todo> todoList;
  private Todo actualTodo;

  @Autowired
  public TodoService() {
    this.todoList = new ArrayList<>();
  }

  public List<Todo> getTodoList() {
    return todoList;
  }

  public Todo getTodoById(int id) {
    return todoList.stream().filter(todo -> todo.getId() == id).findFirst()
        .orElse(null);
  }

  public void addToTodoList(String name) {
    todoList.add(new Todo(name));
  }

  public void delTodoFromList(int id) {
    todoList.remove(getTodoById(id));
  }

  public void setTodoCompleted(int id) {
    getTodoById(id).setCompleted(true);
  }
}
