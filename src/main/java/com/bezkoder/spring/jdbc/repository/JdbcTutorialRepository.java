package com.bezkoder.spring.jdbc.repository;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bezkoder.spring.jdbc.model.Tutorial;
//import com.websystique.springboot.model.User;

@Repository
public class JdbcTutorialRepository implements TutorialRepository {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Override
  public Tutorial save(Tutorial tutorial) {
	 // String str="INSERT INTO tutorials values(?,?,?)";
	  
	  String str="INSERT INTO tutorials values(?,?,?)";
	  
	  
	  
	  jdbcTemplate.update("INSERT INTO tutorials (title, description, published) VALUES(?,?,?)",
		        new Object[] { tutorial.getTitle(), tutorial.getDescription(), tutorial.isPublished() });
	  jdbcTemplate.update("INSERT INTO title_name (name) VALUES(?)",
	  new Object[] {tutorial.getName()});
	  
   // return jdbcTemplate.update("INSERT INTO tutorials (title, description, published) VALUES(?,?,?)",
     //   new Object[] { tutorial.getTitle(), tutorial.getDescription(), tutorial.isPublished() });
  return tutorial;
  }

  @Override
  public int update(Tutorial tutorial) {
    return jdbcTemplate.update("UPDATE tutorials SET title=?, description=?, published=? WHERE id=?",
        new Object[] { tutorial.getTitle(), tutorial.getDescription(), tutorial.isPublished(), tutorial.getId() });
  }

  @Override
  public Tutorial findById(Long id) {
		/*
		 * DataSource d=new DataSou String
		 * sql1="select title from tutorials  where id=?"; Connection c=DataSo
		 */
    try {
      Tutorial tutorial = jdbcTemplate.queryForObject("SELECT * FROM tutorials WHERE id=?",
          BeanPropertyRowMapper.newInstance(Tutorial.class), id);

      
      return tutorial;
    } catch (IncorrectResultSizeDataAccessException e) {
      return null;
    }
  }
  @Override
  public boolean isTitleExist(Tutorial tutorial) {
		return findByTitle(tutorial.getTitle())!=null;
	}

  @Override
  public Tutorial findByTitle(String title) {
    try {
      Tutorial tutorial = jdbcTemplate.queryForObject("SELECT title FROM tutorials WHERE title=?",
          BeanPropertyRowMapper.newInstance(Tutorial.class), title);

      return tutorial;
    } catch (IncorrectResultSizeDataAccessException e) {
      return null;
    }
  }
  @Override
  public int deleteById(Long id) {
    return jdbcTemplate.update("DELETE FROM tutorials WHERE id=?", id);
  }

  @Override
  public List<Tutorial> findAll() {
    return jdbcTemplate.query("SELECT * from tutorials", BeanPropertyRowMapper.newInstance(Tutorial.class));
  }

  @Override
  public List<Tutorial> findByPublished(boolean published) {
    return jdbcTemplate.query("SELECT * from tutorials WHERE published=?",
        BeanPropertyRowMapper.newInstance(Tutorial.class), published);
  }

  @Override
  public List<Tutorial> findByTitleContaining(String title) {
    String q = "SELECT * from tutorials WHERE title ILIKE '%" + title + "%'";

    return jdbcTemplate.query(q, BeanPropertyRowMapper.newInstance(Tutorial.class));
  }

  @Override
  public int deleteAll() {
    return jdbcTemplate.update("DELETE from tutorials");
  }
}
