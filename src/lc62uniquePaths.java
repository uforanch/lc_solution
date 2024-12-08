public class lc62uniquePaths {
    static class Solution {
        public int recur(int r, int c, int[][] pathCount, int m, int n){
            if (r>m || c>n){return 0;}
            if (pathCount[r][c]>=0){return pathCount[r][c];}
            pathCount[r][c] = recur(r+1,c, pathCount, m, n)+recur(r,c+1, pathCount, m, n);
            return pathCount[r][c];
        }
        public int uniquePaths(int m, int n) {
            int[][] pathCount = new int[m][n];
            for(int i0=0; i0<m; i0++){
                for(int i1=0; i1<n; i1++){
                    if (i0<m-1 && i1<n-1){
                        pathCount[i0][i1]=-1;
                    }   else {
                        pathCount[i0][i1]=1;
                    }

                }
            }
            return recur(0,0,pathCount,m,n);
        }
    }
}
