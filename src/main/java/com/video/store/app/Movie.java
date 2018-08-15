package com.video.store.app;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Movies")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Movie
{
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "Movie_Id")
private int movieId; 

@Column(name = "Title")
private String title;

@Column(name = "Genre")
private String genre;

@Column(name = "Language")
private String language;


@Column(name = "Year")
private String year;


public Movie(){}

public Movie(int movieId, String title, String genre, String language, String year)
{
  super();
  this.movieId = movieId;
  this.title = title;
  this.genre = genre;
  this.language = language;
  this.year = year;
}
/**
 * @return the movieId
 */
public int getMovieId()
{
  return movieId;
}
/**
 * @param movieId the movieId to set
 */
public void setMovieId(int movieId)
{
  this.movieId = movieId;
}
/**
 * @return the title
 */
public String getTitle()
{
  return title;
}
/**
 * @param title the title to set
 */
public void setTitle(String title)
{
  this.title = title;
}

/**
 * @return the genre
 */
public String getGenre()
{
  return genre;
}
/**
 * @param genre the genre to set
 */
public void setGenre(String genre)
{
  this.genre = genre;
}
/**
 * @return the language
 */
public String getLanguage()
{
  return language;
}
/**
 * @param language the language to set
 */
public void setLanguage(String language)
{
  this.language = language;
}
/**
 * @return the year
 */
public String getYear()
{
  return year;
}
/**
 * @param year the year to set
 */
public void setYear(String year)
{
  this.year = year;
}


}
