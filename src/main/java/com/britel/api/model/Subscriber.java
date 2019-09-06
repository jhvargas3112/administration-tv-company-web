package com.britel.api.model;

import javax.persistence.DiscriminatorValue;

/**
 * @author Jhonny Vargas.
 */

@SuppressWarnings("serial")
@DiscriminatorValue(value="SUBSCRIBER")
public class Subscriber extends User {
  
}
