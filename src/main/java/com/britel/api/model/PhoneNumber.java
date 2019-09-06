package com.britel.api.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.Column;

/**
 * @author Jhonny Vargas.
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "phonenumber")

public class PhoneNumber implements Serializable {
  
  @Id
  @Column(name = "User")
  private Integer _user;

  @Id
  @Column(name = "PhoneNumber")
  private String phoneNumber;

  public Integer getUser() {
    return _user;
  }

  public void setUser(Integer user) {
    this._user = user;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

}