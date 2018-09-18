package demo.Service.Impl;

import demo.Service.FleetLocationService;
import demo.domain.Graph;
import demo.domain.Location;
import demo.domain.VehicleState;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FleetLocationImpl implements FleetLocationService {

    private RestTemplate restTemplate = new RestTemplate();

    Location locaiton0 = new Location(0L, 1L, 0L, 5.0);
    VehicleState vehicle0 = new VehicleState(0L, "SH001", true, locaiton0, 1L);
    Location locaiton1 = new Location(1L, 2L, 1L, 1.5);
    VehicleState vehicle1 = new VehicleState(1L, "SH002", true, locaiton1, 2L);
    Location locaiton2 = new Location(6L, 5L, 3L, 6.0);
    VehicleState vehicle2 = new VehicleState(2L, "SH003", true, locaiton2, 5L);
    Location locaiton3 = new Location(9L, 8L, 5L, 10.5);
    VehicleState vehicle3 = new VehicleState(3L, "SH004", true, locaiton3, 8L);
    VehicleState[] fleet = {vehicle0, vehicle1, vehicle2, vehicle3};

    Graph graph;

    public FleetLocationImpl(){

    }

    @Override
    public void getpath(Long vid, List<Integer> path) {
        int myvid = Math.toIntExact(vid);
        this.fleet[myvid].setEmpty(false);

    }

    @Override
    public void uploadstate() {

    }
}
