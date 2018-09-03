package demo.domain;

//道路DAO

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;


public interface RoadRepository extends JpaRepository<Road, Long> {

    Page<Road> findByBeginPoint(@Param("beginPoint") int beginPoint, Pageable pageable); //按起点查询道路，下类似
    Page<Road> findByEndPoint(@Param("endPoint") int endPoint, Pageable pageable);
    Page<Road> findByBeginPointAndEndPoint(@Param("beginPoint") int beginPoint, @Param("endPoint") int endPoint, Pageable pageable);

}