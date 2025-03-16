import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class lc994rottenOranges {
    public static class Solution {
        public static int num_to_r(int num, int w, int h){
            return (num - num % w)/w;
        }
        public static int num_to_c(int num, int w, int h){
            return num % w;
        }

        public static int rc_to_num(int r, int c, int w, int h){

            return c + w*r;
        }

        public int orangesRotting(int[][] grid) {
            int min = -1;
            int h = grid.length;
            int w = grid[0].length;
            int fresh_oranges=0;

            Set<Integer> curMinute = new HashSet<>();
            Set<Integer> nextMinute = new HashSet<>();
            List<String> dirList = List.of("Up", "Down", "Left", "Right");

            for(int i_h =0; i_h<h;i_h++ ){
                for(int i_w=0; i_w<w; i_w++){
                    if (grid[i_h][i_w]==1){
                        fresh_oranges++;
                    } else if (grid[i_h][i_w]==2){
                        curMinute.add(Solution.rc_to_num(i_h,i_w,w,h));
                    }

                }
            }

            if (fresh_oranges==0){return 0;}
            while(fresh_oranges>0 && !curMinute.isEmpty()){
                min++;
                for(int n: curMinute){
                    int r = Solution.num_to_r(n, w, h);
                    int c = Solution.num_to_c(n, w, h);
                    if (grid[r][c]==1){
                        grid[r][c]=2;
                        fresh_oranges--;
                    }
                    //System.out.println(min + " " + n + " " + fresh_oranges);
                    for(String dir:dirList){
                        int rr = r;
                        int cc = c;
                        if(dir.equals("Up")){
                            rr--;
                        } else if (dir.equals("Down")){
                            rr++;
                        } else if (dir.equals("Left")){
                            cc--;
                        } else if (dir.equals("Right")){
                            cc++;
                        }
                        if (rr>=0 && rr<h && cc>=0 && cc<w){
                            if (grid[rr][cc]==1){
                                nextMinute.add(Solution.rc_to_num(rr,cc,w,h));
                            }
                        }
                    }

                }
                curMinute.clear();
                curMinute.addAll(nextMinute);
                nextMinute.clear();
            }
            if(fresh_oranges>0){return -1;}
            return min;

        }
    }

    public static void main(String[] args){
        Solution s = new Solution();
        int[][] tc00 = {{2,1,1}, {1,1,0},{0,1,1}};
        System.out.println(s.orangesRotting(tc00));
    }
}
