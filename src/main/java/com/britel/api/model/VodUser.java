package com.britel.api.model;

import javax.persistence.DiscriminatorValue;

/**
 * @author Jhonny Vargas.
 */

@SuppressWarnings("serial")
@DiscriminatorValue(value="VOD")
public class VodUser extends User {

}
