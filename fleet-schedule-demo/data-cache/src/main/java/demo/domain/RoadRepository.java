package demo.domain;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * 道路数据DAO
 */
public interface RoadRepository extends JpaRepository<Road, Long> {

    /**
     * 按起点查询道路
     * @param beginPoint 起点编号
     * @param pageable 分页
     * @return 相应道路
     */
    Page<Road> findByBeginPoint(@Param("beginPoint") Integer beginPoint, Pageable pageable);

    /**
     * 按终点查询道路
     * @param endPoint 终点编号
     * @param pageable
     * @return
     */
    Page<Road> findByEndPoint(@Param("endPoint") Integer endPoint, Pageable pageable);

    /**
     * 按起点和终点查询道路
     * @param beginPoint 起点编号
     * @param endPoint 终点编号
     * @param pageable
     * @return
     */
    Page<Road> findByBeginPointAndEndPoint(@Param("beginPoint") Integer beginPoint, @Param("endPoint") Integer endPoint, Pageable pageable);

}
