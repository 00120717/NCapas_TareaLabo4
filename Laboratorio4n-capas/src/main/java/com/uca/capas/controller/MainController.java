package com.uca.capas.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Product;
import com.uca.capas.domain.Robot;

@Controller
public class MainController {
	
	@RequestMapping("/producto")
	public ModelAndView	initMain() {
		Product producto = new Product();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("product",producto);
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/formProducto")
	public ModelAndView formProducto(@Valid @ModelAttribute Product producto, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName("index");
			
		}else {
			
			Robot robot = new Robot();
			mav.addObject("robot",robot);
			mav.setViewName("robot");
		}
		return mav;
	}
	
	@RequestMapping("/seguridad")
	public ModelAndView formSeguridad(@Valid @ModelAttribute Robot robot, BindingResult result) {
		
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName("robot");
		}else {
			mav.setViewName("exito");
		}
		return mav;
	}
}
