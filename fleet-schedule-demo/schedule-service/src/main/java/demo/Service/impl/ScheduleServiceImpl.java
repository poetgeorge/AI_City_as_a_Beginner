package demo.Service.impl;

import demo.Service.ScheduleService;
import demo.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Service
public class ScheduleServiceImpl implements ScheduleService {

    private Graph graph;

    private BehaviorRepository behaviorRepository;

    private RestTemplate restTemplate = new RestTemplate();

    @Value("${data.cache}")
    private String dataCache;

    @Value("${basic.data}")
    private String basicData;


    @Autowired
    public ScheduleServiceImpl(BehaviorRepository behaviorRepository){

        RoadList rres = this.restTemplate.getForObject(basicData + "/roadfind", RoadList.class);
        List<Road> myroads = rres.getRoads();
        PointList pres = this.restTemplate.getForObject(basicData + "/pointfind", PointList.class);
        List<Point> mypoints = pres.getPoints();
        final int rsize = myroads.size();
        Road[] roads = (Road[])myroads.toArray(new Road[rsize]);
        final int psize = mypoints.size();
        Point[] points = (Point[])mypoints.toArray((new Point[psize]));

        Graph graph = new Graph(roads, points);
        this.behaviorRepository = behaviorRepository;
    }

    //调度方法，返回车牌号，向车辆发送命令，记录车辆行为
    @Override
    public String schedule(int startPoint, int endPoint) {
        String license = null; //车牌号
        Long vid = 1L;  //车辆ID
        double distance = 0.0;  //车辆总行驶距离
        List<Long> path = new ArrayList<>();  //车辆路径
        List<Long> path2 = new ArrayList<>();

        VehicleList vres = this.restTemplate.getForObject(dataCache + "/vehiclefind", VehicleList.class);
        List<Vehicle> myvehicles = vres.getVehicles();
        final int vsize = myvehicles.size();
        Vehicle[] vehicles = (Vehicle[])myvehicles.toArray(new Vehicle[vsize]);

        Graph g = this.graph;
        g.dijsktraall();

        distance = g.getAlldist()[startPoint][endPoint];

        double vd = Double.MAX_VALUE;

        int i;
        int vsp=0;

        for(i=0;i<vehicles.length;i++){
           Long p = vehicles[i].getLocation().getForwardPoint();
           if(g.getAlldist()[Math.toIntExact(p)][startPoint]<vd){
               vd = g.getAlldist()[Math.toIntExact(p)][startPoint];
               license = vehicles[i].getLicense();
               vid = vehicles[i].getVid();
               vsp = Math.toIntExact(p);
           }
        }
        distance = distance + vd;

        for(i=startPoint;i!= vsp;i=g.getAllpath()[vsp][i])
            path.add(Long.valueOf(g.getAllpath()[vsp][i]));
        Collections.reverse(path);



        for(i=endPoint;i!=startPoint;i=g.getAllpath()[startPoint][i])
            path2.add(Long.valueOf(g.getAllpath()[startPoint][i]));
        Collections.reverse(path2);

        path.addAll(path2);

        /*
        向车辆发送命令部分未完成
         */

        VehicleBehavior vehicleBehavior = new VehicleBehavior();
        vehicleBehavior.setVid(Math.toIntExact(vid));
        vehicleBehavior.setStartPoint(vsp);
        vehicleBehavior.setEndPoint(endPoint);
        vehicleBehavior.setMileage(distance);
        List<VehicleBehavior> thebehavior = new ArrayList<>();
        thebehavior.add(vehicleBehavior);

        this.behaviorRepository.save(thebehavior);

        return license;
    }
}
