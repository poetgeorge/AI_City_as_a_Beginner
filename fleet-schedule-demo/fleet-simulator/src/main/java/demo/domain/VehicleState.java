package demo.domain;

//车辆状态数据

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class VehicleState {


    private Long vid;  //车辆编号

    private String license; //车牌号
    private boolean isEmpty = true;  //是否空闲

    private Location location;  //车辆位置，自定义类

    private Long Destination;  //车辆目的地点编号


}
