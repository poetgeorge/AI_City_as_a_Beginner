package demo.Service.impl;

//对前端用车请求的响应

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
public class MyResponse {
    private Long vid; //分配给乘客的车辆编号
    String license;  //车牌号
    List<Integer> path;  //路径
}
