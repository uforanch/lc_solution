import java.util.Arrays;

public class lc16_3sumclosest {
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int best_total = 0;

            best_total = nums[0]+nums[1]+nums[2];

            for(int i=0; i<nums.length;i++){
                if (i>0 && nums[i]==nums[i-1])
                    continue;
                int p_s = i+1;
                int p_e = nums.length-1;
                while (p_s<p_e){
                    int total = nums[i] + nums[p_s] + nums[p_e];
                    if (Math.abs(total-target) <= Math.abs(best_total-target)){
                        best_total = total;
                    }
                    if (total<target){
                        p_s++;
                    } else if (total>target){
                        p_e--;
                    } else {
                        return target;
                    }
                }


            }
            return best_total;

        }
    }
}
