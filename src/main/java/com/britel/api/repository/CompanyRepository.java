package com.britel.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.britel.api.model.User;
/**
 *
 * @author Jhonny Vargas.
 */

public interface CompanyRepository extends JpaRepository<User, Integer> {

}
