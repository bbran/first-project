package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.Whisperer;
import com.example.demo.models.Yeller;

@Controller
@RequestMapping({"/", "/HelloWorld"})
public class HelloWorldController {
	
	private String title;
	
	public HelloWorldController() {
		title = "Hello Java and Spring!";
	}
	
	@GetMapping("")
	public String index() {
		return "helloworld/index";
	}
	
	@GetMapping("message")
	public ModelAndView message(@RequestParam(required=false, defaultValue="«silence»") String message) {
		Yeller yeller = new Yeller(message);
		ModelAndView mv = new ModelAndView("helloworld/message");
		
		mv.addObject("title", title);
		mv.addObject("thingToShow", yeller.yell());
		return mv;
	}
	
	@GetMapping("whisper")
	public ModelAndView whisper(@RequestParam(required=false, defaultValue="«shhhhhhh»") String whisper) {
		Whisperer whisperer = new Whisperer(whisper);
		ModelAndView mv = new ModelAndView("helloworld/whisper");
		
		mv.addObject("title", title);
		mv.addObject("message", whisperer.whisper());
		return mv;
	}
	
	@GetMapping("say-something")
	public ModelAndView makeAChoice(
			String speechChoice,
			String message
			)	{
		ModelAndView mv = new ModelAndView("helloworld/mixed-messages");
		mv.addObject("title", title);
		
		//if speechChoice is loud
		if (speechChoice.equals("loud"))	{
			//make message LOUD
			Yeller yeller = new Yeller(message);
			mv.addObject("output", yeller.yell());
		}
		//otherwise
		else {
			//make message quiet
			Whisperer whisperer = new Whisperer(message);
			mv.addObject("output", whisperer.whisper());
		}

		return mv;
	}
	 
}
