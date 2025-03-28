public class lc647countpalsubstr {
    static class Solution {
        public int countSubstrings(String s) {

            int count = 0;

            for(int i=0; i<s.length(); i++){
                //odd substring

                int i_0 = 1;
                count++;
                while(i+i_0<s.length() && i-i_0>=0){
                    if (s.charAt(i-i_0)!=s.charAt(i+i_0)){
                        break;
                    }
                    count++;
                    i_0++;
                }
                if (i==0 || s.charAt(i-1) != s.charAt(i)){
                    continue;
                }
                count++;
                i_0=1;
                while(i-1-i_0>=0 && i+i_0<s.length()){
                    if(s.charAt(i-1-i_0)!=s.charAt(i+i_0)){
                        break;
                    }
                    count++;
                    i_0++;
                }
            }
            return count;

        }
    }
}
