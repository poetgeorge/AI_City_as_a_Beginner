package demo.Service;


import demo.domain.VehicleState;

import java.util.List;

public interface VehicleStateService {

    List<VehicleState> saveVehicles(List<VehicleState> vehicleStates);
    void deleteAll();
    List<VehicleState> findAll();
    List<VehicleState> findByLicense(String license);
    List<VehicleState> findByIsEmpty(boolean isEmpty);
    List<VehicleState> findByLocationForwardPoint(Long forwardPoint);
    List<VehicleState> findByLocationBackwardPoint(Long backwardPoint);

}
