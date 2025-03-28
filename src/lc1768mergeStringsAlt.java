public class lc1768mergeStringsAlt {    public String mergeAlternately(String word1, String word2) {
    int l1 = word1.length();
    int l2 = word2.length();
    String out = "";
    for(int i1=0; i1<l1; i1++){
        out+=word1.charAt(i1);
        if (i1<l2) {
            out+=word2.charAt(i1);
        }
    }
    if (l1<l2){
        for(int i2=l1; i2<l2; i2++){
            out+=word2.charAt(i2);
        }
    }
    return out;
}

}
