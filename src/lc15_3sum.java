import java.util.*;
/*
Leetcode link:
https://leetcode.com/problems/3sum/description/
 */

/*
Pythoon solution:


from collections import Counter
class Solution:

    def threeSum(self, nums: List[int]) -> List[List[int]]:

        nums_set = set(nums)
        nums_sort = sorted(list(nums_set))
        nums_count = Counter(nums)
        triples = []
        for i,s in enumerate(nums_sort):
            if s>0:
                break
            if s==0:
                if nums_count[s]>=3:
                    triples.append([0,0,0])
                break
            if nums_count[s]>1 and -2*s in nums_set:
                triples.append([s,s,-2*s])
            if (-1*s)%2 == 0:
                j = int((-1*s)/2)
                if j in nums_set and nums_count[j]>1:
                    triples.append([s,j,j])

            for j in range(i+1, len(nums_sort)):
                s2 = nums_sort[j]
                if s+s2>0:
                    break
                s3 = -1*(s+s2)
                if s3>s2 and s3 in nums_set:
                    triples.append([s,s2,s3])
        return triples

Note this is not the best solution - there's a two pointer method that's more general
Implemented this in Java anyway to get used to more Java objects.
 */


public class lc15_3sum {
    public List<List<Integer>> threeSum(int[] nums) {

        //WOW COOL CAN'T DO THAT WITHOUT STREAMS AND BOXED!!!!!!
        //List<Integer> num_list = Arrays.asList(nums);
        HashMap<Integer, Integer> nums_freq = new HashMap<>();
        HashSet<Integer> nums_set = new HashSet<Integer>();
        ArrayList<Integer> nums_sort = new ArrayList<>();
        for (int num: nums){
            nums_freq.put(num,nums_freq.getOrDefault(num,0)+1);
            if (! nums_set.contains(num))
            {
                nums_set.add(num);
                nums_sort.add(num);
            }
        }

        //OH OKAY NEED *COLLECTIONS* TO SORT ARRAY LIST
        //And nums_sort.sort() is only if you provide comparator, no "default"
        Collections.sort(nums_sort);
        //to Array is just... object...
        //ArrayList<Integer> num_sort = nums_set.toArray();
        //Set can't be hash set
        //HashSet<Integer> nums_set = hm_freq.keySet();
        ArrayList<List<Integer>> triples = new ArrayList<>();

        //does not work as an output signature
        //ArrayList<ArrayList<Integer>> L = new ArrayList<>();

        for (int i = 0; i<nums_sort.size(); i++){
            int num =  nums_sort.get(i);
            if (num>0){
                break;
            }
            if (num==0){
                if (nums_freq.get(num)>=3){
                    Integer[] ans = {0,0,0};
                    triples.add(Arrays.asList(ans));
                    break;
                }
            }
            if (nums_freq.get(num)>1 && nums_freq.getOrDefault(-2*num,0)>0 && -2*num > num){
                Integer[] ans = {num, num, -2*num};
                triples.add(Arrays.asList(ans));
            }
            if (-1*num%2==0){
                int num_2 = -1*num/2;
                if (nums_freq.getOrDefault(num_2,0)>1 && num_2>num) {
                    Integer[] ans = {num, num_2, num_2};
                    triples.add(Arrays.asList(ans));
                }
            }
            for(int j = i+1; j<nums_sort.size(); j++){
                int num_j = nums_sort.get(j);
                if (num+num_j>0){
                    break;
                }
                int num_rem = -1*(num_j+num);
                if (num_rem == num_j || num_rem == num){
                    continue;
                }
                if (nums_freq.getOrDefault(num_rem,0)>=1 && num_rem>num_j){
                    //note; EASIER WAY TO DO THIS
                    //Arrays.asList(nums[i], nums[j], nums[k])
                    Integer[] ans = {num, num_j, num_rem};
                    triples.add(Arrays.asList(ans));
                }

            }

        }
        return triples;

    }

    public static void main(String[] args){
        lc15_3sum l = new lc15_3sum();
        //int[] nums = {-1,0,1,2,-1,-4};
        int[] nums = {-1,0,1,0};
        System.out.println(l.threeSum(nums).toString());

    }
}
