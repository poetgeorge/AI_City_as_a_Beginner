package demo.Service;

//调度服务的核心业务逻辑

import demo.Service.impl.MyResponse;

public interface ScheduleService {
    //接受乘客的出发地和目的地，返回分配给乘客的车辆车牌号
    MyResponse schedule(int startPoint, int endPoint);
}
