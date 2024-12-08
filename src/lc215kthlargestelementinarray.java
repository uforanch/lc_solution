import java.util.*;
import java.util.stream.Collectors;

public class lc215kthlargestelementinarray {
    static class Solution {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<Integer>(nums.length, Collections.reverseOrder());
            for (int n: nums){
                pq.add(n);
            }
            for (int i=0; i<k-1;i++){
                pq.poll();
            }
            return pq.peek();

        }
    }
}
