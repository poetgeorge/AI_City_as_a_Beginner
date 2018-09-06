package demo.domain;

//车辆数据CRUD

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VehicleRepository extends JpaRepository<VehicleState, Long> {

    List<VehicleState> findByLicense(@Param("license") String license); //按车牌号查询车辆，以下类似
    List<VehicleState> findByIsEmpty(@Param("isEmpty") boolean isEmpty);
    List<VehicleState> findByLocationForwardPoint(@Param("forwardPoint") Long forwardPoint);
    List<VehicleState> findByLocationBackwardPoint(@Param("backwardPoint") Long backwardPoint);

}
