public class lc5longpalsubstr {
    static class Solution {
        public String longestPalindrome(String s) {
            int max_l=1;
            int new_max_l = 1;
            String max_l_s=s.substring(0,1);

            for(int i=0; i<s.length(); i++){
                //odd substring

                int i_0 = 1;
                while(i+i_0<s.length() && i-i_0>=0){
                    if (s.charAt(i-i_0)!=s.charAt(i+i_0)){
                        break;
                    }
                    new_max_l = 1 + i_0*2;
                    if (new_max_l>max_l){
                        max_l = new_max_l;
                        max_l_s = s.substring(i-i_0, i+i_0+1);
                    }
                    i_0++;
                }
                if (i==0 || s.charAt(i-1) != s.charAt(i)){
                    continue;
                }
                i_0=0;
                while(i-1-i_0>=0 && i+i_0<s.length()){
                    if(s.charAt(i-1-i_0)!=s.charAt(i+i_0)){
                        break;
                    }

                    new_max_l = 2 + i_0*2;
                    if (new_max_l>max_l){
                        max_l = new_max_l;
                        max_l_s = s.substring(i-1-i_0, i+i_0+1);
                    }
                    i_0++;
                }
            }
            return max_l_s;
        }
    }
}
