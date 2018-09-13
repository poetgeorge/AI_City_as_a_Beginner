package demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 道路数据
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@Entity
@Table(name = "ROAD")
@RequiredArgsConstructor
public class Road {

    @Id
    private Long rid;  //道路编号

    private Integer beginPoint; //起点编号
    private Integer endPoint;  //终点编号
    private double distance;  //道路长度
    //private double curNumPoint; //加入该道路后总地点数

}
