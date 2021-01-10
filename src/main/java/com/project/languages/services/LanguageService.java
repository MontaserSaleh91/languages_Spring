package com.project.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.languages.models.Language;
import com.project.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	 // adding the language repository as a dependency
    private final LanguageRepository languageRepository;
    
    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }
    // returns all the language
    public List<Language> allLanguages() {
        return languageRepository.findAll();
    }
    // creates a language
    public Language createLanguage(Language b) {
        return languageRepository.save(b);
    }
    // retrieves a language
    public Language findLanguage(Long id) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }

    public Language updateLanguage(Long id, String name, String creator, String currentVersion) {
		Optional<Language> optionalLanguage = languageRepository.findById(id);
		if(optionalLanguage.isPresent()) {
			Language updateLanguage = optionalLanguage.get();
			// Update fields
			updateLanguage.setName(name);
			updateLanguage.setCreator(creator);
			updateLanguage.setCurrentVersion(currentVersion);
			
			return languageRepository.save(updateLanguage);
		} else {
			return null;
		}
	}
    
    public void deleteLanguage(Long id) {
    	languageRepository.deleteById(id);
    }
}
