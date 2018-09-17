package demo.Service;

import demo.domain.Road;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 道路数据服务
 */
public interface RoadService {

    /**
     * 增加（含更新
     * @param roads 准备写入的数据
     * @return
     */
    List<Road> saveRoads(List<Road> roads);

    /**
     * 删除所有
     */
    void deleteAll();

    /**
     * 查询所有
     * @return
     */
    List<Road> findAll();

    void deleteByRid(Long rId);

    /**
     * 按起点查询
     * @param beginPoint 起点编号
     * @param pageable
     * @return
     */
    Page<Road> findByBeginPoint(Integer beginPoint, Pageable pageable);

    /**
     * 按终点查询
     * @param endPoint 终点编号
     * @param pageable
     * @return
     */
    Page<Road> findByEndPoint(Integer endPoint, Pageable pageable);

    /**
     * 按起点和终点查询
     * @param beginPoint 起点编号
     * @param endPoint 终点编号
     * @param pageable
     * @return
     */
    Page<Road> findByBeginPointAndEndPoint(Integer beginPoint, Integer endPoint, Pageable pageable);

}
