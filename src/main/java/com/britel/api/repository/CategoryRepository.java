package com.britel.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.britel.api.model.Category;
/**
 *
 * @author Jhonny Vargas.
 */

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
