import java.util.*;
/*
Leetcode link:
https://leetcode.com/problems/word-break-ii/description/
 */

/*
Python solution

class TrieNode:
    def __init__(self, c):
        self.char = c
        self.edges = dict()

def traverse_trie(s,node):
    #print("(", s,node,":")
    if len(s)==0 and " " in node.edges.keys():
        #print([""], ")")
        return [""]
    elif len(s)==0:
        #print([], ")")
        return []
    output_list = []
    if s[0] in node.edges.keys():
        output_list += list(map(lambda x : s[0]+x, traverse_trie(s[1:], node.edges[s[0]])))
    if " " in node.edges.keys():
        output_list += list(map(lambda x : " "+x, traverse_trie(s, node.edges[" "])))
    #print(output_list)
    return output_list


class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> List[str]:
        root_node = TrieNode("")
        for w in wordDict:
            cur_node = root_node
            for c in w:
                if c in cur_node.edges.keys():
                    cur_node = cur_node.edges[c]
                else:
                    next_node = TrieNode(c)
                    cur_node.edges[c]=next_node
                    cur_node = next_node
            cur_node.edges[" "]=root_node
        output = traverse_trie(s,root_node)
        return output


 */


public class lc140_wordbreakii {
    public class TrieNode {
        private char c;
        public HashMap<Character,TrieNode> edges;
        TrieNode(char c){
            //improve later with getters and setters
            this.c = c; // basically an id, not used
            this.edges = new HashMap<>();
        }
    }
    public class Trie {
        public TrieNode root;
        Trie(){
            this.root = new TrieNode(' ');
        }

        Trie(List<String> s_arr){
            this.root = new TrieNode(' ');
            for(String s:s_arr){
                this.Add(s);
            }
        }

        public void Add(String s){
            TrieNode cur = root;
            for (char c: s.toCharArray()){
                if (cur.edges.containsKey(c)) {
                    cur = cur.edges.get(c);
                } else {
                    cur.edges.put(c, new TrieNode(c));
                    cur = cur.edges.get(c);
                }
            }
            cur.edges.put(' ', root);
        }

        public List<String> Traverse(String s){
            return recurTraverse(s.toCharArray(), 0, root);
        }

        private List<String> recurTraverse(char[] c_arr, int pos, TrieNode cur){
            int rem = c_arr.length - pos;
            if (rem==0 && cur.edges.containsKey(' ')){
                return Arrays.asList("");
            } else if (rem==0){
                return Arrays.asList();
            }
            /* wow ths part's going to get complicated without python
            or even C#'s linq system */
            ArrayList<String> out = new ArrayList<>();
            char next_char = c_arr[pos];
            if (cur.edges.containsKey(next_char)){
                List<String> next_char_trav = recurTraverse(c_arr, pos+1, cur.edges.get(next_char));
                for (String s: next_char_trav){
                    out.add(next_char + s);
                }
            }
            if (cur.edges.containsKey(' ')){
                List<String> next_char_trav = recurTraverse(c_arr, pos, cur.edges.get(' '));
                for (String s: next_char_trav){
                    out.add(" " + s);
                }
            }
            return out;
        }

    }

    public List<String> wordBreak(String s, List<String> wordDict) {

        Trie t = new Trie(wordDict);
        return t.Traverse(s);
    }
    public static void main(String[] args){
        lc140_wordbreakii l = new lc140_wordbreakii();
        List<String> word_dict = Arrays.asList("cat","cats","and","sand","dog");
        String s = "catsanddog";
        System.out.println(l.wordBreak(s, word_dict));
    }
}
