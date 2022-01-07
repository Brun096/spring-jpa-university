package org.generation.italy.controller;

import org.generation.italy.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DepartmentController {

	@Autowired
	private DepartmentRepository repository;
	
	@GetMapping
	public String departments(Model model) {
		
		model.addAttribute("departments", repository.findAll(Sort.by("name")));
		return "department";
	}
	
	@GetMapping("/department/{id}")
	public String degreeDetail(Model model, @PathVariable int id) {
		model.addAttribute("departmentId",id);
		
		return "detail";
	}
	
}