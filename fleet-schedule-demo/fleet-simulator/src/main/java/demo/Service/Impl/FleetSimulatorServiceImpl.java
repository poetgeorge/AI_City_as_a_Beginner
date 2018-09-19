package demo.Service.Impl;

import demo.Service.FleetSimulateService;
import demo.domain.Location;
import demo.domain.VehicleState;
import lombok.Data;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@Data
@Service
public class FleetSimulatorServiceImpl implements FleetSimulateService {

    //private RestTemplate restTemplate = new RestTemplate();
    @Value("${data.cache}")
    private String dataCache;

    private Location[] locations = new Location[4];
    private VehicleState[] fleet = new VehicleState[4]; //车队状态

    private final double Max = 10000.0;
    private double[][] map = new double[10][10];  //地图

    public FleetSimulatorServiceImpl(){
    }

    @Override
    public void initialFleet() {
        //初始化车队状态
        this.locations[0] = new Location(0L, 1L, 0L, 5.0);
        this.fleet[0] = new VehicleState(0L, "SH001", true, this.locations[0], 1L);
        this.locations[1] = new Location(1L, 2L, 1L, 1.5);
        this.fleet[1]= new VehicleState(1L, "SH002", true, this.locations[1], 2L);
        this.locations[2] = new Location(6L, 5L, 3L, 6.0);
        this.fleet[2] = new VehicleState(2L, "SH003", true, this.locations[2], 5L);
        this.locations[3] = new Location(9L, 8L, 5L, 10.5);
        this.fleet[3] = new VehicleState(3L, "SH004", true, this.locations[3], 8L);

        //输入地图
        int i,j= 0;
        for(i=0;i<10;i++)
            this.map[i][i] = 0;
        for(i=0;i<10;i++)
            for(j=0;j<10;j++)
                this.map[i][j] = this.Max;
        this.map[0][1] = 10.0;
        this.map[1][2] = 5.0;
        this.map[0][3] = 12.0;
        this.map[1][3] = 5.0;
        this.map[2][4] = 8.5;
        this.map[3][5] = 13.0;
        this.map[3][8] = 14.5;
        this.map[4][8] = 10.0;
        this.map[5][6] = 7.5;
        this.map[5][8] = 21.0;
        this.map[6][7] = 5.0;
        this.map[7][9] = 8.0;
        for(i=0;i<10;i++)
            for(j=0;j<i;j++)
                this.map[i][j] = this.map[j][i];
    }

    @Override
    public void fleetSimulator(Long vid, List<Integer> path, double distance) {
        int id = Math.toIntExact(vid);
        double time = Math.ceil(distance);
        this.fleet[id].setEmpty(false);  //将车辆设为忙碌
        int l = path.size()-1;
        Long[] myPath = path.toArray(new Long[l]);
        this.fleet[id].setDestination(myPath[l]); //设定目的地
        if(this.locations[id].getForwardPoint()!=myPath[0]){
            this.locations[id].setBackwardPoint(this.locations[id].getForwardPoint());
            this.locations[id].setForwardPoint(myPath[0]);
        } //使车辆转到路径指定方向
        VehicleState fleetNow =this.fleet[id];
        double[][] mapNow = this.map;
        //车辆状态实时改变并上传
        Timer timer = new Timer(true);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(fleetNow.getLocation().getForwardDistance()==0&&fleetNow.getLocation().getForwardPoint()==myPath[l]){
                    this.cancel();
                }
                Location location = fleetNow.getLocation();
                if (fleetNow.getLocation().getForwardDistance()==0){
                    Integer index = path.get(path.indexOf(fleetNow.getLocation().getForwardPoint()));
                    location.setBackwardPoint(location.getForwardPoint());
                    location.setForwardPoint(index.longValue());
                    location.setForwardDistance(mapNow[Math.toIntExact(location.getForwardPoint())][Math.toIntExact(location.getBackwardPoint())]);
                    fleetNow.setLocation(location);
                }
                location.setForwardDistance(location.getForwardDistance() - 1);
                fleetNow.setLocation(location);
                HttpClient httpClient = HttpClientBuilder.create().build();
                ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
                RestTemplate restTemplate = new RestTemplate(requestFactory);
                restTemplate.postForEntity(dataCache +"/vehiclest", fleetNow, VehicleState.class);
            }
        }, 0, 1*60*1000);
        timer.cancel();
        this.fleet[id] = fleetNow;
        this.fleet[id].setEmpty(true);
    }

}
