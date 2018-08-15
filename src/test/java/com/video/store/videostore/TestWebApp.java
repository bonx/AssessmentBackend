package com.video.store.videostore;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public class TestWebApp extends VideoStoreApplicationTests{

  @Autowired
  private WebApplicationContext webApplicationContext;

  private MockMvc mockMvc;

  @Before
  public void setup() {
    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
  }

  @Test
  public void testFindAllPositive() throws Exception {
    mockMvc.perform(get("/api/findall")).andExpect(status().isOk())
        .andExpect(content().contentType("application/json;charset=UTF-8"))
        .andExpect(jsonPath("$.[0].title").value("Dead Pool 3")).andExpect(jsonPath("$.[0].genre").value("Action"))
        .andExpect(jsonPath("$.[0].language").value("English")).andExpect(jsonPath("$.[0].year").value("2019"));
  }
  
  @Test
  public void testFindAllNegative() throws Exception {
    mockMvc.perform(get("/findall")).andExpect(status().is4xxClientError());
      }
  
  @Test
  public void testCredentialsPositive() throws Exception {
    mockMvc.perform(get("/api/credentials")).andExpect(status().isOk())
        .andExpect(content().contentType("application/json;charset=UTF-8"))
        .andExpect(jsonPath("$.[0].userName").value("Admin")).andExpect(jsonPath("$.[0].password").value("admin123!"));
  }
  
  @Test
  public void testCredentialsNegative() throws Exception {
    mockMvc.perform(get("/api/credential")).andExpect(status().is4xxClientError());
        }

  
  @Test
  public void testFindByIdPositive() throws Exception {
    mockMvc.perform(get("/api/findById/0")).andExpect(status().isOk())
    .andExpect(content().contentType("application/json;charset=UTF-8"))
    .andExpect(jsonPath("$.title").value("Dead Pool 3")).andExpect(jsonPath("$.genre").value("Action"))
    .andExpect(jsonPath("$.language").value("English")).andExpect(jsonPath("$.year").value("2019"));
  }
  
  @Test
  public void testFindByIdNegative() throws Exception {
    mockMvc.perform(get("/api/findById")).andExpect(status().is4xxClientError());
    }
  
  @Test
  public void testAddPositive() throws Exception {
    String mockMovie = "{"
    +"\"title\": \"Dead Pool 3\","
    +"\"genre\": \"Action\","
    +"\"language\": \"English\","
    +"\"year\": \"2018\""
      +"}";
    mockMvc.perform(post("/api/add").contentType("application/json;charset=UTF-8")
        .content(mockMovie))
        .andExpect(status().isOk());
        
  }
  
  @Test
  public void testAddNegative() throws Exception {
    String mockMovie = "{"
    +"\"titles\": \"Dead Pool 2\","
    +"\"genre\": \"Action\","
    +"\"language\": \"English\","
    +"\"year\": \"2018\""
      +"}";
    mockMvc.perform(put("/api/add").contentType("application/json;charset=UTF-8")
        .content(mockMovie))
        .andExpect(status().is4xxClientError());
        
  }
  
  @Test
  public void testEditPositive() throws Exception {
    String mockMovie = "{"
    +"\"title\": \"Dead Pool 3\","
    +"\"genre\": \"Action\","
    +"\"language\": \"English\","
    +"\"year\": \"2019\""
      +"}";
    mockMvc.perform(put("/api/edit/0").contentType("application/json;charset=UTF-8")
        .content(mockMovie))
        .andExpect(status().isOk())
            .andExpect(jsonPath("$.title").value("Dead Pool 3")).andExpect(jsonPath("$.genre").value("Action"))
            .andExpect(jsonPath("$.language").value("English")).andExpect(jsonPath("$.year").value("2019"));
        }
  
  @Test
  public void testEditNegative() throws Exception {
    String mockMovie = "{"
    +"\"title\": \"Dead Pool 3\","
    +"\"genre\": \"Action\","
    +"\"language\": \"English\","
    +"\"year\": \"2019\""
      +"}";
    mockMvc.perform(put("/api/edit").contentType("application/json;charset=UTF-8")
        .content(mockMovie))
        .andExpect(status().is4xxClientError());
             }
}