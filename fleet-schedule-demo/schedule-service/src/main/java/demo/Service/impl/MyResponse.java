package demo.Service.impl;

//对前端用车请求的响应

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MyResponse {
    private Long vid; //分配给乘客的车辆编号
    String license;  //车牌号
    List<Integer> path;  //路径
}
