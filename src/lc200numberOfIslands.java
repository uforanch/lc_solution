import java.util.*;

public class lc200numberOfIslands {
    static class Solution {
        public int num_to_row_num(int num, int r_count, int c_count) {
            return (num - num % c_count)/c_count;
        }

        public int num_to_col_num(int num, int r_count, int c_count) {
            return num % c_count;
        }

        public int rc_to_num(int r, int c, int r_count, int c_count){
            return r * c_count + c;
        }
        public int numIslands(char[][] grid) {
            int r_count= grid.length;
            int c_count = grid[0].length;
            int[][] visited = new int[r_count][c_count];
            int num_islands=0;

            for (int i_r = 0; i_r<r_count; i_r++){
                for(int i_c = 0; i_c<c_count; i_c++){

                    if (grid[i_r][i_c]=='0'){
                        visited[i_r][i_c]=1;
                        continue;
                    } else if (visited[i_r][i_c]==1){
                        continue;
                    }
                    num_islands++;
                    List<Integer> l = new ArrayList<>();
                    l.add(rc_to_num(i_r,i_c,r_count,c_count));
                    while(!l.isEmpty()){
                        int n = l.get(l.size()-1);
                        l.remove(l.size()-1);

                        int r = num_to_row_num(n, r_count, c_count);
                        int c = num_to_col_num(n, r_count, c_count);
                        visited[r][c]=1;
                        if (r-1>=0){
                            if (visited[r-1][c]==0 && grid[r-1][c]=='1'){
                                l.add(rc_to_num(r-1,c,r_count,c_count));
                            }
                        }
                        if (r+1<r_count){
                            if (visited[r+1][c]==0 && grid[r+1][c]=='1'){
                                l.add(rc_to_num(r+1,c,r_count,c_count));
                            }
                        }
                        if (c-1>=0){
                            if (visited[r][c-1]==0 && grid[r][c-1]=='1'){
                                l.add(rc_to_num(r,c-1,r_count,c_count));
                            }
                        }
                        if (c+1<c_count){
                            if (visited[r][c+1]==0 && grid[r][c+1]=='1'){
                                l.add(rc_to_num(r,c+1,r_count,c_count));
                            }
                        }



                    }

                }
            }
            return num_islands;
        }
    }
    static class AltSolution00 {
        /*
        Downloaded solution to get some new tactics
         */
        public int numIslands(char[][] grid) {
            int islands = 0;
            int rows = grid.length;
            int cols = grid[0].length;
            Set<String> visited = new HashSet<>();

            int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    /*
                    TACTIC:

                    hash strings rather than a formula - though here
                    we don't have to unhash

                    visited is a set rather than an array
                     */
                    if (grid[r][c] == '1' && !visited.contains(r + "," + c)) {
                        islands++;
                        bfs(grid, r, c, visited, directions, rows, cols);
                    }
                }
            }

            return islands;
        }

        private void bfs(char[][] grid, int r, int c, Set<String> visited, int[][] directions, int rows, int cols) {
            //QUEUE is what we need linkedlist to inherit from
            Queue<int[]> q = new LinkedList<>();
            visited.add(r + "," + c);
            q.add(new int[]{r, c});

            while (!q.isEmpty()) {
                int[] point = q.poll();
                int row = point[0], col = point[1];

                for (int[] direction : directions) {
                    int nr = row + direction[0], nc = col + direction[1];
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == '1' && !visited.contains(nr + "," + nc)) {
                        /*
                        tactic - if values are pairs use a two-length array
                         */
                        q.add(new int[]{nr, nc});
                        visited.add(nr + "," + nc);
                    }
                }
            }
        }
    }
}
