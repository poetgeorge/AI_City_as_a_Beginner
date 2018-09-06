package demo.Service.impl;

import demo.domain.VehicleState;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class VehicleList {
    private List<VehicleState> vehicleStates;

    public VehicleList(){
        vehicleStates = new ArrayList<>();
    }
}
