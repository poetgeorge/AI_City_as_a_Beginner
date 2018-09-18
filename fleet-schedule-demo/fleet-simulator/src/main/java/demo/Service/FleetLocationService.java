package demo.Service;

import java.util.List;

public interface FleetLocationService {
    void getpath(Long vid, List<Integer> path);
    void uploadstate();
}
