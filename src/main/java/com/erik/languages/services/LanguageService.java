package com.erik.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.erik.languages.models.Language;
import com.erik.languages.repo.LanguageRepo;
@Service
public class LanguageService {
	private final LanguageRepo languageRepo;
	public LanguageService(LanguageRepo langRepo) {
		this.languageRepo = langRepo;
	}
	public List<Language> allLanguages(){
		return languageRepo.findAll();
	}
	public Language createLanguage(Language l) {
		return languageRepo.save(l);
	}
	public Language findLanguage(Long id) {
		Optional<Language> optionalLang = languageRepo.findById(id);
		if (optionalLang.isPresent()) {
			return optionalLang.get();
		}
		else {
			return null;
		}
	}
	public Language updateLanguage(Language toUpdate) {
		Language existingLang = this.findLanguage(toUpdate.getId());
		if (existingLang == null) {
			System.out.println(existingLang);
			this.createLanguage(toUpdate);
			return toUpdate;
		}
		else {
			System.out.println(existingLang);
			languageRepo.save(existingLang);
			return toUpdate;
		}
	}
	public void deleteLanguage(Long id) {
		languageRepo.deleteById(id);
	}
}
