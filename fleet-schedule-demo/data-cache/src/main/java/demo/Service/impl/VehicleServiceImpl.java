package demo.Service.impl;

import demo.Service.VehicleService;
import demo.domain.Vehicle;
import demo.domain.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public List<Vehicle> saveVehicles(List<Vehicle> vehicles) {
        return vehicleRepository.save(vehicles);
    }

    @Override
    public void deleteAll() {
        this.vehicleRepository.deleteAll();
    }

    /*@Override
    public Page<Vehicle> findByVid(Long vid, ) {
        return this.vehicleRepository.findOne(vid);
    }*/

    @Override
    public Page<Vehicle> findByLicense(String license, Pageable pageable) {
        return this.vehicleRepository.findByLicense(license, pageable);
    }

    @Override
    public Page<Vehicle> findByIsEmpty(boolean isEmpty, Pageable pageable) {
        return this.vehicleRepository.findByIsEmpty(isEmpty, pageable);
    }

    @Override
    public Page<Vehicle> findByLocationForwardPoint(int forwardPoint, Pageable pageable) {
        return this.vehicleRepository.findByLocationForwardPoint(forwardPoint, pageable);
    }

    @Override
    public Page<Vehicle> findByLocationBackwardPoint(int backwardPoint, Pageable pageable) {
        return this.vehicleRepository.findByLocationBackwardPoint(backwardPoint, pageable);
    }
}
