package com.britel.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.britel.api.model.User;

/**
 *
 * @author Jhonny Vargas.
 */

public interface UserRepository extends JpaRepository<User, Integer> {
  Optional<User> findByEmail(String email);
  List<User> findByType(String type);
  List<User> findByTypeAndIdCompany(String type, Integer idCompany);

}
