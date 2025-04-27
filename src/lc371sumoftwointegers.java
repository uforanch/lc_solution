public class lc371sumoftwointegers {
    //none of the pain from python needed here
    //just works
    class Solution {
        public int getSum(int a, int b) {
            while(b!=0){
                int carry = (a&b)<<1;
                a=a^b;
                b=carry;
            }
            return a;

        }
    }

    public static void main(String[] args){
        int a=2;
        int b=-2;

        System.out.println(Integer.toBinaryString(2));
        System.out.println(Integer.toBinaryString(-2));
    }
}
