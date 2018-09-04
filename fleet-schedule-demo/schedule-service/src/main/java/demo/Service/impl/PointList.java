package demo.Service.impl;

import demo.domain.Point;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PointList {
    private List<Point> points;

    public PointList(){
        points = new ArrayList<>();
    }
}
