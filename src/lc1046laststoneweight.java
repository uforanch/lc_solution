import java.util.PriorityQueue;
public class lc1046laststoneweight {
    static class Solution {
        public int lastStoneWeight(int[] stones) {
            PriorityQueue<Integer> sQ = new PriorityQueue(stones.length, (a,b)->(int)b-(int)a);
            // PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
            for(int s: stones){
                sQ.add(s);
            }
            while(sQ.size()>1){
                int s1 = sQ.poll();
                int s2 = sQ.poll();
                if (s1>s2){
                    sQ.add(s1-s2);
                } else if (s2>s1){
                    sQ.add(s2-s1);
                }

            }
            if (sQ.size()==0){ return 0; }
            return sQ.poll();

        }
    }
}
