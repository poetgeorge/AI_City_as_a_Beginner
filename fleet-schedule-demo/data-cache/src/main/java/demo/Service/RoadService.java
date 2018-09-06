package demo.Service;



import demo.domain.Road;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RoadService {

    List<Road> saveRoads(List<Road> roads);
    void deleteAll();
    List<Road> findAll();
    Page<Road> findByBeginPoint(Integer beginPoint, Pageable pageable);
    Page<Road> findByEndPoint(Integer endPoint, Pageable pageable);
    Page<Road> findByBeginPointAndEndPoint(Integer beginPoint, Integer endPoint, Pageable pageable);

}
