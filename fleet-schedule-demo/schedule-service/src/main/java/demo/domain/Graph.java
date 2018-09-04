package demo.domain;

//地图类

import lombok.Data;

@Data
public class Graph {

    private double[][] m; //邻接矩阵
    //private Point[] p;  //地点集合
    //private Road[] road;  //道路集合
    private int numPoint;  //地点数
    private final int MAX=Integer.MAX_VALUE;  //最大值，用于代表此路不通
    private int [][] allpath;  //allpath[i][j] 为 第i个顶点的前驱顶点数组。即，allpath[i][j]的值是"顶点i"到"顶点j"的最短路径所经历的全部顶点中，位于"顶点j"之前的那个顶点
    private double[][] alldist;  //alldist[i][j] 为 第j个顶点的长度数组。即，dist[i][j]是"顶点i"到"顶点j"的最短路径的长度。
    private boolean[][] allflag; //allflag[][] 为 true 意味着从顶点i到顶点j有最短路

    public Graph(Road[] d, Point[] p){
        this.numPoint = p.length;
        int i,j;
        //for(i=0;i<p.length;i++)
            //this.p[i] = p[i];
        for(i=0;i<p.length;i++)
            for(j=0;j<p.length;j++)
                this.m[i][j]=MAX;
        for (i = 0; i < d.length; i++) {
            if (d[i] == null) break;
            int v1, v2;
            v1 = Math.toIntExact(d[i].getBeginPoint());
            v2 = Math.toIntExact(d[i].getEndPoint());
            this.m[v1][v2] = this.m[v2][v1] = d[i].getDistance();
        }
        this.allpath = new int [this.numPoint][this.numPoint];
        this.alldist = new double [this.numPoint][this.numPoint];
        this.allflag = new boolean[this.numPoint][this.numPoint];
    }


    //Dijsktra最短路算法
    public void dijsktraall() {
        int a;
        for(a=0;a<this.numPoint;a++) {
            // vs -- 起始顶点(start vertex)。即计算"顶点vs"到其它顶点的最短路径。
            int vs = a;
            // prev -- 前驱顶点数组。即，prev[i]的值是"顶点vs"到"顶点i"的最短路径所经历的全部顶点中，位于"顶点i"之前的那个顶点
            int[] prev = new int[this.numPoint];

            //dist -- 长度数组。即，dist[i]是"顶点vs"到"顶点i"的最短路径的长度。
            double[] dist = new double[this.numPoint];

            // flag[i]=true表示"顶点vs"到"顶点i"的最短路径已成功获取
            boolean[] flag = new boolean[this.numPoint];

            // 初始化
            for (int i = 0; i < this.numPoint; i++) {
                flag[i] = false;          // 顶点i的最短路径还没获取到。
                prev[i] = 0;              // 顶点i的前驱顶点为0。
                dist[i] = this.m[vs][i];  // 顶点i的最短路径为"顶点vs"到"顶点i"的权。
            }

            // 对"顶点vs"自身进行初始化
            flag[vs] = true;
            dist[vs] = 0;

            // 遍历mVexs.length-1次；每次找出一个顶点的最短路径。
            int k = 0;
            for (int i = 1; i < this.numPoint; i++) {
                // 寻找当前最小的路径；
                // 即，在未获取最短路径的顶点中，找到离vs最近的顶点(k)。
                double min = this.MAX;
                for (int j = 0; j < this.numPoint; j++) {
                    if (flag[j] == false && dist[j] < min) {
                        min = dist[j];
                        k = j;
                    }
                }
                // 标记"顶点k"为已经获取到最短路径
                flag[k] = true;

                // 修正当前最短路径和前驱顶点
                // 即，当已经"顶点k的最短路径"之后，更新"未获取最短路径的顶点的最短路径和前驱顶点"。
                for (int j = 0; j < this.numPoint; j++) {
                    double tmp = (this.m[k][j] == this.MAX ? this.MAX : (min + this.m[k][j]));
                    if (flag[j] == false && (tmp < dist[j])) {
                        dist[j] = tmp;
                        prev[j] = k;
                    }
                }
            }
            this.allpath[a] = prev;
            this.alldist[a] = dist;
            this.allflag[a] = flag;
        }
    }

}
