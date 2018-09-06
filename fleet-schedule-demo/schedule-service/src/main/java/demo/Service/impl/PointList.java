package demo.Service.impl;

import demo.domain.myPoint;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PointList {
    private List<myPoint> myPoints;

    public PointList(){
        myPoints = new ArrayList<>();
    }
}
