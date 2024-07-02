import java.util.Arrays;

/*
Leetcode link:
https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */

/*
Python solution:

class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        i=0
        j=len(numbers)-1
        while True:
            if numbers[i]+numbers[j]>target:
                j=j-1
            elif numbers[i]+numbers[j]<target:
                i=i+1
            elif numbers[i]+numbers[j]==target:
                return [i+1,j+1]
 */

public class lc167twosumII {
    public int[] twoSum(int[] numbers, int target) {
        int l_point = 0;
        int r_point = numbers.length-1;
        while (true){
            if (numbers[l_point]+numbers[r_point]>target){
                r_point--;
            } else  if (numbers[l_point]+numbers[r_point]<target){
                l_point++;
            } else if (numbers[l_point]+numbers[r_point]==target){
                int[] ans= {l_point+1, r_point+1};
                return ans;
            }



        }

    }
    public static void main(String[] args){
        int[] numbers = {2,7,11,15};
        int target = 9;
        lc167twosumII l = new lc167twosumII();
        System.out.println(Arrays.toString(l.twoSum(numbers, target)));


    }
}
