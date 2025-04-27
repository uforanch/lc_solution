import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class lc1631mineffortpath {
    class Solution {
        public int minimumEffortPath(int[][] heights) {
            int row_count = heights.length;
            int col_count = heights[0].length;
            int[][] dist = new int[row_count][];
            for(int i=0; i<row_count; i++){
                dist[i] = new int[col_count];
                Arrays.fill(dist[i], (int) Math.pow(10,6)+1);
            }
            dist[0][0]=0;
            int unvisited = row_count*col_count;

            Queue<int[]> pq = new PriorityQueue<>((a, b)->a[0]-b[0]);//put this in the sheet
            pq.add(new int[]{0,0,0});

            boolean[][] visited = new boolean[row_count][];
            for(int i0=0; i0<row_count; i0++){
                visited[i0] = new boolean[col_count];

            }

            while(unvisited>0){
                int[] q_item = pq.poll();
                int node_r = q_item[1];
                int node_c = q_item[2];
                int node_dist = dist[node_r][node_c];
                int node_height = heights[node_r][node_c];
                if (visited[node_r][node_c]){
                    continue;
                }
                int[][] neighbors = new int[][] {{node_r-1, node_c}, {node_r+1, node_c}, {node_r, node_c-1}, {node_r, node_c+1}};
                for(int i=0; i<4;i++){
                    int node_next_r = neighbors[i][0];
                    int node_next_c = neighbors[i][1];
                    if (node_next_r<0 || node_next_r>=row_count || node_next_c<0 || node_next_c>=col_count){
                        continue;
                    }
                    if (visited[node_next_r][node_next_c]){
                        continue;
                    }
                    int node_next_height = heights[node_next_r][node_next_c];
                    dist[node_next_r][node_next_c] = Math.min(dist[node_next_r][node_next_c], Math.max(Math.abs(node_next_height- node_height), dist[node_r][node_c]));
                    pq.add(new int[]{dist[node_next_r][node_next_c], node_next_r,node_next_c});
                }
                visited[node_r][node_c]=true;
                unvisited--;

            }
            return dist[row_count-1][col_count-1];

        }
    }
}
