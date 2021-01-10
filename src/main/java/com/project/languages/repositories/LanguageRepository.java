package com.project.languages.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.project.languages.models.Language;

public interface LanguageRepository extends CrudRepository<Language, Long>{
    List<Language> findAll();
    void deleteById(Long id);
}
