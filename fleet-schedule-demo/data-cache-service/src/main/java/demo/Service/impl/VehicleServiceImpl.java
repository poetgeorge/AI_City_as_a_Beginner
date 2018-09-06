package demo.Service.impl;

import demo.Service.VehicleService;
import demo.domain.VehicleState;
import demo.domain.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    private VehicleRepository vehicleRepository;

    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<VehicleState> saveVehicles(List<VehicleState> vehicleStates) {
        return vehicleRepository.save(vehicleStates);
    }

    @Override
    public void deleteAll() {
        this.vehicleRepository.deleteAll();
    }

    /*@Override
    public Page<VehicleState> findByVid(Long vid, ) {
        return this.vehicleRepository.findOne(vid);
    }*/

    @Override
    public List<VehicleState> findByLicense(String license) {
        return this.vehicleRepository.findByLicense(license);
    }

    @Override
    public List<VehicleState> findByIsEmpty(boolean isEmpty) {
        return this.vehicleRepository.findByIsEmpty(isEmpty);
    }

    @Override
    public List<VehicleState> findByLocationForwardPoint(Long forwardPoint) {
        return this.vehicleRepository.findByLocationForwardPoint(forwardPoint);
    }

    @Override
    public List<VehicleState> findByLocationBackwardPoint(Long backwardPoint) {
        return this.vehicleRepository.findByLocationBackwardPoint(backwardPoint);
    }

    @Override
    public List<VehicleState> findAll() {
        return this.vehicleRepository.findAll();
    }
}
