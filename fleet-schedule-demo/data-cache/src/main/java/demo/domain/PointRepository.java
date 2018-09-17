package demo.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * 地点数据DAO
 */
public interface PointRepository extends JpaRepository<myPoint, Long> {

    /**
     * 按地名查询地点
     * @param pName 地名
     * @param pageable 分页
     * @return 相应地点
     */
    Page<myPoint> findByPName(@Param("pName") String pName, Pageable pageable);
    void deleteByPid(@Param("pId") Long pid);

}
