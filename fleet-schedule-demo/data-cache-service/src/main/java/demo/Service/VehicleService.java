package demo.Service;

import demo.domain.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface VehicleService {

    List<Vehicle> saveVehicles(List<Vehicle> vehicles);
    void deleteAll();
    //Page<Vehicle> findByVid(Long vid, Pageable pageable);
    List<Vehicle> findByLicense(String license);
    List<Vehicle> findByIsEmpty(boolean isEmpty);
    List<Vehicle> findByLocationForwardPoint(int forwardPoint);
    List<Vehicle> findByLocationBackwardPoint(int backwardPoint);

}
