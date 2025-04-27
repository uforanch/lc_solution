public class lc191hammingweight {
    class Solution {
        public int hammingWeight(int n) {
            int out =0;
            while (n>0){
                out += n % 2;
                n = n>>1;
            }
            return out;
        }
    }
}
