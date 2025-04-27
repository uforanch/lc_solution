public class lc136singlenumber {
    class Solution {
        public int singleNumber(int[] nums) {
            int out = 0;
            for(int n: nums){
                out = out ^ n;
            }
            return out;
        }
    }
}
