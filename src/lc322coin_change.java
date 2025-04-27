import java.util.Arrays;

public class lc322coin_change {
    class Solution01 {
        public int coinChange(int[] coins, int amount) {
            int[] dp_sol = new int[amount+1];
            Arrays.fill(dp_sol, amount+1);
            dp_sol[0]=0;
            for(int c: coins){
                for(int i=0; i<=amount; i++){
                    if(i<c){
                        continue;
                    }
                    dp_sol[i] = Math.min(dp_sol[i-c]+1,dp_sol[i]);
                }
            }
            return (dp_sol[amount]>amount) ? -1 : dp_sol[amount];
        }
    }
    static class Solution00 {
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
        Solution00 S = new Solution00();
        int[] coins = {1,2,5};
        S.coinChange(coins,122);
    }

}
