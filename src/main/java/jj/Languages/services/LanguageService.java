package jj.Languages.services;

import java.util.List;
import org.springframework.stereotype.Service;

import jj.Languages.models.Language;
import jj.Languages.repositories.LanguageRepository;
@Service
public class LanguageService {
   
    private final LanguageRepository languageRepository;
    
    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }
  
    public List<Language> allLanguage() {
        return languageRepository.findAll();
    }

    public Language createLanguage(Language b) {
        return languageRepository.save(b);
    }
   
    public Language findLanguage(Long id) {
    	return this.languageRepository.findById(id).orElse(null);
    }
    
    public void deleteLanguage(Long id) {
    	this.languageRepository.deleteById(id);
    }
    
    public Language updateLanguage(Language b) {
    	
    	return languageRepository.save(b);
    } 
     
	
}