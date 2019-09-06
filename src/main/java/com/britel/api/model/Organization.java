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
@Table(name = "organization")
public class Organization implements Serializable {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "IdOrganization")
  private Integer idOrganization;
  @Column(name = "Name")
  private String name;

  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinTable(
      name = "companyorganization",
      joinColumns = @JoinColumn(name = "Organization", referencedColumnName = "IdOrganization"),
      inverseJoinColumns = @JoinColumn(name = "Company", referencedColumnName = "IdUser")
      )
  private Set<User> users;

  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinTable(
      name = "containorganizationpackage",
      joinColumns = @JoinColumn(name = "Organization", referencedColumnName = "IdOrganization"),
      inverseJoinColumns = @JoinColumn(name = "Package", referencedColumnName = "IdPackage")
      )
  private Set<Package> packages;

  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinTable(
      name = "deviceorganization",
      joinColumns = @JoinColumn(name = "Organization", referencedColumnName = "IdOrganization"),
      inverseJoinColumns = @JoinColumn(name = "Device", referencedColumnName = "Udid")
      )
  private Set<Device> devices;

  //@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  //private Set<Vod> vods;

  public Integer getIdOrganization() {
    return idOrganization;
  }

  public void setIdOrganization(Integer idOrganization) {
    this.idOrganization = idOrganization;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<User> getUsers() {
    return users;
  }

  public void setUsers(Set<User> users) {
    this.users = users;
  }

  public Set<Package> getPackages() {
    return packages;
  }

  public void setPackages(Set<Package> packages) {
    this.packages = packages;
  }

  public Set<Device> getDevices() {
    return devices;
  }

  public void setDevices(Set<Device> devices) {
    this.devices = devices;
  }

}