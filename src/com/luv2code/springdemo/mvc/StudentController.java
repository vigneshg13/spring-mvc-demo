package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student") 
public class StudentController {

	@RequestMapping("/showForm")
	public String showForm(Model model) {
		
		
		//create the student Object
		Student theStudent = new Student();
		
		//add student object to the model
		model.addAttribute("student", theStudent);
		
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		
		
		System.out.println("theStudent:  "+theStudent.getFirstName()+" "+theStudent.getLastName());
		System.out.println("theStudent:  "+theStudent.getOperatingSystems()[0]+" "+theStudent.getOperatingSystems()[1]);
		
		return "student-confirmation";
	}
}
