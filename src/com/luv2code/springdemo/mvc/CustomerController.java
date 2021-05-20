package com.luv2code.springdemo.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.InitBinder;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@RequestMapping("/showForm")
	public String customerForm(Model model) {
		
		//create customer object
		Customer customer = new Customer();
		
		//add customer object to model
		model.addAttribute(customer);
		
		//return the jsp name for view resolver
		return "customer-form";
		
	}
	
	@RequestMapping("/processForm")
	public String CustomerProcessForm(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult theBindingResult) {
		
		System.out.println("Last Name: |"+theCustomer.getLastName()+"|");
		if(theBindingResult.hasErrors()) {
			return "customer-form";
		} else {
			return "customer-confirmation";
		}
		
	}
	
	@InitBinder
	public void InitBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor editor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, editor);
	}

}
