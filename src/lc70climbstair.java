/*
note:
initializing inside can't work
if this were an app - could just have some if then to extend array
 */
public class lc70climbstair {
    static class Solution {
        private int[] countRec;
        private int climbStairs_recur(int n){

            if (n<0){return 0;}
            if (countRec[n] != 0 ){
                return countRec[n];
            }
            int c = climbStairs_recur(n-1) + climbStairs_recur(n-2);
            countRec[n]=c;
            return c;

        }
        public int climbStairs(int n) {
            countRec = new int[n+1];
            countRec[0]=1;
            return climbStairs_recur(n);
        }
    }
}
