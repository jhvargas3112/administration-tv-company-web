package com.britel.api.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import java.util.Set;

/**
 * @author Jhonny Vargas.
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "category")
public class Category implements Serializable {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "IdCategory")
  private Integer idCategory;
  @Column(name = "Name")
  private String name;
  @Column(name = "Description")
  private String description;
  @Column(name = "Visible", columnDefinition="tinyint(4)")
  private Integer visible;
  @Column(name = "IdCategoryFather")
  private Integer idCategoryFather;

  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinTable(
      name = "containcategoryvideo",
      joinColumns = @JoinColumn(name = "Category", referencedColumnName = "IdCategory"),
      inverseJoinColumns = @JoinColumn(name = "Video", referencedColumnName = "IdVideo")
      )
  private Set<Video> videos;

  public Integer getIdCategory() {
    return idCategory;
  }

  public void setIdCategory(Integer idCategory) {
    this.idCategory = idCategory;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getVisible() {
    return visible;
  }

  public void setVisible(Integer visible) {
    this.visible = visible;
  }

  public Integer getIdCategoryFather() {
    return idCategoryFather;
  }

  public void setIdCategoryFather(Integer idCategoryFather) {
    this.idCategoryFather = idCategoryFather;
  }

}