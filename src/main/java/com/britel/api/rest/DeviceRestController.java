package com.britel.api.rest;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.britel.api.model.Device;
import com.britel.api.model.Organization;
import com.britel.api.model.User;
import com.britel.api.model.dto.DeviceDTO;
import com.britel.api.service.DeviceService;
import com.britel.api.service.OrganizationService;
import com.britel.api.service.UserService;

/**
 * @author Jhonny Vargas.
 */

@RestController
public class DeviceRestController {

  @Autowired
  private DeviceService deviceService;
  @Autowired
  private OrganizationService organizationService;
  @Autowired
  private UserService userService;

  @Autowired
  private HttpServletRequest request;

  @RequestMapping(value = "/devices/{idCompany}", method = RequestMethod.GET)
  public ResponseEntity<List<Device>> listAllDevicesOfCompany(@PathVariable("idCompany") Integer idCompany) {
    if ((int) request.getSession().getAttribute("currentUserId") != idCompany) // Only the current session user can access to their Devices.
      return new ResponseEntity<List<Device>>(HttpStatus.NOT_FOUND);

    List<Device> devices = deviceService.findByIdCompany(idCompany);

    if (devices.isEmpty())
      return new ResponseEntity<List<Device>>(HttpStatus.NO_CONTENT);

    return new ResponseEntity<List<Device>>(devices, HttpStatus.OK);
  }

  @RequestMapping(value = "/devices/", method = RequestMethod.POST)
  public ResponseEntity<Void> createDevice(@RequestBody DeviceDTO deviceDTO, UriComponentsBuilder ucBuilder) {
    // FIXME: Comprobar que existe el Device antes de actualizar. Aunque ya se comprueba en la vista, es muy recomendable comprobarlo aquí tambien.

    System.out.println("Creating Device " + deviceDTO.getUdid());

    Device device = new Device();

    device.setActive(deviceDTO.getActive());

    if (device.getActive()) {
      device.setActiveDate(new Timestamp(System.currentTimeMillis()));
    } else {
      device.setActiveDate(null);
    }

    device.setTest(deviceDTO.getTest());
    device.setCompany((User) userService.findByIdUser(deviceDTO.getCompany()).get());
    device.setCreationDate(new Timestamp(System.currentTimeMillis()));
    device.setDesactivationDate(null);
    device.setDescription(deviceDTO.getDescription());
    device.setLastAccessDate(null);
    device.setUdid(deviceDTO.getUdid());

    deviceService.save(device);

    int currentUserId = (int) request.getSession().getAttribute("currentUserId");

    Organization organization = null;

    organization = organizationService.findById(14925).get(); // 14925 by default for all Companies
    organization.getDevices().add(device);
    organizationService.save(organization);

    if (currentUserId == 76) { // COMUNICACIONES ENERSOL
      organization = organizationService.findById(14926).get();
    } else if (currentUserId == 186) { // NETCAN
      organization = organizationService.findById(14927).get();
    } else if (currentUserId == 120) { // Alcarria
      organization = organizationService.findById(14928).get();
    } else if (currentUserId == 150) {
      organization = organizationService.findById(14929).get();
    } else if (currentUserId == 336) {
      organization = organizationService.findById(14930).get();
    }

    organization.getDevices().add(device);
    organizationService.save(organization);

    HttpHeaders headers = new HttpHeaders();
    headers.setLocation(ucBuilder.path("/devices/{udid}").buildAndExpand(device.getUdid()).toUri());

    return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
  }

  @RequestMapping(value = "/devices/{udid}", method = RequestMethod.PUT)
  public ResponseEntity<Device> updateDevice(@PathVariable("udid") String udid, @RequestBody Device device) {
    // FIXME: Comprobar que existe el Device antes de actualizar. Aunque ya se comprueba en la vista, es muy recomendable comprobarlo aquí tambien.

    System.out.println("Updating device " + udid);

    boolean isAlreadyActive = deviceService.findByUdid(udid).get().getActive();

    Device updatedDevice = new Device();

    updatedDevice.setUdid(device.getUdid());
    updatedDevice.setCompany(device.getCompany());
    updatedDevice.setActive(device.getActive());

    updatedDevice.setCreationDate(device.getCreationDate());

    if (!isAlreadyActive && device.getActive()) {
      updatedDevice.setActiveDate(new Timestamp(System.currentTimeMillis()));
      updatedDevice.setDesactivationDate(device.getDesactivationDate());
    } else if (isAlreadyActive && !device.getActive()) {
      updatedDevice.setActiveDate(device.getActiveDate());
      updatedDevice.setDesactivationDate(new Timestamp(System.currentTimeMillis()));
    } else {
      updatedDevice.setActiveDate(device.getActiveDate());
      updatedDevice.setDesactivationDate(device.getDesactivationDate());
    }

    updatedDevice.setTest(device.getTest());
    updatedDevice.setDescription(device.getDescription());

    deviceService.update(updatedDevice);
    return new ResponseEntity<Device>(updatedDevice, HttpStatus.OK);
  }

  @RequestMapping(value = "/devices/{udid}", method = RequestMethod.DELETE)
  public ResponseEntity<Device> deleteDevice(@PathVariable("udid") String udid) { 
    if (!deviceService.exists(udid))
      return new ResponseEntity<Device>(HttpStatus.NOT_FOUND);

    deviceService.deleteDeviceByUdid(udid);

    return new ResponseEntity<Device>(HttpStatus.OK);
  }

  @RequestMapping(value = "/devices/exists/{udid}", method = RequestMethod.GET)
  public ResponseEntity<Boolean> exists(@PathVariable("udid") String udid) {
    boolean exists = deviceService.exists(udid);

    if (exists) {
      return new ResponseEntity<Boolean>(exists, HttpStatus.OK);
    } else {
      return new ResponseEntity<Boolean>(exists, HttpStatus.NOT_FOUND);
    }
  }

}