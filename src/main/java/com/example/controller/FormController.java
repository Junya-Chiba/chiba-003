package com.example.controller;

import com.example.model.FormModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FormController {

	//デフォルトでアクセスした場合
	@RequestMapping(value="/")
	public String index(Model model){
		model.addAttribute("inputForm", new FormModel());
		return "input";
	}
	
	//input.htmlを指定してアクセスした場合
	@RequestMapping(value="/input")
	public String input(Model model){
		model.addAttribute("inputForm", new FormModel());
		return "input";
	}
	
	//Submitボタンが押下された場合
	@RequestMapping(value="/output", method=RequestMethod.POST)
	public String output(@ModelAttribute FormModel formModel, Model model){
		model.addAttribute("name", formModel.getName().toUpperCase());
		return "output";
	}
}
