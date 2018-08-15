package com.video.store.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.video.store.app.Movie;
import com.video.store.app.MovieRepo;
import com.video.store.app.UserCredentials;
import com.video.store.app.UserCredentialsRepo;

@RestController
@RequestMapping("/api")
@Component
public class MovieController
{
  @Autowired
  MovieRepo movieRepo;
  
  @Autowired
  UserCredentialsRepo credentialsRepo;
  
  
  
  @RequestMapping(value = "/findall", method= RequestMethod.GET)
  @ResponseBody
  public List<Movie> findAll()
  {
    return movieRepo.findAll();  
  }
  
  @RequestMapping(value = "/credentials", method= RequestMethod.GET)
  @ResponseBody
  public List<UserCredentials> findCredentials()
  {
    return credentialsRepo.findAll();  
  }
  
  @RequestMapping(value = "/findById/{id}", method= RequestMethod.GET)
  @ResponseBody
  public Movie findById(@PathVariable(value = "id") int movieId)
  {
    return movieRepo.getOne(movieId);  
  }
  
  @RequestMapping(value = "/add", method= RequestMethod.POST)
  public Movie createMovie(@Valid @RequestBody Movie movie)
  {
    return movieRepo.save(movie);  
  }
  
  
  @RequestMapping(value = "/edit/{id}", method= RequestMethod.PUT)
  public Movie editMovie(@PathVariable(value = "id") int movieId, @Valid @RequestBody Movie movie)
  {
    String resuls = "";
    Movie movieFound = null;
    
    movieFound = movieRepo.getOne(movieId);
    if(movieFound != null)
    {
      movieFound.setTitle(movie.getTitle());
      movieFound.setGenre(movie.getGenre());
      movieFound.setLanguage(movie.getLanguage());
      movieFound.setYear(movie.getYear());
      movieFound = movieRepo.save(movieFound);
    }
    
    return movieFound;  
  }
  
 
}
