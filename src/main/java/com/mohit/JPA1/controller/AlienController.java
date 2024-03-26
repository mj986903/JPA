package com.mohit.JPA1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mohit.JPA1.dao.AlienRepo;
import com.mohit.JPA1.model.Alien;

@RestController
public class AlienController {
	@Autowired
	AlienRepo repo;
	
	@RequestMapping("home")
	public String home() {
		return "home.jsp";
	}
	@RequestMapping("/addAlien")
	public String addAlien(Alien alien) {
		repo.save(alien);
		return "home.jsp";
	}
	
	@PostMapping(path="/alien")
	public Alien addAliens(Alien alien) {
		repo.save(alien);
		return alien;
	}
	
	// Without Rest URL
	/*@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam int aid) {
		ModelAndView mv = new ModelAndView("showAlien.jsp");
		Alien alien = repo.findById(aid).orElse(new Alien());
		mv.addObject("obj",alien);
		return mv;
	}*/
	
	// With Rest URL
	@GetMapping("/alien/{aid}")
	public Optional<Alien> getAlien(@PathVariable("aid") int aid) {
		return repo.findById(aid);
	}
	
	/*@RequestMapping("/deleteAlien")
	public String deleteAlien(@RequestParam int aid) {
		repo.deleteById(aid);
		return "home.jsp";
	}*/
	
	@DeleteMapping("/alien/{aid}")
	public Optional<Alien> deleteAlien(@PathVariable int aid) {
		Optional<Alien> alien = repo.findById(aid);
		repo.deleteById(aid);
		return alien;
	}
	
	@RequestMapping("/displayCount")
	public ModelAndView countAlien() {
		ModelAndView mv = new ModelAndView("showAlien.jsp");
		long count = repo.count();
		System.out.println(count);
		mv.addObject("obj",count);
		return mv;
	}
	// Without Rest URL
	/*@RequestMapping("/allAlien")
	public ModelAndView allAlien() {
		ModelAndView mv = new ModelAndView("showAlien.jsp");
		Iterable<Alien> alien = repo.findAll();
		mv.addObject("obj",alien);
		return mv;
	}*/
	
	// With Rest URL
	@GetMapping(path="/aliens"/*, produces= {"application/xml"}*/)
	public List<Alien> getAliens() {
		return repo.findAll();
	}
	
	@RequestMapping("/findByTech")
	public ModelAndView findByTech(@RequestParam String tech) {
		ModelAndView mv = new ModelAndView("showAlien.jsp");
		List<Alien> alien = repo.findByTech(tech);
		mv.addObject("obj",alien);
		return mv;
	}
	
	@PutMapping(path="/alien")
	public Alien updateAlien(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;
	}
}
