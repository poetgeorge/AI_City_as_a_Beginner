package demo.domain;

//车辆DAO

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    //Page<Vehicle> findByVid(@Param("vid") Long vid, Pageable pageable);
    Page<Vehicle> findByLicense(@Param("license") String license, Pageable pageable); //按车牌号查询车辆，以下类似
    Page<Vehicle> findByIsEmpty(@Param("isEmpty") boolean isEmpty, Pageable pageable);
    Page<Vehicle> findByLocationForwardPoint(@Param("forwardPoint") int forwardPoint, Pageable pageable);
    Page<Vehicle> findByLocationBackwardPoint(@Param("backwardPoint") int backwardPoint, Pageable pageable);

}
