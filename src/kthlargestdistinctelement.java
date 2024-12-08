import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class kthlargestdistinctelement{
static class Solution {
    public int findKthLargest(int[] nums, int k) {
        /*
        doing without sorting, method 1:

        put nums in a set

        k times - get max from a stream reduction

        method 2:
        just use priority queue contains

        */
        //ArrayList<Integer> alnums = Arrays.asList(nums);// doesn't work.
        Set<Integer> s = new HashSet<Integer>(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        int m = 0;
        for(int i=0; i<k;i++){
            m = s.stream().reduce(0,( a, b)->Math.max(a,b));
            s.remove(m);
        }
        return m;


    }
}
}
