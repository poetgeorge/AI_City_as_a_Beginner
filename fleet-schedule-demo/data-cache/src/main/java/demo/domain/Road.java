package demo.domain;

//道路数据

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@Entity
//对应数据库中表名"ROAD"
@Table(name = "ROAD")
@RequiredArgsConstructor
public class Road {

    @Id
    private Long rid;  //道路编号

    private int beginPoint; //起点编号
    private int endPoint;  //终点编号
    private double distance;  //道路长度
    private double curNumPoint; //加入该道路后总地点数

}
