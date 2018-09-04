package demo.Service;

import demo.domain.Vehicle;

import java.util.List;

public interface VehicleService {

    List<Vehicle> saveVehicles(List<Vehicle> vehicles);
    void deleteAll();
    List<Vehicle> findAll();
    List<Vehicle> findByLicense(String license);
    List<Vehicle> findByIsEmpty(boolean isEmpty);
    List<Vehicle> findByLocationForwardPoint(Long forwardPoint);
    List<Vehicle> findByLocationBackwardPoint(Long backwardPoint);

}
