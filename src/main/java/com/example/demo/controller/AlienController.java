package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.AlienRepo;
import com.example.demo.model.Alien;


@Controller
public class AlienController {
	
	@Autowired
	AlienRepo repo;// to auto wire with any other object
	
	//initial request http://localhost:8080
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
		
	}
	
	@RequestMapping("/addAlien")
	public String addAlien(Alien alien) {
		
		repo.save(alien);//auto wiring is done between repo and alien class
		return "home.jsp";
		
	}
	
	@RequestMapping("/getAlien")
	public ModelAndView addAlien(@RequestParam int aid) {
		
		ModelAndView mv=new ModelAndView("showAlien.jsp"); 
		//find by aid inbuilt
		Alien alien=repo.findById(aid).orElse(new Alien());
		//find by tech --own method
		System.out.println(repo.findByTech("java"));
		//find by aid greater than 1002--own method
		System.out.println(repo.findByAidGreaterThan(1002));
		//find by tech by sorting declare own method
		System.out.println(repo.findByTechSorted("java"));
		mv.addObject(alien);
		return mv;
		
	}
	
	@RequestMapping("/deleteAlien")
	public ModelAndView deleteAlien(@RequestParam int aid) {
		
		ModelAndView mv=new ModelAndView("delAlien.jsp"); 
		//find by aid inbuilt
		Alien alien=repo.findById(aid).orElse(new Alien());
		repo.delete(alien);
		mv.addObject(alien);
		return mv;
		
	}
	

}
