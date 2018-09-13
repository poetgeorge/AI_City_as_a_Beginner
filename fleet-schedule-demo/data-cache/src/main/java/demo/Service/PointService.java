package demo.Service;

import demo.domain.myPoint;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 地点数据服务
 */
public interface PointService {
    /**
     * 增加（含更新）
     * @param myPoints 准备写入的数据
     * @return
     */
    List<myPoint> savePoints(List<myPoint> myPoints);

    /**
     * 删除所有
     */
    void deleteAll();

    /**
     * 查询所有
     * @return
     */
    List<myPoint> findAll();

    /**
     * 按地名查询
     * @param pName 地名
     * @param pageable
     * @return
     */
    Page<myPoint> findByPName(String pName, Pageable pageable);
}
