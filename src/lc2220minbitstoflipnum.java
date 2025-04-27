public class lc2220minbitstoflipnum {
    static class Solution {
        public int minBitFlips(int start, int goal) {
            int n = start ^ goal;
            int out = 0;
            while(n > 0){
                int nb = n % 2;
                if (nb==1){
                    out++;
                }
                n = n>>1;
            }
            return out;
        }
    }
}
