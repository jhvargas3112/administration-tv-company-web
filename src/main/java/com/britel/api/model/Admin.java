package com.britel.api.model;

import javax.persistence.DiscriminatorValue;

/**
 * @author Jhonny Vargas.
 */

@SuppressWarnings("serial")
@DiscriminatorValue(value="ADMIN")
public class Admin extends User {

}
