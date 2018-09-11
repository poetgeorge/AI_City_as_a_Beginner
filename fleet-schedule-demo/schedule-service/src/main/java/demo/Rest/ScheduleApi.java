package demo.Rest;

import demo.Service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class ScheduleApi {
    private ScheduleService scheduleService;

    @Autowired
    public ScheduleApi(ScheduleService scheduleService){
        this.scheduleService = scheduleService;
    }

    //车辆调度接口，返回车牌号
    @RequestMapping(value = "/schedule", params = {"startPoint", "endPoint"}, method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String scheduleRequest(@RequestParam int startPoint, @RequestParam int endPoint){
        return this.scheduleService.schedule(startPoint, endPoint);
    }
}
