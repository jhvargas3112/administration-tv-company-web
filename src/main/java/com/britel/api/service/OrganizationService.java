package com.britel.api.service;

import java.util.List;
import java.util.Optional;

import com.britel.api.model.Organization;

public interface OrganizationService {
  
  public Optional<Organization> findById(Integer id);
  public List<Organization> findAllOrganizations();
  public void save(Organization organization);

}
