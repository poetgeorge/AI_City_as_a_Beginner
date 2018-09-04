package demo.Service.impl;

import demo.domain.Road;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RoadList {
    private List<Road> roads;

    public RoadList(){
        roads = new ArrayList<>();
    }
}
