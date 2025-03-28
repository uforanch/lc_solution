import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class lc3493propertiesgraph {

    static class Solution {
        public int intersect(Set<Integer> a, Set<Integer> b){
        /*
        cannot do ANY of this on a single line, not even the constructor.
        */
            Set<Integer> s = new HashSet<Integer>(a);
            s.retainAll(b);
            return s.size();
        }

        public int numberOfComponents(int[][] properties, int k) {
            int p_l = properties.length;
            Set<Integer>[] p = new Set[p_l];
            int[] components = new int[p_l];
            int comp_num = 0;
            //bfs/dfs
            Queue<Integer> v_q = new LinkedList<>();
            for(int i=0; i<p_l; i++){
                p[i] = new HashSet<>();
                for(int i1=0;i1<properties[i].length; i1++){
                    p[i].add(properties[i][i1]);
                }
            }
            for(int i=0; i<p_l; i++){
                if (components[i]!=0){
                    continue;
                }
                comp_num++;
                components[i]=comp_num;
                v_q.offer(i);
                while (!v_q.isEmpty()){
                    int n = v_q.poll();
                    for (int i1=0; i1<p_l; i1++){
                        if(i1==n || components[i1]!=0 || intersect(p[n], p[i1])<k){
                            continue;
                        }
                        components[i1]=components[n];
                        v_q.offer(i1);
                    }

                }

            }
            return comp_num;
        }
    }
    public static void main(String[] args){
        int[][] properties = {{1,2}, {1,1}, {3,4}, {4,5}, {5,6}, {7,7}};
        int k = 1;
        Solution s = new Solution();
        s.numberOfComponents(properties, k);
    }
}
