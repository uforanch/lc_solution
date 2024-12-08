import java.util.PriorityQueue;
import java.util.function.BiFunction;
import java.util.function.Function;

public class lc973kclosestpointstoorigin {
    //public class Point implements Comparable<Point>
    //return Integer.compare(distance(other), distance(this));
    static class Solution {
        public double odist(int x,int y){
            return Math.sqrt(x*x+y*y);


        }
        private int signum(double d){
            if (d==0) {return 0;}
            return (d>0) ? 1 : -1;
        }

        public int[][] kClosest(int[][] points, int k) {
            int[][] out = new int[k][2];

            PriorityQueue<Integer[]> pq = new PriorityQueue<>(points.length, (p1,p2)-> signum(odist(p1[0], p1[1]) - odist(p2[0], p2[1])) );

            for(int i=0; i < points.length; i++){
                Integer[] p = {points[i][0], points[i][1]};
                pq.add(p);
            }
            for (int i=0; i<k; i++){
                Integer[] p = pq.poll();
                out[i][0]=p[0]; //array initializer not allowed here!
                //ans[i] = new int[]{p.x, p.y}; apparently this works, though!
                out[i][1]=p[1];
            }

            return out;
        }
    }
}
