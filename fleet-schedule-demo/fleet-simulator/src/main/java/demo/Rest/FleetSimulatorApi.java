package demo.Rest;

import demo.Service.FleetSimulateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FleetSimulatorApi {
    private FleetSimulateService fleetSimulateService;

    @Autowired
    public FleetSimulatorApi(FleetSimulateService fleetSimulateService){
        this.fleetSimulateService = fleetSimulateService;
    }

    //车队状态初始化
    @RequestMapping(value = "/initial", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void initialFleet(){
        this.fleetSimulateService.initialFleet();
    }

    //依给定路线和车辆开始模拟
    @RequestMapping(value = "/simulate", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public List<ScheduleCommand> fleetSimulator(@RequestBody List<ScheduleCommand> scheduleCommands){
        ScheduleCommand scheduleCommand = scheduleCommands.get(1);
        Long vid = scheduleCommand.getVid();
        List<Integer> path = scheduleCommand.getPath();
        double distance = scheduleCommand.getDistance();
        this.fleetSimulateService.fleetSimulator(vid, path, distance);
        return scheduleCommands;
    }
}
