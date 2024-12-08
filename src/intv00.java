
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
public class intv00 {



    public static int findTotalWeight(List<Integer> products) {    // Write your code here
        Map<Integer, Integer> weightToIndexMap = new HashMap<>();
        List<Integer> sortedProducts = new ArrayList();
        for (int i=0; i < products.size(); i++){
            int w = products.get(i);
            sortedProducts.add(w);
            weightToIndexMap.put(w, i);
        }

        Collections.sort(sortedProducts);


        boolean[] collected = new boolean[products.size()];
        Arrays.fill(collected, false);
        int remaining = products.size();
        int currentSortedIndex = 0;
        int totalWeight=0;
        while(remaining > 0 ){
            //System.out.print(remaining);
            //System.out.print(":");

            //System.out.println(currentSortedIndex);

            int weight = sortedProducts.get(currentSortedIndex);


            int takingIndex = weightToIndexMap.get(weight);
            System.out.println(weight + " : " + takingIndex + " : " + currentSortedIndex);
            if (collected[takingIndex]){
                currentSortedIndex+=1;
                continue;
            }
            System.out.println(weight);
            totalWeight+=weight;
            collected[takingIndex]=true;
            remaining-=1;
            if (takingIndex!=0){
                collected[takingIndex-1]=true;
                remaining-=1;
            }
            if (takingIndex!=collected.length-1)
            {
                collected[takingIndex+1]=true;
                remaining-=1;
            }

        }
        return totalWeight;


    }
    public static void main(String[] args){
            intv00 i = new intv00();
            int[] x = {8,132,45,65,765,345,243,75};
            List<Integer> as = new ArrayList<>();
            for (int xx: x){
                as.add(xx);
            }
            System.out.println(intv00.findTotalWeight(as));
    }
    }
