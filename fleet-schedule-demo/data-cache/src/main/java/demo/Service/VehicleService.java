package demo.Service;

import demo.domain.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface VehicleService {

    List<Vehicle> saveVehicles(List<Vehicle> vehicles);
    void deleteAll();
    List<Vehicle> findAll();
    Page<Vehicle> findByLicense(String license, Pageable pageable);
//    Page<Vehicle> findByIsEmpty(boolean isEmpty, Pageable pageable);
//    Page<Vehicle> findByLocationForwardPoint(Long forwardPoint, Pageable pageable);
//    Page<Vehicle> findByLocationBackwardPoint(Long backwardPoint, Pageable pageable);

}
