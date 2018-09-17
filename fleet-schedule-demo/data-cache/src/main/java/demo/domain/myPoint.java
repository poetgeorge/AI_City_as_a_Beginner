package demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 地点数据
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "POINT")
public class myPoint {

    @Id
    private Long pid; //地点编号

    private int crdx; //地点x坐标
    private int crdy; //地点y坐标

    private String pName; //地名

}
