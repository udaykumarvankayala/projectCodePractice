package com.bezkoder.spring.jdbc.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Tutorial {

  private long id;
  private String title;
  private String description;
  private boolean published;
  @NotNull
  @Size(min=2, message="Name should have atleast 2 characters")
  private String name;

  public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Tutorial() {

  }
  
  public Tutorial(long id, String title, String description, boolean published,String name) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.published = published;
    this.name=name;
  }

  public Tutorial(String title, String description, boolean published,String name) {
    this.title = title;
    this.description = description;
    this.published = published;
    this.name=name;
  }
  
  public void setId(long id) {
    this.id = id;
  }
  
  public long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isPublished() {
    return published;
  }

  public void setPublished(boolean isPublished) {
    this.published = isPublished;
  }

  @Override
  public String toString() {
    return "Tutorial [id=" + id + ", title=" + title + ", desc=" + description + ", published=" + published + "]";
  }

}
