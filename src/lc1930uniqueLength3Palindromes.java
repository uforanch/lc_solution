import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class lc1930uniqueLength3Palindromes {
    public int countPalindromicSubsequence(String s) {
        Map<Character, Integer> minIndex = new HashMap<>();
        Map<Character, Integer> maxIndex = new HashMap<>();
        int outNum = 0;
        //1.) get min, max index per character
        for(int i = 0; i < s.length(); i++){
            if (!minIndex.containsKey(s.charAt(i))){
                minIndex.put(s.charAt(i), i);
            }
            maxIndex.put(s.charAt(i), i);
        }
        //2.) count distinct between each using a set
        for(char c : minIndex.keySet()){
            Set<Character> cSet = new HashSet<>();
            for(int i = minIndex.get(c)+1; i<maxIndex.get(c); i++){
                cSet.add(s.charAt(i));
            }
            outNum += cSet.size();
        }
        return outNum;
    }

}
