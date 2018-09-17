package demo.Rest;

import demo.Service.VehicleStateService;
import demo.domain.VehicleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DataCacheApi {

    private VehicleStateService vehicleStateService;

    @Autowired
    public DataCacheApi(VehicleStateService vehicleStateService){
        this.vehicleStateService = vehicleStateService;
    }

    //增加（含更新）车辆状态
    @RequestMapping(value = "/vehiclest", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void uploadvehicles(@RequestBody List<VehicleState> vehicleStates){
        this.vehicleStateService.saveVehicles(vehicleStates);
    }

    //删除所有车辆状态
    @RequestMapping(value = "/purge/vehiclest", method = RequestMethod.POST)
    public void purgevehicles(){
        this.vehicleStateService.deleteAll();
    }

    //查询所有车辆状态
    @RequestMapping(value = "/vehiclestfind", method = RequestMethod.GET)
    public List<VehicleState> findAllVehicles(){
        return this.vehicleStateService.findAll();
    }

    //按车牌号查询车辆状态
    @RequestMapping(value = "/vehiclestl/{license}", method = RequestMethod.GET)
    public List<VehicleState> findByLicense(@PathVariable String license){
        return this.vehicleStateService.findByLicense(license);
    }

    //按是否空闲查询车辆状态
    @RequestMapping(value = "/vehicleste/{isEmpty}", method = RequestMethod.GET)
    public List<VehicleState> findByIsEmpty(@PathVariable String isEmpty){
        return this.vehicleStateService.findByIsEmpty(Boolean.parseBoolean(isEmpty));
    }

    //按是否空闲查询车辆状态
    @RequestMapping(value = "/vehicleste/{currentRoad}", method = RequestMethod.GET)
    public List<VehicleState> findByCurrentRoad(@PathVariable String currentRoad){
        return this.vehicleStateService.findByLocationCurrentRoad(Long.parseLong(currentRoad));
    }

    //按车辆前方地点查询车辆状态
    @RequestMapping(value = "/vehiclestf/{forwardPoint}", method = RequestMethod.GET)
    public List<VehicleState> findByForwardPoint(@PathVariable String forwardPoint){
        return this.vehicleStateService.findByLocationForwardPoint(Long.parseLong(forwardPoint));
    }

    //按车辆后方地点查询车辆状态
    @RequestMapping(value = "/vehiclestb/{backwardPoint}", method = RequestMethod.GET)
    public List<VehicleState> findByBackwardPoint(@PathVariable String backwardPoint){
        return this.vehicleStateService.findByLocationBackwardPoint(Long.parseLong(backwardPoint));
    }

    /**
     *按车辆编号删除车辆状态
     */
    @RequestMapping(value = "/vehiclestd/{vId}", method = RequestMethod.POST)
    public void deleteByVid(@PathVariable String vId){
        this.vehicleStateService.deleteByVid(Long.parseLong(vId));
    }

}
