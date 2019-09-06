package com.britel.api.service;

import java.util.List;
import java.util.Optional;

import com.britel.api.model.Device;

/**
 *
 * @author Jhonny Vargas.
 */

public interface DeviceService {
  
  public List<Device> findAllDevices();
  public Optional<Device> findByUdid(String udid);
  public List<Device> findByIdCompany(Integer idCompany);
  public void deleteDeviceByUdid(String udid);
  public Boolean exists(String udid);
  public void save(Device device);
  public void update(Device device);
  
}
