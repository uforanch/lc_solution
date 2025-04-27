package implementations;
//https://medium.com/@kirti07arora/mastering-trie-data-structure-implementation-and-application-in-java-e7d371e5eafc
public class trie_implmentation_medium {
    static class TrieNode{
        public TrieNode[] children = new TrieNode[26];
        public boolean endOfWord = false;
        TrieNode() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }
    static class Trie{
        private TrieNode root;
        Trie(){
            root = new TrieNode();
        }
        public void insert(String s){
            TrieNode current = root;
            for(int i =0; i<s.length();i++){
                int index = s.charAt(i)-'a';
                if (current.children[index]==null)
                    current.children[index] = new TrieNode();
                current = current.children[index];
            }
            current.endOfWord=true;
        }
        public boolean search(String s){
            TrieNode current = root;
            for(int i =0; i<s.length();i++){
                int index = s.charAt(i)-'a';
                if (current.children[index]==null)
                    return false;
                current = current.children[index];
            }
            return (current != null && current.endOfWord);
        }
    }
}
