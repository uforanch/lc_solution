public class lc6zigzzag {
    public String convert(String s, int numRows) {
        if (numRows==1){
            return s;
        }
        String[] rowArr = new String[numRows];
        int dir =1;
        int rowPtr = 0;
        for(int i = 0; i<numRows; i++){
            rowArr[i] = "";
        }
        for(int i=0; i<s.length(); i++){
            rowArr[rowPtr] += s.charAt(i);
            if (rowPtr==numRows-1 & dir==1){
                dir = -1;
            } else if (rowPtr==0 & dir==-1){
                dir = 1;
            }
            rowPtr+=dir;
        }
        String out = "";
        for (int i = 0; i<numRows; i++){
            out+=rowArr[i];
        }
        return out;
    }
}
