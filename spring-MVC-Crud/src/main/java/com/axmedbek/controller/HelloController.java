package com.axmedbek.controller;

import com.axmedbek.dao.Person;
import com.axmedbek.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by axmedbek on 6/11/17.
 */

@Controller
public class HelloController {



    @Autowired
    private PersonDao personDao;



    @RequestMapping("/")
    public String helloPage(Model model)

    {

        model.addAttribute("personList",personDao.getPersonList())   ;
        return "hello";

    }

    @RequestMapping("/login")
    public String loginPage(Model model)
    {

        Person person = new Person();
        model.addAttribute("person",person);
        return "loginForm";


    }

    @RequestMapping("/save")
    public String save(@ModelAttribute Person person)
    {
        personDao.insert(person);

        return "redirect:/";
    }

    @RequestMapping("/delete/{id}")
    public String deletePerson(@ModelAttribute("person") Person person, @PathVariable("id") int id)
    {

        personDao.delete(id);
        return  "redirect:/";
    }


}
