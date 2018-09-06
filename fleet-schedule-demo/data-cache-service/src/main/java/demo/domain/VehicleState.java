package demo.domain;

//车辆状态数据

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@Entity
@RequiredArgsConstructor
public class VehicleState {

    @Id
    private Long vid;  //车辆编号

    private String license; //车牌号
    private boolean isEmpty = true;  //是否空闲

    @Embedded
    private Location location;  //车辆位置，自定义类

    private int Destination;  //车辆目的地点编号

}
