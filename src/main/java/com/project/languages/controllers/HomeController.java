package com.project.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.languages.models.Language;
import com.project.languages.services.LanguageService;

@Controller
public class HomeController {
	private final LanguageService languageService;
	
	public HomeController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
    @RequestMapping("/languages")
    public String index(Model model, @ModelAttribute("language") Language language){
        List<Language> languages = languageService.allLanguages();
        model.addAttribute("languages", languages);
        return "languages/index.jsp";
    }
    
    @RequestMapping(value = "/languages", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("language") Language language , BindingResult result) {
    	if (result.hasErrors()) {
    		return "languages/index.jsp";
    	}else {
    		languageService.createLanguage(language);
    		return "redirect:/languages";
    	}
    }
    
    @RequestMapping("/languages/{id}")
    public String display(@PathVariable("id") Long id, Model model) {
    	Language lang = languageService.findLanguage(id);
    	model.addAttribute("language",lang);
    	return "languages/show.jsp";
    }
    
    @RequestMapping(value = "languages/{id}/edit" , method=RequestMethod.GET)
    public String edit(@PathVariable("id") Long id, Model model){
        Language lang = languageService.findLanguage(id);
        model.addAttribute("language",lang);
        return "languages/edit.jsp";
    }
    
	@RequestMapping(value="languages/{id}", method=RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("language") Language language,BindingResult result, @PathVariable("id") Long id,
			@RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="currentVersion") String currentVersion){
		
		if (result.hasErrors()) {
			return "languages/edit.jsp";
		} else {
			languageService.updateLanguage(id, name, creator, currentVersion);
			return "redirect:/languages";
		}
	}
}
