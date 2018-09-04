package demo.Service.impl;

import demo.Service.PointService;
import demo.domain.Point;
import demo.domain.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointServiceImpl implements PointService {

    private PointRepository pointRepository;

    @Autowired
    public PointServiceImpl(PointRepository pointRepository){
        this.pointRepository = pointRepository;
    }

    @Override
    public List<Point> savePoints(List<Point> points) {
        return this.pointRepository.save(points);
    }

    @Override
    public void deleteAll() {
        this.pointRepository.deleteAll();
    }

    @Override
    public List<Point> findAll() {
        return this.pointRepository.findAll();
    }

    @Override
    public Page<Point> findByPName(String pName, Pageable pageable) {
        return this.pointRepository.findByPName(pName, pageable);
    }
}
