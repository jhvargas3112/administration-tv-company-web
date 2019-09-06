package com.britel.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.britel.api.model.Organization;

/**
 *
 * @author Jhonny Vargas.
 */

public interface OrganizationRepository extends JpaRepository<Organization, Integer> {

}
