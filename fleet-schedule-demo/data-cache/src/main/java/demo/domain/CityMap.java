package demo.domain;

//地图类

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CityMap {

    private final int MAX = 255;
    private double[][] myMap; //邻接矩阵表示地图，元素值为路径长度（0代表无道路）
    private int numOfRoad; //道路数


    public CityMap() {
        int i,j;
        myMap = new double[MAX][MAX];
        numOfRoad = 0;
        for(i = 0;i <= MAX;i++)
            for(j = 0;j <= MAX;j++)
                myMap[i][j] = 0;
    }

    //创建地图，需要一组道路数据
    public void createMap(Road[] d) {
        int i,j;
        for (i = 0; i < d.length; i++) {
            if (d[i] == null) break;
            int v1, v2;
            v1 = d[i].beginPoint;
            v2 = d[i].endPoint;
            myMap[v1][v2] = myMap[v2][v1] = d[i].length;
            numOfRoad = i;
        }
    }

    //添加道路
    public void putRoad(Road newRoad){
        int v1,v2;
        v1 = newRoad.beginPoint;
        v2 = newRoad.endPoint;
        if(myMap[v1][v2]==0)
            numOfRoad++;
        myMap[v1][v2] = myMap[v2][v1] = newRoad.length;
        numOfRoad++;
    }

    //删除道路
    public void removeRoad(Road nonRoad){
        int v1,v2;
        v1 = nonRoad.beginPoint;
        v2 = nonRoad.endPoint;
        if(myMap[v1][v2]==0)
            System.exit(0);
        myMap[v1][v2] = myMap[v2][v1] = 0;
        numOfRoad--;
    }

    //查询两点间距离，返回0则两点不通；
    public double findDistance(int i, int j){
        return myMap[i][j];
    }

    //得到地点数
    public int getNumOfPoint(){
        int i,j;
        int num=0;
        for(j = 0;j <= MAX;j++) {
            for (i = 0; i <= MAX; i++)
                if(myMap[j][i] != 0 && j != i){
                  num++;
                  break;
                }
        }
        return num;
    }

    //得到道路数
    public int getNumOfRoad(){
        return numOfRoad;
    }

}
