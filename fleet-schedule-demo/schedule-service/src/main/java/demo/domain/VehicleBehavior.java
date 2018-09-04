package demo.domain;

//车辆行为记录，供日志使用

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@Entity
@Table(name = "VEHICLE_BEHAVIOR")
@RequiredArgsConstructor
public class VehicleBehavior {

    @Id
    @GeneratedValue
    private Long bhid; //记录编号

    private int vid; //车辆编号
    private int startPoint; //出发地编号
    private int endPoint;  //到达地编号
    private double mileage;  //行驶里程

}
