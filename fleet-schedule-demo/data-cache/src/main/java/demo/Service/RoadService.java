package demo.Service;



import demo.domain.Road;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RoadService {

    List<Road> saveRoads(List<Road> roads);
    void deleteAll();
    List<Road> findAll();
    Page<Road> findByBeginPoint(Long beginPoint, Pageable pageable);
    Page<Road> findByEndPoint(Long endPoint, Pageable pageable);
    Page<Road> findByBeginPointAndEndPoint(Long beginPoint, Long endPoint, Pageable pageable);

}
