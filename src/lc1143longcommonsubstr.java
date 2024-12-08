
import java.util.Arrays;

public class lc1143longcommonsubstr {
    static interface Solution {
        int longestCommonSubsequence(String text1, String text2);
    }

    static class Solution00 implements  Solution{
        /*
        TIMES OUT. WHY?

        xxxxx yyy
        i,j is where pointer is
        if strings equal at current 1 + (i+1,j+1)
        if not max of (i+1,j),(i,j+1)

        */
        public int recur(int i, int j, String text1, String text2, int[][] ssCount){
            if (i>=text1.length() || j >= text2.length()){
                return 0;
            }
            //FORGOT THIS
            if (ssCount[i][j]!=-1){return ssCount[i][j];}
            if (text1.charAt(i) == text2.charAt(j)){
                ssCount[i][j] = 1 + recur(i+1,j+1,text1,text2, ssCount);
                return ssCount[i][j];
            } else {
                ssCount[i][j] = Math.max(recur(i+1,j,text1,text2, ssCount), recur(i,j+1,text1,text2, ssCount));
                return ssCount[i][j];
            }
        }
        public int longestCommonSubsequence(String text1, String text2) {
            int[][] ssCount = new int[text1.length()][text2.length()];
            long se = System.nanoTime();
            for(int i = 0; i<text1.length(); i++){
                for(int j=0; j<text2.length(); j++){
                    ssCount[i][j]=-1;
                }
            }
            System.out.println(System.nanoTime()-se);
            return recur(0,0, text1, text2, ssCount);

        }
    }

    static class SolutionLC00 implements  Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            return solve(text1, text2, text1.length() - 1, text2.length() - 1);
        }

        private int solve(String text1, String text2, int i, int j) {
            if (i < 0 || j < 0) {
                return 0;
            }
            if (text1.charAt(i) == text2.charAt(j)) {
                return 1 + solve(text1, text2, i - 1, j - 1);
            } else {
                return Math.max(solve(text1, text2, i - 1, j), solve(text1, text2, i, j - 1));
            }
        }
    }

    static class SolutionLC01 implements Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int[][] dp = new int[text1.length()][text2.length()];
            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }
            return solve(text1, text2, text1.length() - 1, text2.length() - 1, dp);
        }

        private int solve(String text1, String text2, int i, int j, int[][] dp) {
            if (i < 0 || j < 0) {
                return 0;
            }
            if (dp[i][j] != -1) {
                return dp[i][j];
            }
            if (text1.charAt(i) == text2.charAt(j)) {
                dp[i][j] = 1 + solve(text1, text2, i - 1, j - 1, dp);
            } else {
                dp[i][j] = Math.max(solve(text1, text2, i - 1, j, dp), solve(text1, text2, i, j - 1, dp));
            }
            return dp[i][j];
        }
    }

    static class SolutionLC01mod implements Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int[][] dp = new int[text1.length()][text2.length()];
            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }
            return solve(text1, text2, 0, 0, dp);
        }

        private int solve(String text1, String text2, int i, int j, int[][] dp) {
            if (i >= text1.length() || j >= text2.length()) {
                return 0;
            }
            if (dp[i][j] != -1) {
                return dp[i][j];
            }
            if (text1.charAt(i) == text2.charAt(j)) {
                dp[i][j] = 1 + solve(text1, text2, i + 1, j + 1, dp);
            } else {
                dp[i][j] = Math.max(solve(text1, text2, i + 1, j, dp), solve(text1, text2, i, j + 1, dp));
            }
            return dp[i][j];
        }
    }
    public  static  void  main(String[] args){
        Solution s = new Solution00();
        String t1 = "pmjghexybyrgzczy";
        String t2 = "hafcdqbgncrcbihkd";
        long st = System.nanoTime();
        s.longestCommonSubsequence(t1,t2);
        System.out.println(System.nanoTime()-st);
    }
}
