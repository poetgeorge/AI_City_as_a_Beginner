package demo.Rest;

import demo.Service.VehicleService;
import demo.domain.VehicleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DataCacheApi {

    private VehicleService vehicleService;

    @Autowired
    public DataCacheApi(VehicleService vehicleService){
        this.vehicleService = vehicleService;
    }

    //增加（含更新）车辆状态
    @RequestMapping(value = "/vehiclest", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void uploadvehicles(@RequestBody List<VehicleState> vehicleStates){
        this.vehicleService.saveVehicles(vehicleStates);
    }

    //删除所有车辆状态
    @RequestMapping(value = "/purge/vehiclest", method = RequestMethod.POST)
    public void purgevehicles(){
        this.vehicleService.deleteAll();
    }

    //查询所有车辆状态
    @RequestMapping(value = "/vehiclestfind", method = RequestMethod.GET)
    public List<VehicleState> findAllVehicles(){
        return this.vehicleService.findAll();
    }

    //按车牌号查询车辆状态
    @RequestMapping(value = "/vehiclestl/{license}", method = RequestMethod.GET)
    public List<VehicleState> findByLicense(@PathVariable String license){
        return this.vehicleService.findByLicense(license);
    }

    //按是否空闲查询车辆状态
    @RequestMapping(value = "/vehicleste/{isEmpty}", method = RequestMethod.GET)
    public List<VehicleState> findByIsEmpty(@PathVariable String isEmpty){
        return this.vehicleService.findByIsEmpty(Boolean.parseBoolean(isEmpty));
    }

    //按车辆前方地点查询车辆状态
    @RequestMapping(value = "/vehiclestf/{forwardPoint}", method = RequestMethod.GET)
    public List<VehicleState> findByForwardPoint(@PathVariable String forwardPoint){
        return this.vehicleService.findByLocationForwardPoint(Long.parseLong(forwardPoint));
    }

    //按车辆后方地点查询车辆状态
    @RequestMapping(value = "/vehiclestb/{backwardPoint}", method = RequestMethod.GET)
    public List<VehicleState> findByBackwardPoint(@PathVariable String backwardPoint){
        return this.vehicleService.findByLocationBackwardPoint(Long.parseLong(backwardPoint));
    }

}
