package demo.Service;

import demo.domain.myPoint;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PointService {
    List<myPoint> savePoints(List<myPoint> myPoints);
    void deleteAll();
    List<myPoint> findAll();
    Page<myPoint> findByPName(String pName, Pageable pageable);
}
