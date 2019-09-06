package com.britel.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.britel.api.model.Pin;

/**
 *
 * @author Jhonny Vargas.
 */

public interface PinRepository extends JpaRepository<Pin, Integer> {

}
