package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.AlienRepository;
import com.example.demo.model.AlienEntity;

@Controller
@RequestMapping(path = "/alien")
public class AlienController {

    @Autowired
    private AlienRepository alienRepository;

    @GetMapping(path = "/add")
    public String addNewUser(@RequestParam int aid,@RequestParam String aname, @RequestParam String tech) {

        AlienEntity alien = new AlienEntity();
        System.out.println("hi enterd");
        System.out.println(aid+" "+aname+" "+tech);
        
        alien.setAid(aid);
        alien.setAname(aname);
        alien.setTech(tech);
        alienRepository.save(alien);
        return "alien Created";
    }

   

}
