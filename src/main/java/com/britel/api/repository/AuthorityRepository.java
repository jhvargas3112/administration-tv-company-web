package com.britel.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.britel.api.model.Authority;

/**
 *
 * @author Jhonny Vargas.
 */

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {

  Optional<Authority> findByEmail(String email);

}
