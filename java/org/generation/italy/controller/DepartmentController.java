package org.generation.italy.controller;

import org.generation.italy.model.Degree;

import org.generation.italy.model.Department;
import org.generation.italy.repository.DegreeRepository;
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
	private DepartmentRepository repositoryD;
	@Autowired
	private DegreeRepository repositoryDg;
	
	@GetMapping
	public String departments(Model model) {
		
		model.addAttribute("departments", repositoryD.findAll(Sort.by("name")));
		return "department";
	}
	
	@GetMapping("/department/{id}")
	public String degreeDetail(Model model, @PathVariable int id) {
		//model.addAttribute("departmentId",id);
		
		Department d=repositoryD.getById(id);
		
		model.addAttribute("department",d);
//		model.addAttribute("degree", d.getDegrees());
		
		return "detail";
	}
	
}