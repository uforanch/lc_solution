import java.lang.Math;
import java.util.Arrays;
public class lc746mincoststairs {

    static class Solution {
        private int MCCSrecur(int i, int[] cost, int[] memoArr){
            if (i>= cost.length) {return 0;}
            if (memoArr[i]>=0){return memoArr[i];}

            memoArr[i] = cost[i] + Math.min(MCCSrecur(i+1, cost, memoArr), MCCSrecur(i+2, cost, memoArr));
            return memoArr[i];
        }
        public int minCostClimbingStairs(int[] cost) {
            int n = cost.length;
            int[] memoArr = new int[cost.length];
            Arrays.fill(memoArr,-1);
            memoArr[n-1] = cost[n-1];
            memoArr[n-2] = cost[n-2];
            return Math.min(MCCSrecur(0, cost, memoArr), MCCSrecur(1,cost,memoArr));

        }
    }
}
