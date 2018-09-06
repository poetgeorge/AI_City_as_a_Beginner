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

    @RequestMapping(value = "/schedule", params = {"startPoint", "endPoint"}, method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String schedulerequest(@RequestParam int startPoint, @RequestParam int endPoint){
        return this.scheduleService.schedule(startPoint, endPoint);
    }
}
