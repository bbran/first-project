package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.Adder;
import com.example.demo.models.Divider;
import com.example.demo.models.Exponentiator;
import com.example.demo.models.Modulotor;
import com.example.demo.models.Multiplier;
import com.example.demo.models.Subtractor;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {
	
	@GetMapping("")
	public String showCalculator() {
		return "calculator/calculator";
	}
	
	@GetMapping("calculate")
	public String redirectToCalculator()	{
		return "calculator/calculator";	
	}
	
	@PostMapping("calculate")
	public ModelAndView calculateResult(double left, double right, String operation)	{
		ModelAndView mv = new ModelAndView();
		
		if (operation.equals("add"))	{
			Adder adder = new Adder(left, right);
			mv.addObject("result", adder.calculate());
		}
		else if (operation.equals("subtract"))	{
			Subtractor subtractor = new Subtractor(left, right);
			mv.addObject("result", subtractor.calculate());
		}
		else if (operation.equals("multiply"))	{
			Multiplier multiplier = new Multiplier(left, right);
			mv.addObject("result", multiplier.calculate());
		}
		else if (operation.equals("divide"))	{
			Divider divider = new Divider(left, right);
			mv.addObject("result", divider.calculate());
		}
		else if (operation.equals("modulo"))	{
			Modulotor mod = new Modulotor(left, right);
			mv.addObject("result", mod.calculate());
		}
		else	{
			Exponentiator exp = new Exponentiator(left, right);
			mv.addObject("result", exp.calculate());
		}
		return mv;
	}

}
