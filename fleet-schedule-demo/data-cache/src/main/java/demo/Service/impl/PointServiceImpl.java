package demo.Service.impl;

import demo.Service.PointService;
import demo.domain.myPoint;
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
    public List<myPoint> savePoints(List<myPoint> myPoints) {
        return this.pointRepository.save(myPoints);
    }

    @Override
    public void deleteAll() {
        this.pointRepository.deleteAll();
    }

    @Override
    public List<myPoint> findAll() {
        return this.pointRepository.findAll();
    }

    @Override
    public Page<myPoint> findByPName(String pName, Pageable pageable) {
        return this.pointRepository.findByPName(pName, pageable);
    }

    @Override
    public void deleteByPid(Long pid) {
        this.pointRepository.deleteByPid(pid);
    }
}
