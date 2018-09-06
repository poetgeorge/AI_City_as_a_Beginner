package demo.domain;

//地点数据

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
@RequiredArgsConstructor
@Entity
//对应数据库中表名"POINT"
@Table(name = "POINT")
public class myPoint {

    @Id
    private Long pid; //地点编号

    private String pName; //地名

}
