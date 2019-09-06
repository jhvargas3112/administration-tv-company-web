package com.britel.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.britel.api.model.Organization;
import com.britel.api.repository.OrganizationRepository;
import com.britel.api.service.OrganizationService;

@Service
public class OrganizationServiceImpl implements OrganizationService {

  @Autowired
  private OrganizationRepository organizationRepository;

  @Override
  public Optional<Organization> findById(Integer id) {
    return organizationRepository.findById(id);
  }

  @Override
  public List<Organization> findAllOrganizations() {
    return organizationRepository.findAll();
  }

  @Override
  public void save(Organization organization) {
    organizationRepository.save(organization);
  }

}
