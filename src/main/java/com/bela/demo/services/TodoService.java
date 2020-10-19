package com.bela.demo.services;

import com.bela.demo.models.Assignee;
import com.bela.demo.models.Todo;
import com.bela.demo.repositories.AssigneeRepository;
import com.bela.demo.repositories.TodoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
  private TodoRepository todoRepository;
  private AssigneeRepository assigneeRepository;

  @Autowired
  public TodoService(TodoRepository todoRepository,
                     AssigneeRepository assigneeRepository) {
    this.todoRepository = todoRepository;
    this.assigneeRepository = assigneeRepository;
  }

  public List<Todo> getTodoList() {
    return todoRepository.findAll();
  }

  public void addToTodoList(String newTodo, String name) {
    if (newTodo != "" && assigneeRepository.findByName(name) != null) {
      todoRepository.save(new Todo(newTodo, assigneeRepository.findByName(name)));
    }
  }

  public void delTodoFromList(int id) {
    todoRepository.delete(todoRepository.findById(id));
  }

  public void setTodoCompleted(int id) {
    todoRepository.findById(id).setCompleted(true);
    todoRepository.save(todoRepository.findById(id));
  }

  //  assignee part:

  public List<Assignee> getAssigneeList() {
    return assigneeRepository.findAll();
  }

  public void createAssignee(String name, String email) {
    assert assigneeRepository != null;
    assigneeRepository.save(new Assignee(name, email));
  }

  public Assignee findAssignee(long id) {
    return assigneeRepository.findById(id);
  }

  public void editAssigneeFields(Assignee assignee) {
    assigneeRepository.save(assignee);
  }
}

