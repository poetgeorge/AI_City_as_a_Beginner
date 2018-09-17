package demo.Service;

import demo.domain.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 车辆基础数据服务
 */

public interface VehicleService {

    /**
     * 增加（含更新）
     * @param vehicles 准备写入的车辆基础数据
     * @return
     */
    List<Vehicle> saveVehicles(List<Vehicle> vehicles);

    /**
     * 删除所有
     */
    void deleteAll();

    /**
     * 查询所有
     * @return
     */
    List<Vehicle> findAll();

    void deleteByVid(Long vId);

    /**
     * 按车牌号查询
     * @param license 车牌号
     * @param pageable
     * @return
     */
    Page<Vehicle> findByLicense(String license, Pageable pageable);
//    Page<Vehicle> findByIsEmpty(boolean isEmpty, Pageable pageable);
//    Page<Vehicle> findByLocationForwardPoint(Long forwardPoint, Pageable pageable);
//    Page<Vehicle> findByLocationBackwardPoint(Long backwardPoint, Pageable pageable);

}
