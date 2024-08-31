import java.util.Arrays;

public class lc322coin_change {
    static class Solution {
        private int recurse(int[] coins, int remain, int[] minimums, int inf){
            if (remain<0){
                return -1;
            } else if (remain==0){
                return 0;
            }

            if (minimums[remain] < inf) { return minimums[remain];}
            int m = inf;
            for(int coin:coins){
                int prev = recurse(coins, remain-coin, minimums, inf);
                if (prev>=0){prev+=1;}
                if (prev<m && prev>0){m=prev;}
            }
            minimums[remain] = (m != inf) ? m : -1;
            return minimums[remain];

        }

        public int coinChange(int[] coins, int amount) {
            int[] minimums = new int[amount+1];
            Arrays.fill(minimums, amount+1);
            minimums[0]=0;
            return recurse(coins, amount, minimums, amount+1);

        }
    }

    public static void main(String[] args){
        Solution S = new Solution();
        int[] coins = {1,2,5};
        S.coinChange(coins,122);
    }

}
