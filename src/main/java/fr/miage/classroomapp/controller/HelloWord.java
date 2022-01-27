package fr.miage.classroomapp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/greetings")
public class HelloWord {

    @GetMapping(value = "/{name}")
    public String hello(@PathVariable("name") String name, Model model){
            model.addAttribute("nom",name);
            return  "helloworld";
        }

    @GetMapping
    public String hello(Model model){
        model.addAttribute("nom","Quentin");
        return  "helloworld";
    }
}
