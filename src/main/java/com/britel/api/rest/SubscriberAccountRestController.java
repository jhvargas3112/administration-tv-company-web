package com.britel.api.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.britel.api.model.Organization;
import com.britel.api.model.User;
import com.britel.api.service.OrganizationService;
import com.britel.api.service.UserService;

@RestController
public class SubscriberAccountRestController {

  @Autowired
  private UserService subscriberAccountService;
  @Autowired
  private OrganizationService organizationService;

  @Autowired
  private HttpServletRequest request;

  @RequestMapping(value = "/accounts/{idCompany}", method = RequestMethod.GET)
  public ResponseEntity<List<User>> listAllSubscribers(@PathVariable("idCompany") Integer idCompany) {

    if ((int) request.getSession().getAttribute("currentUserId") != idCompany) // Only the current session user can access to their user accounts.
      return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);

    List<User> subscriberAccounts = subscriberAccountService.findByTypeAndIdCompany("Subscriber", idCompany);

    if (subscriberAccounts.isEmpty())
      return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);

    return new ResponseEntity<List<User>>(subscriberAccounts, HttpStatus.OK);
  }

  @RequestMapping(value = "/accounts/", method = RequestMethod.POST)
  public ResponseEntity<Void> createSubscriberAccount(@RequestBody User subscriberAccount, UriComponentsBuilder ucBuilder) {

    subscriberAccount.setType("Subscriber");
    subscriberAccount.setIdCompany((int) request.getSession().getAttribute("currentUserId"));
    subscriberAccount.setActive(true);
    subscriberAccount.setTest(false);

    if (subscriberAccountService.exists(subscriberAccount.getEmail())) {
      return new ResponseEntity<Void>(HttpStatus.PRECONDITION_FAILED);
    } else {
      System.out.println("Creating Subscriber Account " + subscriberAccount.getEmail());

      subscriberAccountService.save(subscriberAccount);

      Organization organization;

      organization = organizationService.findById(14925).get(); // 14925 by default for all Companies
      organization.getUsers().add(subscriberAccount);
      organizationService.save(organization);

      return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
  }

  @RequestMapping(value = "/accounts/{email}", method = RequestMethod.PUT)
  public ResponseEntity<User> updateSubscriberAccount(@PathVariable("email") String email, @RequestBody User updatedSubscriberAccount) {
    if (StringUtils.isEmpty(updatedSubscriberAccount.getSubscriberType())) {
      updatedSubscriberAccount.setSubscriberType("MOVIL");
    }
    
    subscriberAccountService.update(updatedSubscriberAccount);

    return new ResponseEntity<User>(updatedSubscriberAccount, HttpStatus.OK);
  }

  @RequestMapping(value = "/accounts/exists/{email}", method = RequestMethod.GET)
  public ResponseEntity<Boolean> exists(@PathVariable("email") String udid) {
    boolean exists = subscriberAccountService.exists(udid);

    if (exists) {
      return new ResponseEntity<Boolean>(exists, HttpStatus.OK);
    } else {
      return new ResponseEntity<Boolean>(exists, HttpStatus.NOT_FOUND);
    }
  }

}
