package demo.domain;

//自定义类，描述车辆在图上的位置

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Embeddable;
import java.sql.Timestamp;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@Embeddable
@RequiredArgsConstructor
public class Location {

    private int forwardPoint;  //车辆前方地点编号
    private int backwardPoint;  //车辆后方地点编号
    private int forwardDistance;  //车辆距前方地点距离
    private Timestamp currentTime;

}
