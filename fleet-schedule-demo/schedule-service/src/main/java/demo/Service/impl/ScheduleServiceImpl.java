package demo.Service.impl;

import demo.Service.ScheduleService;
import demo.domain.BehaviorRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    private BehaviorRepository behaviorRepository;

    private RestTemplate restTemplate = new RestTemplate();

    @Value("${data.cache}")
    private String dataCache;

    @Value("${basic.data}")
    private String basicData;

    public ScheduleServiceImpl(BehaviorRepository behaviorRepository){
        this.behaviorRepository = behaviorRepository;
    }

    @Override
    public String schedule(int startPoint, int endPoint) {
        
        return null;
    }
}
