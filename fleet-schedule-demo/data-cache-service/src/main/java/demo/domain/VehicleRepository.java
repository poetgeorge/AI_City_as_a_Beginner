package demo.domain;

//车辆数据CRUD

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    List<Vehicle> findByLicense(@Param("license") String license); //按车牌号查询车辆，以下类似
    List<Vehicle> findByIsEmpty(@Param("isEmpty") boolean isEmpty);
    List<Vehicle> findByLocationForwardPoint(@Param("forwardPoint") Long forwardPoint);
    List<Vehicle> findByLocationBackwardPoint(@Param("backwardPoint") Long backwardPoint);

}
