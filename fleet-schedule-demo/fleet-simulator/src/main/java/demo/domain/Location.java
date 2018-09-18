package demo.domain;

//自定义类，描述车辆在图上的位置

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Location {

    private Long currentRoad;  //所在道路编号
    private Long forwardPoint;  //车辆前方地点编号
    private Long backwardPoint;  //车辆后方地点编号
    private double forwardDistance;  //车辆距前方地点距离
    //private Timestamp currentTime;

}
