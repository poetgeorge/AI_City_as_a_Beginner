package demo.Service;



import demo.domain.Road;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RoadService {

    List<Road> saveRoads(List<Road> roads);
    void deleteAll();
    Page<Road> findByBeginPoint(int beginPoint, Pageable pageable);
    Page<Road> findByEndPoint(int endPoint, Pageable pageable);
    Page<Road> findByBeginPointAndEndPoint(int beginPoint, int endPoint, Pageable pageable);

}
