package com.britel.api.service;

import java.util.List;
import java.util.Optional;

import com.britel.api.model.User;

/**
 * @author Jhonny Vargas.
 */

public interface UserService {

  public Optional<User> findByIdUser(Integer idUser);
  public Optional<User> findByEmail(String Email);
  public List<User> findByType(String type);
  public List<User> findByTypeAndIdCompany(String type, Integer idCompany);
  public Boolean exists(String email);
  public void save(User subscriberAccount);
  public void update(User subscriberAccount);

}