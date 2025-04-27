package implementations;

import java.util.Comparator;
import java.util.stream.IntStream;

public class lexordercomp {
    public static void main(String[] args){
        Comparator<Integer[]> lex = (a,b)->
                IntStream.range(0, Math.min(a.length, b.length))
                        .map(i -> a[i]-b[i]).filter(x->x!=0)
                        .findFirst().orElse(a.length-b.length);

        System.out.println(lex.compare(new Integer[] {0,1,1}, new Integer[] {1,1,1}));
        System.out.println(lex.compare(new Integer[] {1,1,1}, new Integer[] {1,0,1}));

        System.out.println(lex.compare(new Integer[] {1,1,1,1,1}, new Integer[] {1,1,1}));
    }
}
