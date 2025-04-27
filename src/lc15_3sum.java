import java.util.*;
/*
Leetcode link:
https://leetcode.com/problems/3sum/description/
 */


public class lc15_3sum {
    class Solution { // 4 26 25
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> out = new ArrayList<>();

            for(int i=0; i<nums.length;i++){
                if (i>0 && nums[i]==nums[i-1])
                    continue;
                int p_s = i+1;
                int p_e = nums.length-1;
                while (p_s<p_e){
                    int total = nums[i] + nums[p_s] + nums[p_e];
                    if (total<0){
                        p_s++;
                    } else if (total>0){
                        p_e--;
                    } else {
                        out.add(List.of(nums[i], nums[p_s], nums[p_e]));
                        p_s++;
                        while(p_s<p_e && nums[p_s]==nums[p_s-1]){
                            p_s++;
                        }
                    }
                }


            }
            return out;

        }
    }
    public List<List<Integer>> threeSum(int[] nums) {

        HashMap<Integer, Integer> nums_freq = new HashMap<>();
        HashSet<Integer> nums_set = new HashSet<Integer>();
        ArrayList<Integer> nums_sort = new ArrayList<>();
        for (int num: nums){
            nums_freq.put(num,nums_freq.getOrDefault(num,0)+1);
            if (! nums_set.contains(num))
            {
                nums_set.add(num);
                nums_sort.add(num);
            }
        }

        Collections.sort(nums_sort);
        ArrayList<List<Integer>> triples = new ArrayList<>();


        for (int i = 0; i<nums_sort.size(); i++){
            int num =  nums_sort.get(i);
            if (num>0){
                break;
            }
            if (num==0){
                if (nums_freq.get(num)>=3){
                    Integer[] ans = {0,0,0};
                    triples.add(Arrays.asList(ans));
                    break;
                }
            }
            if (nums_freq.get(num)>1 && nums_freq.getOrDefault(-2*num,0)>0 && -2*num > num){
                Integer[] ans = {num, num, -2*num};
                triples.add(Arrays.asList(ans));
            }
            if (-1*num%2==0){
                int num_2 = -1*num/2;
                if (nums_freq.getOrDefault(num_2,0)>1 && num_2>num) {
                    Integer[] ans = {num, num_2, num_2};
                    triples.add(Arrays.asList(ans));
                }
            }
            for(int j = i+1; j<nums_sort.size(); j++){
                int num_j = nums_sort.get(j);
                if (num+num_j>0){
                    break;
                }
                int num_rem = -1*(num_j+num);
                if (num_rem == num_j || num_rem == num){
                    continue;
                }
                if (nums_freq.getOrDefault(num_rem,0)>=1 && num_rem>num_j){

                    Integer[] ans = {num, num_j, num_rem};
                    triples.add(Arrays.asList(ans));
                }

            }

        }
        return triples;

    }

    public static void main(String[] args){
        lc15_3sum l = new lc15_3sum();
        //int[] nums = {-1,0,1,2,-1,-4};
        int[] nums = {-1,0,1,0};
        System.out.println(l.threeSum(nums).toString());

    }
}
