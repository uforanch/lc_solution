import java.util.Arrays;
public class lc198houserobber {

    /*
    solution 3 25
     */
    static class Solution2 {
        public int rob(int[] nums) {
            int[] maxStole = new int[nums.length];
        /*
        assuming house row starts with index
        */
            for(int i=nums.length-1;i>=0;i--){
                int ms2=0;
                int ms1=0;
                if (i+2<=nums.length-1){
                    ms2 = maxStole[i+2];
                }
                if (i+1<=nums.length-1){
                    ms1 = maxStole[i+1];
                }
                maxStole[i] = Math.max(ms1, nums[i]+ms2);
            }
            return maxStole[0];

        }
    }
    /*
    so if line is:
    if (memoArr[i]>0) { return memoArr[i];}
    this loops forever instead of having an error for some reason.

     */
    static class Solution {
        private int recur(int i, int[] nums, int[] memoArr){
            System.out.println(i);
            if (i>=nums.length) { return 0;}
            if (memoArr[i]>=0) { return memoArr[i];}
            memoArr[i] = Math.max(recur(i+1, nums, memoArr),nums[i] + recur(i+2, nums, memoArr));
            //System.out.println(String.valueOf(i) + " " + Arrays.toString(memoArr));
            return memoArr[i];
        }


        public int rob(int[] nums) {
        /*
            subproblem:
                robbing houses i through n = S(i)
            recurrance options:
                don't rob house i: S(i+1). rob house i: S(i+2) + nums[i]
        */

            //stores max from subproblem
            int[] memoArr = new int[nums.length];
            Arrays.fill(memoArr, -1);

            return recur(0, nums, memoArr);
        }
    }
    public static void main(String[] args){
        Solution s = new Solution();
        int[] nums = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        System.out.println(nums.length);
        System.out.println(s.rob(nums));

    }
}
