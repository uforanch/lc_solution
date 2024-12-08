import java.util.PriorityQueue;
public class lc703kthlargetelementinstream {
    static class KthLargest {
        private PriorityQueue<Integer> topQ;
        //private PriorityQueue othersQ;
        private int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            int l = nums.length + k + 100;
            this.topQ = new PriorityQueue<Integer>(l);
            // this.othersQ = new PriorityQueue<>(l);
            for (int n:nums){
                add(n);
            }
        }

        public int add(int val) {
            topQ.add(val);
            while (topQ.size() > k) {
                topQ.poll();
                //othersQ.add(val);//if we had a delete function we'd use this
            }

            return (int) topQ.peek();

        }
    }
    public static void main(String[] args){
        int[] nums ={};
        int[] nextnums = {-3,-2,-4,0,4};
        KthLargest k = new KthLargest(1,nums);
        for (int n: nextnums){
            System.out.println(k.add(n));
        }
    }
}
