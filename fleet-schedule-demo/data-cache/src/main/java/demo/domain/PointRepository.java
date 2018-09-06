package demo.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface PointRepository extends JpaRepository<myPoint, Long> {

    Page<myPoint> findByPName(@Param("pName") String pName, Pageable pageable);

}
