package com.erik.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.erik.languages.models.Language;
import com.erik.languages.services.LanguageService;

@Controller
public class LanguagesController {
	private final LanguageService langService;
	public LanguagesController(LanguageService langService) {
		this.langService = langService;
	}
	@RequestMapping("/")
	public String redirect() {
		return "redirect:/languages";
	}
	//SHOW ALL LANGUAGES
	@GetMapping("/languages")
	public String index(@ModelAttribute("language") Language language,Model model) {
		List<Language> languages = langService.allLanguages();
		model.addAttribute("languages", languages);
		System.out.println(model);
		return "/languages/index.jsp";
	}
	//MAKE NEW LANGUAGE
	@PostMapping("/languages")
	public String create(@Valid @ModelAttribute("langs") Language lang, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("errors in post");
		}
		else {
			System.out.println("post was valid");
			langService.createLanguage(lang);
		}
		return "redirect:/languages/";
	}
	//SHOW SPECIFIC LANGUAGE
	@RequestMapping("/languages/{lang_id}")
	public String show(@PathVariable("lang_id") Long lang_id, Model model) {
		Language lang = langService.findLanguage(lang_id);
		if(lang == null) {
			return "redirect:/languages";
		}
		else {
			model.addAttribute("lang",lang);
			return "/languages/show.jsp";
		}
	}
	//EDIT SPECIFIC LANGUAGE
	@RequestMapping("/languages/{lang_id}/edit")
	public String edit(@PathVariable("lang_id") Long lang_id, Model model, @ModelAttribute("language") Language language) {
		Language lang = langService.findLanguage(lang_id);
		if(lang == null) {
			return "redirect:/languages";
		}
		else {
			model.addAttribute("lang",lang);
			return "/languages/edit.jsp";
		}
	}
	//UPDATE DB
	@RequestMapping(value = "/languages/{lang_id}", method = RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("langs") Language lang, BindingResult result, @PathVariable("lang_id") String lang_id) {
		if (result.hasErrors()) {
			System.out.println("update invalid");
		}
		else {
			langService.updateLanguage(lang);
		}
		return "redirect:/languages/"+lang_id;
	}
	//DELETE FROM DB
	@RequestMapping(value="/languages/{lang_id}", method=RequestMethod.DELETE)
	public String destroy(@PathVariable("lang_id") Long id) {
		langService.deleteLanguage(id);
		return "redirect:/languages";
	}
	
	
}
