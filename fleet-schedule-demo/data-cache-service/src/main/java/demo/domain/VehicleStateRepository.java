package demo.domain;

//车辆状态数据CRUD

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VehicleStateRepository extends JpaRepository<VehicleState, Long> {

    List<VehicleState> findByLicense(@Param("license") String license); //按车牌号查询车辆状态
    List<VehicleState> findByIsEmpty(@Param("isEmpty") boolean isEmpty); //按是否空闲查询车辆状态
    List<VehicleState> findByLocationCurrentRoad(@Param("currentRoad") Long currentRoad); //按所在道路查询车辆状态
    List<VehicleState> findByLocationForwardPoint(@Param("forwardPoint") Long forwardPoint);  //按车辆前方地点查询车辆状态
    List<VehicleState> findByLocationBackwardPoint(@Param("backwardPoint") Long backwardPoint); //按车辆后方地点查询车辆状态

    void deleteByVid(Long vId);
}
