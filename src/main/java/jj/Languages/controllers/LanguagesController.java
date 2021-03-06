package jj.Languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jj.Languages.models.Language;
import jj.Languages.services.LanguageService;

@Controller
public class LanguagesController {
    private final LanguageService languageService;
    
    public LanguagesController(LanguageService languageService) {
        this.languageService = languageService;
    }
    
    @RequestMapping("/languages")
    public String index(Model model, @ModelAttribute("oneLanguage") Language lang) {
        List<Language> languages = languageService.allLanguage();
//        Language lang = new Language();
//        model.addAttribute("oneLanguage", lang);
        model.addAttribute("languages", languages);
        return "/languages/index.jsp";
    }
    
   
    @RequestMapping(value="/languages/add", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("oneLanguage") Language language, BindingResult result) {
    	System.out.println("**************");
    	System.out.println(language);
    	
    	if (result.hasErrors()) {
            return "/languages/index.jsp";
        } else {
        	languageService.createLanguage(language);
            return "redirect:/languages";
        }
    }
    
    @RequestMapping("languages/show/{id}")
    public String show(@PathVariable("id") Long id,Model model) {
    	Language language = languageService.findLanguage(id);
        model.addAttribute("language", language);
        return "/languages/show.jsp";
    }
    @RequestMapping("/languages/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
    	Language language = languageService.findLanguage(id);
        model.addAttribute("language", language);
        return "/languages/edit.jsp";
    }
    
    @RequestMapping(value="/languages/{id}/update", method=RequestMethod.POST)
    public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
        	System.out.println(result.getAllErrors());
            return "/languages/edit.jsp";
        } else {
        	languageService.updateLanguage(language);
            return "redirect:/languages";
        }
        
       }
    @RequestMapping(value="/languages/{id}/delete", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
    	languageService.deleteLanguage(id);
        return "redirect:/languages";
    }
    
    
    
}