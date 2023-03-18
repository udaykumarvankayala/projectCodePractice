package com.bezkoder.spring.jdbc.repository;

import java.util.List;

import com.bezkoder.spring.jdbc.model.Tutorial;
//import com.websystique.springboot.model.User;

public interface TutorialRepository {
  Tutorial save(Tutorial book);

  int update(Tutorial book);
  Tutorial findByTitle(String title);

  boolean isTitleExist(Tutorial book1);
  Tutorial findById(Long id);

  int deleteById(Long id);

  List<Tutorial> findAll();

  List<Tutorial> findByPublished(boolean published);

  List<Tutorial> findByTitleContaining(String title);

  int deleteAll();
}
