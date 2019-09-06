package com.britel.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.britel.api.model.App;

/**
 *
 * @author Jhonny Vargas.
 */

public interface AppRepository extends JpaRepository<App, Integer> {

}
