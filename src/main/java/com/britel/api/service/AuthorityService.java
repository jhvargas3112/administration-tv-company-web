package com.britel.api.service;

import java.util.Optional;

import com.britel.api.model.Authority;

/**
 *
 * @author Jhonny Vargas.
 */

public interface AuthorityService {

  public Optional<Authority> findByEmail(String email);

}
