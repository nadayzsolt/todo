package com.bela.demo.controllers;

import com.bela.demo.models.Assignee;
import com.bela.demo.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
  public String renderTodoList(Model model, String todo) {
    model.addAttribute("todolist", todoService.getTodoList());
    return "index";
  }

  @PostMapping("/addnewtodo")
  public String addNewTodo(String newtodo, @ModelAttribute Assignee assignee) {

    todoService.addToTodoList(newtodo,assignee);
    return "redirect:/todo";
  }

  @PostMapping("/deltodo")
  public String delTodo(@RequestParam(required = false) int id) {
    todoService.delTodoFromList(id);
    return "redirect:/todo";
  }

  @PostMapping("/completetodo")
  public String completeTodo(@RequestParam(required = false) int id) {
    todoService.setTodoCompleted(id);
    return "redirect:/todo";
  }
//  assignee part:

  @GetMapping("/assignees")
  public String renderAssignees(Model model) {
    model.addAttribute("assignees", todoService.getAssigneeList());
    return "assignees";
  }

  @PostMapping(path = "/assignees")
  public String addAssignee(@RequestParam(name = "name") String name,
                            @RequestParam(name = "email") String email) {
    todoService.createAssignee(name, email);
    return "redirect:/assignees";
  }

  @GetMapping("/editassignee/{id}")
  public String renderEditAssignee(  @PathVariable (required = false) Long id, Model model) {
    model.addAttribute("assignee", todoService.findAssignee(id));
    return "editassignee";
  }

  @PostMapping(path = "/editassigneefields")
  public String editAssignee(@ModelAttribute Assignee assignee) {
todoService.editAssigneeFields(assignee);
    return "redirect:/assignees";
  }
}
