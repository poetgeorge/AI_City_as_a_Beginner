package demo.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * 车辆基础数据DAO
 */
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    //Page<Vehicle> findByVid(@Param("vid") Long vid, Pageable pageable);

    /**
     * 按车牌号查询车辆
     * @param license 车牌号
     * @param pageable 分页
     * @return 相应车辆
     */
    Page<Vehicle> findByLicense(@Param("license") String license, Pageable pageable); //按车牌号查询车辆，以下类似
//    Page<Vehicle> findByIsEmpty(@Param("isEmpty") boolean isEmpty, Pageable pageable);
//    Page<Vehicle> findByLocationForwardPoint(@Param("forwardPoint") Long forwardPoint, Pageable pageable);
//    Page<Vehicle> findByLocationBackwardPoint(@Param("backwardPoint") Long backwardPoint, Pageable pageable);

}
