package com.britel.api.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.britel.api.model.User;
import com.britel.api.service.UserService;


@RestController
public class CompanyAccountRestController {

  @Autowired
  private UserService companyAccountService;

  @RequestMapping(value = "/companies", method = RequestMethod.GET)
  public ResponseEntity<List<User>> listAllCompanies() {
    List<User> companyAccounts = companyAccountService.findByType("Company");

    if(companyAccounts.isEmpty())
      return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);

    return new ResponseEntity<List<User>>(companyAccounts, HttpStatus.OK);
  }

}
