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
    public List<Vehicle> findByLicense(String license) {
        return this.vehicleRepository.findByLicense(license);
    }

    @Override
    public List<Vehicle> findByIsEmpty(boolean isEmpty) {
        return this.vehicleRepository.findByIsEmpty(isEmpty);
    }

    @Override
    public List<Vehicle> findByLocationForwardPoint(int forwardPoint) {
        return this.vehicleRepository.findByLocationForwardPoint(forwardPoint);
    }

    @Override
    public List<Vehicle> findByLocationBackwardPoint(int backwardPoint) {
        return this.vehicleRepository.findByLocationBackwardPoint(backwardPoint);
    }
}
