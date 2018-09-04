package demo.Service;

import demo.domain.Point;
import demo.domain.Road;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PointService {
    List<Point> savePoints(List<Point> points);
    void deleteAll();
    Page<Point> findByPName(String pName, Pageable pageable);
}
