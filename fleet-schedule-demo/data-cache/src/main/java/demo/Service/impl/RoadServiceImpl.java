package demo.Service.impl;

import demo.Service.RoadService;
import demo.domain.Road;
import demo.domain.RoadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoadServiceImpl implements RoadService {

    private RoadRepository roadRepository;

    @Autowired
    public RoadServiceImpl(RoadRepository roadRepository){
        this.roadRepository = roadRepository;
    }

    @Override
    public List<Road> saveRoads(List<Road> roads) {
        return roadRepository.save(roads);
    }

    @Override
    public void deleteAll() {
        this.roadRepository.deleteAll();
    }

    @Override
    public Page<Road> findByBeginPoint(int beginPoint, Pageable pageable) {
        return this.roadRepository.findByBeginPoint(beginPoint, pageable);
    }

    @Override
    public Page<Road> findByEndPoint(int endPoint, Pageable pageable) {
        return this.roadRepository.findByEndPoint(endPoint, pageable);
    }

    @Override
    public Page<Road> findByBeginPointAndEndPoint(int beginPoint, int endPoint, Pageable pageable) {
        return this.roadRepository.findByBeginPointAndEndPoint(beginPoint, endPoint, pageable);
    }
}
