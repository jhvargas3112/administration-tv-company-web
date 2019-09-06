package com.britel.api.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.britel.api.model.Authority;
import com.britel.api.repository.AuthorityRepository;
import com.britel.api.service.AuthorityService;

/**
 *
 * @author Jhonny Vargas.
 */

@Service
public class AuthoritiesServiceImpl implements AuthorityService {

  @Autowired
  private AuthorityRepository authoritiesRepository;

  @Override
  public Optional<Authority> findByEmail(String email) {
    return authoritiesRepository.findByEmail(email);
  }

}
