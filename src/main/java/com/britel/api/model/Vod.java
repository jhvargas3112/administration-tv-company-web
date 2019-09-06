package com.britel.api.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;

/**
 * @author Juan Arratia M.
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "vod")
public class Vod implements Serializable {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "IdVod")
  private Integer idVod;
  @Column(name = "Organization")
  private Integer organization;
  @Column(name = "Category")
  private Integer category;

  public Integer getIdVod() {
    return idVod;
  }

  public void setIdVod(Integer idVod) {
    this.idVod = idVod;
  }

  public Integer getOrganization() {
    return organization;
  }

  public void setOrganization(Integer organization) {
    this.organization = organization;
  }

  public Integer getCategory() {
    return category;
  }

  public void setCategory(Integer category) {
    this.category = category;
  } 

}