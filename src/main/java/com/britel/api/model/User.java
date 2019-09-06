package com.britel.api.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author Jhonny Vargas.
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "user")
public class User implements Serializable {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "IdUser")
  private Integer idUser;
  @Column(name = "Type", columnDefinition="enum('Admin','Company','Subscriber','VOD')")
  private String type;
  @Column(name = "SubscriberType", columnDefinition="enum('STB','MOVIL','ANDROIDTV','SAMSUNG','LG')")
  private String subscriberType;
  @Column(name = "Email")
  private String email;
  @Column(name = "Description")
  private String description;
  @Column(name = "Password")
  private String password;
  @Column(name = "City")
  private String city;
  @Column(name = "Country")
  private String country;
  @Column(name = "Address")
  private String address;
  @Column(name = "PostalCode")
  private Integer postalCode;
  @Column(name = "FirstName")
  private String firstName;
  @Column(name = "LastName")
  private String lastName;
  @Column(name = "Active", columnDefinition = "BIT")
  private Boolean active;
  @Column(name = "Test", columnDefinition = "BIT")
  private Boolean test;
  @Column(name = "IdCompany")
  private Integer idCompany;

  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinTable(
      name = "devicesubscriber",
      joinColumns = @JoinColumn(name = "Subscriber", referencedColumnName = "IdUser"),
      inverseJoinColumns = @JoinColumn(name = "Device", referencedColumnName = "Udid")
      )
  private List<Device> devices = new ArrayList<Device>();

  public Integer getIdUser() {
    return idUser;
  }

  public void setIdUser(Integer idUser) {
    this.idUser = idUser;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getSubscriberType() {
    return subscriberType;
  }

  public void setSubscriberType(String SubscriberType) {
    this.subscriberType = SubscriberType;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Integer getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(Integer postalCode) {
    this.postalCode = postalCode;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Boolean getActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  public Boolean getTest() {
    return test;
  }

  public void setTest(Boolean test) {
    this.test = test;
  }

  public Integer getIdCompany() {
    return idCompany;
  }

  public void setIdCompany(Integer idCompany) {
    this.idCompany = idCompany;
  }

  public List<Device> getDevices() {
    return devices;
  }

  public void setDevices(List<Device> devices) {
    this.devices = devices;
  }

}
