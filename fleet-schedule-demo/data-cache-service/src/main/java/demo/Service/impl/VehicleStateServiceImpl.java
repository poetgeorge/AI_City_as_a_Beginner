package demo.Service.impl;

import demo.Service.VehicleStateService;
import demo.domain.VehicleState;
import demo.domain.VehicleStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleStateServiceImpl implements VehicleStateService {

    private VehicleStateRepository vehicleStateRepository;

    @Autowired
    public VehicleStateServiceImpl(VehicleStateRepository vehicleRepository){
        this.vehicleStateRepository = vehicleRepository;
    }

    @Override
    public List<VehicleState> saveVehicles(List<VehicleState> vehicleStates) {
        return vehicleStateRepository.save(vehicleStates);
    }

    @Override
    public void deleteAll() {
        this.vehicleStateRepository.deleteAll();
    }

    /*@Override
    public Page<VehicleState> findByVid(Long vid, ) {
        return this.vehicleStateRepository.findOne(vid);
    }*/

    @Override
    public List<VehicleState> findByLicense(String license) {
        return this.vehicleStateRepository.findByLicense(license);
    }

    @Override
    public List<VehicleState> findByIsEmpty(boolean isEmpty) {
        return this.vehicleStateRepository.findByIsEmpty(isEmpty);
    }

    @Override
    public List<VehicleState> findByLocationForwardPoint(Long forwardPoint) {
        return this.vehicleStateRepository.findByLocationForwardPoint(forwardPoint);
    }

    @Override
    public List<VehicleState> findByLocationBackwardPoint(Long backwardPoint) {
        return this.vehicleStateRepository.findByLocationBackwardPoint(backwardPoint);
    }

    @Override
    public List<VehicleState> findAll() {
        return this.vehicleStateRepository.findAll();
    }
}
