package com.britel.api.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;

/**
 * @author Jhonny Vargas.
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "channel")
public class Channel implements Serializable {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "IdChannel")
  private Integer idChannel;
  @Column(name = "LogicalChannelNumber")
  private Integer logicalChannelNumber;
  @Column(name = "Url")
  private String url;
  @Column(name = "Name")
  private String name;
  @Column(name = "Description")
  private String description;
  @Column(name = "AspectRatio", columnDefinition = "enum('4:3','16:9')")
  private String aspectRatio;
  @Column(name = "Quality", columnDefinition = "enum('SD','HD')")
  private String quality;
  @Column(name = "Visibility", columnDefinition = "enum('Private','Public')")
  private String visibility;
  @Column(name = "Logo")
  private String logo;

  public Integer getIdChannel() {
    return idChannel;
  }

  public void setIdChannel(Integer idChannel) {
    this.idChannel = idChannel;
  }

  public Integer getLogicalChannelNumber() {
    return logicalChannelNumber;
  }

  public void setLogicalChannelNumber(Integer logicalChannelNumber) {
    this.logicalChannelNumber = logicalChannelNumber;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
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

  public String getAspectRatio() {
    return aspectRatio;
  }

  public void setAspectRatio(String aspectRatio) {
    this.aspectRatio = aspectRatio;
  }

  public String getQuality() {
    return quality;
  }

  public void setQuality(String quality) {
    this.quality = quality;
  }

  public String getVisibility() {
    return visibility;
  }

  public void setVisibility(String visibility) {
    this.visibility = visibility;
  }

  public String getLogo() {
    return logo;
  }

  public void setLogo(String logo) {
    this.logo = logo;
  }

}
