package demo.Service;

import java.util.List;

public interface FleetSimulateService {
    public void initialFleet();
    public void fleetSimulator(Long vid, List<Integer> path, double distance);
}
