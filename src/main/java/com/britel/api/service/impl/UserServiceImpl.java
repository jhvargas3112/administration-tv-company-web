/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.britel.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.britel.api.model.User;
import com.britel.api.repository.UserRepository;
import com.britel.api.service.UserService;

/**
 *
 * @author Jhonny Vargas.
 */

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public Optional<User> findByIdUser(Integer idUser) {
    return userRepository.findById(idUser);
  }

  @Override
  public Optional<User> findByEmail(String email) {
    return userRepository.findByEmail(email);
  }

  @Override
  public List<User> findByType(String type) {
    return userRepository.findByType(type);
  }

  @Override
  public List<User> findByTypeAndIdCompany(String type, Integer idCompany) {
    return userRepository.findByTypeAndIdCompany(type, idCompany);
  }

  @Override
  public void save(User subscriberAccount) {
    userRepository.save(subscriberAccount);

  }

  @Override
  public Boolean exists(String email) {
    return userRepository.findByEmail(email).isPresent();
  }

  @Override
  public void update(User subscriberAccount) {
    userRepository.save(subscriberAccount);
  }

}