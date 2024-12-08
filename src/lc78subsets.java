import java.util.*;
// https://leetcode.com/problems/subsets/submissions/1388091503/

public class lc78subsets {
    static class Solution {
        private List<List<Integer>> subsetRecur(int[] nums, int index){
            if (index==nums.length){
                List<List<Integer>> l = new ArrayList<>();
                l.add(new ArrayList<Integer>());
                return  l; }
            List<List<Integer>> sets = subsetRecur(nums, index+1);
            int num = nums[index];
            int l = sets.size();
            for(int i = 0; i<l;i++){
                List<Integer> set = sets.get(i);
                List<Integer> newSet = new ArrayList<Integer>();
                newSet.add(num);
                newSet.addAll(set);
                sets.add(newSet);
            }
            return sets;

        }

        public List<List<Integer>> subsets(int[] nums) {
            return subsetRecur(nums,0);
        }
    }
    public static void main(String[] args){
        Solution s = new Solution();
        s.subsets(new int[]{1,2,3});
    }
}
