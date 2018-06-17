package com.erik.languages.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.erik.languages.models.Language;
@Repository
public interface LanguageRepo extends CrudRepository<Language, Long> {
	List<Language> findAll();
	//Language updateLanguage(Language lang);
	//void deleteById(Long id);
	List<Language> findByCreatorContaining(String search);
	    // this method counts how many titles contain a certain string
	Long countByNameContaining(String search);
	    // this method deletes a book that starts with a specific title
	Long deleteByNameStartingWith(String search);
}
