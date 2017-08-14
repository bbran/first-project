package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.Adder;
import com.example.demo.models.Divider;
import com.example.demo.models.Exponentiator;
import com.example.demo.models.HistoryEntry;
import com.example.demo.models.Modulotor;
import com.example.demo.models.Multiplier;
import com.example.demo.models.Subtractor;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {
	List<HistoryEntry> historyList = new ArrayList<>();
	
	@ModelAttribute("history")
	public Iterable<HistoryEntry> history()	{
		return historyList;
	}
	
	@GetMapping("")
	public String showCalculator() {
		historyList.clear();
		return "calculator/calculator";
	}
	
	@GetMapping("calculate")
	public String redirectToCalculator()	{
		historyList.clear();
		return "calculator/calculator";	
	}
	
	@PostMapping("calculate")
	public ModelAndView calculateResult(double left, double right, String operation)	{
		ModelAndView mv = new ModelAndView();
		
		if (operation.equals("add"))	{
			Adder adder = new Adder(left, right);
			double theResult = adder.calculate();
			mv.addObject("result", theResult);
			historyList.add(0, new HistoryEntry(left + " + " + right + " = " + theResult));
		}
		else if (operation.equals("subtract"))	{
			Subtractor subtractor = new Subtractor(left, right);
			double theResult = subtractor.calculate();
			mv.addObject("result", theResult);
			historyList.add(0, new HistoryEntry(left + " - " + right + " = " + theResult));
		}
		else if (operation.equals("multiply"))	{
			Multiplier multiplier = new Multiplier(left, right);
			double theResult = multiplier.calculate();
			mv.addObject("result", theResult);
			historyList.add(0, new HistoryEntry(left + " * " + right + " = " + theResult));
		}
		else if (operation.equals("divide"))	{
			Divider divider = new Divider(left, right);
			double theResult = divider.calculate();
			mv.addObject("result", theResult);
			historyList.add(0, new HistoryEntry(left + " / " + right + " = " + theResult));
		}
		else if (operation.equals("modulo"))	{
			Modulotor mod = new Modulotor(left, right);
			double theResult = mod.calculate();
			mv.addObject("result", theResult);
			historyList.add(0, new HistoryEntry(left + " % " + right + " = " + theResult));
		}
		else	{
			Exponentiator exp = new Exponentiator(left, right);
			double theResult = exp.calculate();
			mv.addObject("result", theResult);
			historyList.add(0, new HistoryEntry(left + " ^ " + right + " = " + theResult));
		}
		mv.addObject("history", historyList);
		return mv;
	}

}
