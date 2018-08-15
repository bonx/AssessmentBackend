package com.video.store.app;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usercredentials")
public class UserCredentials
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "usercredentialsId")
  private  int  usercredentialsId;
 
  @Column(name = "Username")
  private String userName;
  
  //Should be encrypted on DB..
  @Column(name = "Password")
  private String password;
  
  
  public UserCredentials()
  {
  }
  
  public UserCredentials(String userName, String password)
  {
    super();
    this.userName = userName;
    this.password = password;
  }
  /**
   * @return the userName
   */
  public String getUserName()
  {
    return userName;
  }
  /**
   * @param userName the userName to set
   */
  public void setUserName(String userName)
  {
    this.userName = userName;
  }
  /**
   * @return the password
   */
  public String getPassword()
  {
    return password;
  }
  /**
   * @param password the password to set
   */
  public void setPassword(String password)
  {
    this.password = password;
  }
  /**
   * @return the credentialsId
   */
  public int getCredentialsId()
  {
    return usercredentialsId;
  }
  /**
   * @param credentialsId the credentialsId to set
   */
  public void setCredentialsId(int usercredentialsId)
  {
    this.usercredentialsId = usercredentialsId;
  }

}
