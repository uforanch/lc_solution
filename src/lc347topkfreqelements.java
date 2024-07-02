/*
Leetcode link:
https://leetcode.com/problems/top-k-frequent-elements/description/
 */

/*
from queue import PriorityQueue
from collections import Counter
from dataclasses import dataclass, field
from typing import Any

@dataclass(order=True, init=True)
class PriorityItem:
    priority: int
    item: Any = field(compare=False)


class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        num_counts = Counter(nums)
        pq = PriorityQueue()
        top_k_freq_list = []
        for num, freq in num_counts.items():
            pq.put(PriorityItem(priority=-1*freq, item=num))
        for i in range(k):
            #garunteed we can do this
            p_item = pq.get(timeout=1)
            top_k_freq_list.append(p_item.item)
        return top_k_freq_list

    def topKFrequent_original(self, nums: List[int], k: int) -> List[int]:
        num_freq_dict = dict()
        for n in nums:
            if n not in num_freq_dict.keys():
                num_freq_dict[n] = 1
            else:
                num_freq_dict[n] += 1
        freq_bucket_dict = dict()
        for kk, f in num_freq_dict.items():
            if f not in freq_bucket_dict.keys():
                freq_bucket_dict[f] = [kk]
            else:
                freq_bucket_dict[f].append(kk)
        f_list = sorted(freq_bucket_dict.keys())
        out_list = []
        out_list_len = 0
        while len(out_list) < k:
            f = f_list.pop()
            k_list = freq_bucket_dict[f]
            for kk in k_list:
                out_list.insert(0,kk)
                out_list_len += 1
                if out_list_len == k:
                    return out_list

        return out_list


 */

import java.util.*;
import java.util.function.BiFunction;

class lc347kopkfrequelements {
    public boolean compare(Map.Entry<Integer, Integer> x, Map.Entry<Integer, Integer> y)
    {
        return x.getValue() > y.getValue();
    }

    /* solution paraphrase from leetcode solutions */
    public int[] topKFrequent_LC_bucket(int[] nums, int k){

        //so here we make a List of Integer[]
        List<Integer>[] bucket = new List[nums.length+1];
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num: nums){
            freq.put(num, freq.getOrDefault(num, 0)+1);
        }

        for (int key: freq.keySet()){
            int count = freq.get(key);
            //so any type can be null
            // and uninitialized is null
            if (bucket[count] == null) {
                // type inference  here, hm
                bucket[count] = new ArrayList<>();
            }
            bucket[count].add(key);
        }

        int[] ans = new int[k];
        int pos=0;
        //start from last bucket
        for (int i = bucket.length-1; i>=0; i--){
            //if bucket
            if (bucket[i] != null) {
                // arraylist uses size()
                // can have MULTIPLE conditions!
                for (int j = 0; j< bucket[i].size() && pos <k; j++) {
                    //pos is which array thing we map TO
                    //j is where we map FROM
                    ans[pos] = bucket[i].get(j);
                    pos++;
                }
            }
        }

        return ans;
    }

    public int[] topKFrequentPQ(int[] nums, int k) {
        /* My own solution based on my python solution*/
        int[] out = new int[k];
        HashMap<Integer, Integer> map_q = new HashMap<>();
        for(int n : nums){
            int val = map_q.getOrDefault(n,0) - 1;
            map_q.put(n,val);
        }
        Comparator c = Map.Entry.comparingByValue();
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(c);
        for (Map.Entry<Integer, Integer> entry: map_q.entrySet()){
            pq.add(entry);
        }

        for (int i = 0; i<k;i++){
            out[i] = pq.poll().getKey();
        }

        return out;
    }

    /* another solution adapted from a leetcode solution */
    /*
    Got me really confused, asked about it on subreddit

    https://www.reddit.com/r/learnjava/comments/1dp7iz3/why_does_a_lambda_work_as_a_comparator/
     */
    public List<Integer> topKFrequent_LC_PQ(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        // functional interface
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
                new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeap.add(entry);
        }

        List<Integer> res = new ArrayList<>();
        while (res.size() < k) {
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            res.add(entry.getKey());
        }
        return res;
    }

    public static void main(String[] args){
        lc347kopkfrequelements s = new lc347kopkfrequelements();
        int[] nums = {4,1,-1,2,-1,2,3};
        int k = 2;
        System.out.println(s.topKFrequent_LC_PQ(nums, k).toString());
    }

}
