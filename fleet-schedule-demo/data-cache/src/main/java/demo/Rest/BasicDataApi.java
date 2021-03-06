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

/**
 * 基础数据模块对外接口
 */
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

    /**
     * 增加（含更新）地点
     * @param myPoints  准备写入的地点数据
     */
    @RequestMapping(value = "/mypoint", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void uploadpoints(@RequestBody List<myPoint> myPoints){
        this.pointService.savePoints(myPoints);
    }

    /**
     *增加（含更新）道路
     * @param roads 准备写入的道路数据
     */
    @RequestMapping(value = "/road", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void uploadroads(@RequestBody List<Road> roads){
        this.roadService.saveRoads(roads);
    }

    /**
     *增加（含更新） 车辆基础数据
     * @param vehicles 准备写入的车辆数据
     */
    @RequestMapping(value = "/vehicle", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void uploadvehicles(@RequestBody List<Vehicle> vehicles){
        this.vehicleService.saveVehicles(vehicles);
    }

    /**
     *查询所有道路
     * @return
     */
    @RequestMapping(value = "/roadfind", method = RequestMethod.GET)
    public List<Road> findAllRoads(){
        return this.roadService.findAll();
    }

    /**
     *查询所有地点
     * @return
     */
    @RequestMapping(value = "/pointfind", method = RequestMethod.GET)
    public List<myPoint> findAllPoints(){
        return this.pointService.findAll();
    }

    /**
     *查询所有车辆
     * @return
     */
    @RequestMapping(value = "/vehiclefind", method = RequestMethod.GET)
    public List<Vehicle> findAllVehicles(){
        return this.vehicleService.findAll();
    }

    /**
     *删除所有道路
     */
    @RequestMapping(value = "/purge/road", method = RequestMethod.POST)
    public void purgeroads(){
        this.roadService.deleteAll();
    }

    /**
     * 删除所有车辆
     */
    @RequestMapping(value = "/purge/vehicle", method = RequestMethod.POST)
    public void purgevehicles(){
        this.vehicleService.deleteAll();
    }

    /**
     *删除所有地点
     */
    @RequestMapping(value = "/purge/point", method = RequestMethod.POST)
    public void purgepoints(){
        this.pointService.deleteAll();
    }

    /**
     *按道路编号删除道路
     */
    @RequestMapping(value = "/roadd/{rId}", method = RequestMethod.POST)
    public void deleteByRid(@PathVariable String rId){
        this.roadService.deleteByRid(Long.parseLong(rId));
    }

    /**
     *按起点查询道路
     * @param beginPoint 起点编号
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "/roadb/{beginPoint}", method = RequestMethod.GET)
    public Page<Road> findByBeginPoint(@PathVariable String beginPoint, @RequestParam(name = "page") int page, @RequestParam(name = "size") int size){
        return this.roadService.findByBeginPoint(Integer.parseInt(beginPoint), new PageRequest(page,size));
    }

    /**
     *按终点查询道路
     * @param endPoint 终点编号
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "/roade/{endPoint}", method = RequestMethod.GET)
    public Page<Road> findByEndPoint(@PathVariable String endPoint, @RequestParam(name = "page") int page, @RequestParam(name = "size") int size){
        return this.roadService.findByEndPoint(Integer.parseInt(endPoint), new PageRequest(page,size));
    }

    /**
     *按起点和终点查询道路
     * @param beginPoint 起点编号
     * @param endPoint 终点编号
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "/road2/{beginPoint}/{endPoint}", method = RequestMethod.GET)
    public Page<Road> findByBeginPointAndEndPoint(@PathVariable String beginPoint,@PathVariable String endPoint, @RequestParam(name = "page") int page, @RequestParam(name = "size") int size){
        return this.roadService.findByBeginPointAndEndPoint(Integer.parseInt(beginPoint), Integer.parseInt(endPoint), new PageRequest(page,size));
    }

    /**
     *按地名查询地点
     * @param pName 地名
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "/pointp/{pName}", method = RequestMethod.GET)
    public Page<myPoint> findByPName(@PathVariable String pName, @RequestParam(name = "page") int page, @RequestParam(name = "size") int size){
        return this.pointService.findByPName(pName, new PageRequest(page,size));
    }

    /**
     *按地点编号删除地点
     */
    @RequestMapping(value = "/pointd/{pId}", method = RequestMethod.POST)
    public void deleteByPid(@PathVariable String pId){
        this.pointService.deleteByPid(Long.parseLong(pId));
    }

    /**
     *按车辆编号删除车辆
     */
    @RequestMapping(value = "/vehicled/{vId}", method = RequestMethod.POST)
    public void deleteByVid(@PathVariable String vId){
        this.vehicleService.deleteByVid(Long.parseLong(vId));
    }

    /**
     *按车牌号查询车辆
     * @param license 车牌号
     * @param page
     * @param size
     * @return
     */
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
