package demo.Rest;

import demo.Service.VehicleService;
import demo.domain.Vehicle;
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



    @RequestMapping(value = "/vehicle", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void uploadvehicles(@RequestBody List<Vehicle> vehicles){
        this.vehicleService.saveVehicles(vehicles);
    }



    @RequestMapping(value = "/purge/vehicle", method = RequestMethod.POST)
    public void purgevehicles(){
        this.vehicleService.deleteAll();
    }

    @RequestMapping(value = "/vehicle/{license}", method = RequestMethod.GET)
    public List<Vehicle> findByLicense(@PathVariable String license){
        return this.vehicleService.findByLicense(license);
    }

    @RequestMapping(value = "/vehicle/{isEmpty}", method = RequestMethod.GET)
    public List<Vehicle> findByIsEmpty(@PathVariable String isEmpty){
        return this.vehicleService.findByIsEmpty(Boolean.parseBoolean(isEmpty));
    }

    @RequestMapping(value = "/vehicle/{forwardPoint}", method = RequestMethod.GET)
    public List<Vehicle> findByForwardPoint(@PathVariable String forwardPoint){
        return this.vehicleService.findByLocationForwardPoint(Integer.parseInt(forwardPoint));
    }

    @RequestMapping(value = "/vehicle/{backwardPoint}", method = RequestMethod.GET)
    public List<Vehicle> findByBackwardPoint(@PathVariable String backwardPoint){
        return this.vehicleService.findByLocationBackwardPoint(Integer.parseInt(backwardPoint));
    }

}
