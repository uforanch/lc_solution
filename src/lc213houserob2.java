public class lc213houserob2 {
    //https://leetcode.com/problems/house-robber-ii/description/
    static class Solution {
        /*
        coded more than I needed to with the circular items, but probably good exercise
        */
        public int rob_linear_circ(int[] nums, int i_s, int i_e){
            if (i_e==i_s){
                return 0;
            }
            int i_l = (i_e>i_s) ? i_e-i_s : nums.length - i_s + i_e;
            //everything will be shifted by i_s and modded by nums length
            int[] stole = new int[i_l];
            for(int i_add=i_l-1; i_add>=0; i_add--){
                int mc2 = 0;
                int mc1 = 0;
                int i = (i_s + i_add) % nums.length;
                if (i_add<= i_l-3){
                    mc2 = stole[i_add+2];
                }
                if (i_add<=i_l-2){
                    mc1 = stole[i_add+1];
                }
                stole[i_add] = Math.max(mc1, mc2+nums[i]);
            }
            return stole[0];

        }
        public int rob(int[] nums) {
            if (nums.length==2){
                return Math.max(nums[0], nums[1]);
            }
            if (nums.length==1){
                return nums[0];
            }
            if (nums.length==0){
                return 0;
            }

            return Math.max(nums[0] + rob_linear_circ(nums, 2,nums.length-1),
                    rob_linear_circ(nums, 1,nums.length));

        }
    }
}
