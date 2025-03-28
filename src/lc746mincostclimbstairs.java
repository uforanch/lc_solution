public class lc746mincostclimbstairs {
    static class Solution {

        public int minCostClimbingStairs(int[] cost) {
            int[] minCost = new int[cost.length];//cost assuming you paid for the stair
            for(int i=cost.length-1;i>=0;i--){
                int mc2 = 0;
                int mc1 = 0;
                if (i+1<=cost.length-1){
                    mc1 = minCost[i+1] + cost[i+1];
                }

                if (i+2<=cost.length-1){
                    mc2 = minCost[i+2] + cost[i+2];
                }

                minCost[i] = Math.min(mc1,mc2);
            }
            return Math.min(cost[0]+minCost[0], cost[1]+minCost[1]);
        }
    }
}
