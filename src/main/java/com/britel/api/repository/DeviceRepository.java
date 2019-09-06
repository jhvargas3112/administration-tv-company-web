package com.britel.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.britel.api.model.Device;

/**
 * @author Jhonny Vargas.
 */

public interface DeviceRepository extends JpaRepository<Device, String> {
  Optional<Device> findByUdid(String udid);

  @Query(value = "SELECT Udid, Company, Active, ActiveDate, CreationDate, Test, DesactivationDate, LastAccessDate, Description FROM device WHERE Company = ?1", nativeQuery=true)
  List<Device> findByIdCompany(Integer idCompany);

}