package demo.domain;

//车辆行为记录CRUD

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface BehaviorRepository extends JpaRepository<VehicleBehavior, Long> {
    Page<VehicleBehavior> findByVid(@Param("vid") Long vid, Pageable pageable);
}
