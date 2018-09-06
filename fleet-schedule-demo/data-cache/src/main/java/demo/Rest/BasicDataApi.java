package demo.Rest;

import demo.Service.PointService;
import demo.Service.RoadService;
import demo.Service.VehicleService;
import demo.domain.myPoint;
import demo.domain.Road;
import demo.domain.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class BasicDataApi {

    private RoadService roadService;
    private VehicleService vehicleService;
    private PointService pointService;

    @Autowired
    public BasicDataApi(RoadService roadService, VehicleService vehicleService, PointService pointService){
        this.roadService = roadService;
        this.vehicleService = vehicleService;
        this.pointService = pointService;
    }

    @RequestMapping(value = "/mypoint", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void uploadpoints(@RequestBody List<myPoint> myPoints){
        this.pointService.savePoints(myPoints);
    }

    @RequestMapping(value = "/road", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void uploadroads(@RequestBody List<Road> roads){
        this.roadService.saveRoads(roads);
    }

    @RequestMapping(value = "/vehicle", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void uploadvehicles(@RequestBody List<Vehicle> vehicles){
        this.vehicleService.saveVehicles(vehicles);
    }

    @RequestMapping(value = "/roadfind", method = RequestMethod.GET)
    public List<Road> findAllRoads(){
        return this.roadService.findAll();
    }

    @RequestMapping(value = "/pointfind", method = RequestMethod.GET)
    public List<myPoint> findAllPoints(){
        return this.pointService.findAll();
    }

    @RequestMapping(value = "/vehiclefind", method = RequestMethod.GET)
    public List<Vehicle> findAllVehicles(){
        return this.vehicleService.findAll();
    }

    @RequestMapping(value = "/purge/road", method = RequestMethod.POST)
    public void purgeroads(){
        this.roadService.deleteAll();
    }

    @RequestMapping(value = "/purge/vehicle", method = RequestMethod.POST)
    public void purgevehicles(){
        this.vehicleService.deleteAll();
    }

    @RequestMapping(value = "/purge/point", method = RequestMethod.POST)
    public void purgepoints(){
        this.pointService.deleteAll();
    }

    @RequestMapping(value = "/roadb/{beginPoint}", method = RequestMethod.GET)
    public Page<Road> findByBeginPoint(@PathVariable String beginPoint, @RequestParam(name = "page") int page, @RequestParam(name = "size") int size){
        return this.roadService.findByBeginPoint(Integer.parseInt(beginPoint), new PageRequest(page,size));
    }

    @RequestMapping(value = "/roade/{endPoint}", method = RequestMethod.GET)
    public Page<Road> findByEndPoint(@PathVariable String endPoint, @RequestParam(name = "page") int page, @RequestParam(name = "size") int size){
        return this.roadService.findByEndPoint(Integer.parseInt(endPoint), new PageRequest(page,size));
    }

    @RequestMapping(value = "/road2/{beginPoint}/{endPoint}", method = RequestMethod.GET)
    public Page<Road> findByBeginPointAndEndPoint(@PathVariable String beginPoint,@PathVariable String endPoint, @RequestParam(name = "page") int page, @RequestParam(name = "size") int size){
        return this.roadService.findByBeginPointAndEndPoint(Integer.parseInt(beginPoint), Integer.parseInt(endPoint), new PageRequest(page,size));
    }

    @RequestMapping(value = "/pointp/{pName}", method = RequestMethod.GET)
    public Page<myPoint> findByPName(@PathVariable String pName, @RequestParam(name = "page") int page, @RequestParam(name = "size") int size){
        return this.pointService.findByPName(pName, new PageRequest(page,size));
    }

    @RequestMapping(value = "/vehicleli/{license}", method = RequestMethod.GET)
    public Page<Vehicle> findByLicense(@PathVariable String license, @RequestParam(name = "page") int page, @RequestParam(name = "size") int size){
        return this.vehicleService.findByLicense(license, new PageRequest(page,size));
    }

//    @RequestMapping(value = "/vehicle/{isEmpty}", method = RequestMethod.GET)
//    public Page<Vehicle> findByIsEmpty(@PathVariable String isEmpty, @RequestParam(name = "page") int page, @RequestParam(name = "size") int size){
//        return this.vehicleService.findByIsEmpty(Boolean.parseBoolean(isEmpty), new PageRequest(page,size));
//    }
//
//    @RequestMapping(value = "/vehicle/{forwardPoint}", method = RequestMethod.GET)
//    public Page<Vehicle> findByForwardPoint(@PathVariable String forwardPoint,  @RequestParam(name = "page") int page, @RequestParam(name = "size") int size){
//        return this.vehicleService.findByLocationForwardPoint(Long.parseLong(forwardPoint),new PageRequest(page,size));
//    }
//
//    @RequestMapping(value = "/vehicle/{backwardPoint}", method = RequestMethod.GET)
//    public Page<Vehicle> findByBackwardPoint(@PathVariable String backwardPoint,  @RequestParam(name = "page") int page, @RequestParam(name = "size") int size){
//        return this.vehicleService.findByLocationBackwardPoint(Long.parseLong(backwardPoint),new PageRequest(page,size));
//    }

}
