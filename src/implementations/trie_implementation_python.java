package implementations;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class trie_implementation_python {
    static class TrieNode {
        private Optional<Character> val;
        private Map<Character, TrieNode> children;

        public TrieNode(Optional<Character> val){
            this.val = val;
            this.children = new HashMap<>();
        }
        public void insert(String s){
            if (s.length()==0){
                return;
            }
            int start_index = 0;
            if (!val.isEmpty()){
                if (!s.startsWith(String.valueOf(val.get()))){
                    return;
                }
                start_index+=1;
            }
            if (s.length()==start_index){
                return;
            }
            char next_char = s.charAt(start_index);
            TrieNode next_node = null;
            if (children.get(next_char)==null){
                next_node = new  TrieNode(Optional.of(next_char));
                children.put(next_char, next_node);
            } else {
                next_node = children.get(next_char);
            }

            next_node.insert(s.substring(start_index));


        }

    }
}
