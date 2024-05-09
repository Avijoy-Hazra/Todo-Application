package com.springapp.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springapp.springapp.model.Todo;
import com.springapp.springapp.repository.TodoRepository;

import jakarta.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    private TodoRepository repository;
	// private TodoService service;

    @GetMapping("/")
    public String home(Model model) {
       List<Todo> todos = repository.findAll();
       model.addAttribute("todos", todos);
       System.out.println(todos.toString());
       return "index";
    }

    @GetMapping("/todo/add")
    public String add(@ModelAttribute Todo todo){
        return "add";
    }

    @PostMapping("/todo/add")
    public String add(@Valid Todo todo, BindingResult bindingResult, RedirectAttributes redirect, Model model){
        if(bindingResult.hasErrors()){
            return "add";
        }
        
        redirect.addFlashAttribute("message", "Todo Added");
        redirect.addFlashAttribute("alertClass", "alert-success");
        
        Todo todoPresent = repository.findByTitle(todo.getTitle());
        if(todoPresent != null){
            redirect.addFlashAttribute("message", "Todo already exist");
            redirect.addFlashAttribute("alertClass", "alert-danger");
            redirect.addFlashAttribute("todo", todo);
        } else {
            todo.setTitle(todo.getTitle());
            todo.setDetail(todo.getDetail());
            repository.save(todo);
        }
        return "redirect:/todo/add";
    }

    @GetMapping("/edit/{id}")
    public String getMethodName(@PathVariable int id, Model model) {
        Todo todo = repository.findById(id).get();
        model.addAttribute("todo", todo);
        return "edit";
    }
    
    @PostMapping("/todo/edit")
    public String edit(@Valid Todo todo, BindingResult bindingResult, RedirectAttributes redirect, Model model){
        if(bindingResult.hasErrors()){
            return "edit";
        }
        
        redirect.addFlashAttribute("message", "Todo Edited");
        redirect.addFlashAttribute("alertClass", "alert-success");
        
        Todo todoPresent = repository.findByIdAndTitle(todo.getId(), todo.getTitle());
        if(todoPresent != null){
            redirect.addFlashAttribute("message", "Todo already exist");
            redirect.addFlashAttribute("alertClass", "alert-danger");
            redirect.addFlashAttribute("todo", todo);
        } else {
            todo.setTitle(todo.getTitle());
            todo.setDetail(todo.getDetail());
            repository.save(todo);
        }
        return "redirect:/edit/"+todo.getId();
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes attributes) {
        repository.deleteById(id);
        attributes.addFlashAttribute("message", "Todo Deleted");
        attributes.addFlashAttribute("alertClass", "alert-success");
        
        return "redirect:/";
    }
}
