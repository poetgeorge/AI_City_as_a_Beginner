package demo.Rest;

//调度服务对外接口

import demo.Service.ScheduleService;
import demo.Service.impl.MyResponse;
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

    //车辆调度接口，输入出发地和目的地，返回车牌号
    @RequestMapping(value = "/schedule", params = {"startPoint", "endPoint"}, method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public MyResponse scheduleRequest(@RequestParam int startPoint, @RequestParam int endPoint){
        return this.scheduleService.schedule(startPoint, endPoint);
    }
}
