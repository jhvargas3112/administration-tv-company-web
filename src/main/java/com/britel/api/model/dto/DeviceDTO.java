package com.britel.api.model.dto;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author Jhonny Vargas.
 */

@SuppressWarnings("serial")
public class DeviceDTO implements Serializable {
  
  private String udid;
  private Integer company;
  private Boolean active;
  private Timestamp activeDate;
  private Timestamp creationDate;
  private Boolean test;
  private Timestamp desactivationDate;
  private Timestamp lastAccessDate;
  private String description;

  public DeviceDTO(String udid, Integer company, Boolean active, Timestamp activeDate, Timestamp creationDate, Boolean test,
      Timestamp desactivationDate, Timestamp lastAccessDate, String description) {
    super();
    this.udid = udid;
    this.company = company;
    this.active = active;
    this.activeDate = activeDate;
    this.creationDate = creationDate;
    this.test = test;
    this.desactivationDate = desactivationDate;
    this.lastAccessDate = lastAccessDate;
    this.description = description;
  }

  public String getUdid() {
    return udid;
  }

  public void setUdid(String udid) {
    this.udid = udid;
  }

  public Integer getCompany() {
    return company;
  }

  public void setCompany(Integer company) {
    this.company = company;
  }

  public Boolean getActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  public Timestamp getActiveDate() {
    return activeDate;
  }

  public void setActiveDate(Timestamp activeDate) {
    this.activeDate = activeDate;
  }

  public Timestamp getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Timestamp creationDate) {
    this.creationDate = creationDate;
  }

  public Boolean getTest() {
    return test;
  }

  public void setTest(Boolean test) {
    this.test = test;
  }

  public Timestamp getDesactivationDate() {
    return desactivationDate;
  }

  public void setDesactivationDate(Timestamp desactivationDate) {
    this.desactivationDate = desactivationDate;
  }

  public Timestamp getLastAccessDate() {
    return lastAccessDate;
  }

  public void setLastAccessDate(Timestamp lasAccessDate) {
    this.lastAccessDate = lasAccessDate;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

}
