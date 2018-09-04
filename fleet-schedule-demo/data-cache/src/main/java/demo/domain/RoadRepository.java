package demo.domain;

//道路数据CRUD

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;


public interface RoadRepository extends JpaRepository<Road, Long> {

    Page<Road> findByBeginPoint(@Param("beginPoint") Long beginPoint, Pageable pageable); //按起点查询道路，下类似
    Page<Road> findByEndPoint(@Param("endPoint") Long endPoint, Pageable pageable);
    Page<Road> findByBeginPointAndEndPoint(@Param("beginPoint") Long beginPoint, @Param("endPoint") Long endPoint, Pageable pageable);

}
