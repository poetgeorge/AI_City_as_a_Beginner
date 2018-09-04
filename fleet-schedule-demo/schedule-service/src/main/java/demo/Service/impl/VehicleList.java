package demo.Service.impl;

import demo.domain.Vehicle;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class VehicleList {
    private List<Vehicle> vehicles;

    public VehicleList(){
        vehicles = new ArrayList<>();
    }
}
