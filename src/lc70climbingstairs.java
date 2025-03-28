import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/climbing-stairs/

small mistake got one off on the array
there's other ways to do this but this works for leetcode

 */
public class lc70climbingstairs {
    static class Solution {
        public int climbStairs(int n) {
            List<Integer> stairs = new ArrayList<>();
            stairs.add(1);
            stairs.add(1);
            stairs.add(2);
            for(int i=3; i<=n;i++){
                stairs.add(stairs.get(i-1) + stairs.get(i-2));
            }
            return stairs.get(n);
        }
    }
}
