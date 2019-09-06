package com.britel.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.britel.api.model.Device;
import com.britel.api.repository.DeviceRepository;
import com.britel.api.service.DeviceService;

/**
 *
 * @author Jhonny Vargas.
 */

@Service
public class DeviceServiceImpl implements DeviceService {

  @Autowired
  private DeviceRepository deviceRepository;

  @Override
  public List<Device> findAllDevices() {
    return deviceRepository.findAll();
  }

  @Override
  public Optional<Device> findByUdid(String udid) {
    return deviceRepository.findByUdid(udid);
  }

  @Override
  public List<Device> findByIdCompany(Integer idCompany) {
    return deviceRepository.findByIdCompany(idCompany);
  }

  @Override
  public void deleteDeviceByUdid(String udid) {
    deviceRepository.deleteById(udid);

  }

  @Override
  public Boolean exists(String udid) {
    return findByUdid(udid).isPresent();
  }

  @Override
  public void save(Device device) {
    deviceRepository.save(device);
  }

  @Override
  public void update(Device device) {
    deviceRepository.save(device);
  }

}
