package com.bela.demo.controllers;

import com.bela.demo.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoController {
 private TodoService todoService;

  @Autowired
  public TodoController(TodoService todoService) {
    this.todoService = todoService;
  }

  @GetMapping("/todo")
  public String manipulateTodoList(Model model, String todo) {
    model.addAttribute("todolist", todoService.getTodoList());
    return "index";
  }

  @PostMapping("/addnewtodo")
  public String addNewTodo(String newtodo) {
    todoService.addToTodoList(newtodo);
    return "redirect:/todo";
  }

  @PostMapping("/deltodo")
  public String delTodo(@RequestParam (required = false) int id) {
todoService.delTodoFromList(id);
    return "redirect:/todo";
  }

  @PostMapping("/completetodo")
  public String completeTodo(@RequestParam (required = false) int id) {
todoService.setTodoCompleted(id);
    return "redirect:/todo";
  }
}
