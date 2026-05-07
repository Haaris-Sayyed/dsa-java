package array.hashmap.w1;

import java.util.*;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num: nums){
            freq.put(num,freq.getOrDefault(num,0) + 1);
        }

        List<Integer>[] buckets = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            buckets[i] = new ArrayList<>();
        }

        for(int key: freq.keySet()){
            buckets[freq.get(key)].add(key);
        }

        int[] res = new int[k];
        int idx = 0;
        for (int i = buckets.length - 1; i >= 0; i--) {
            for (int j = 0; j < buckets[i].size() && k > 0; j++) {
             res[idx++] = buckets[i].get(j);
             k--;
            }
        }

        return res;
    }

    public static void main(String[] args) {

        TopKFrequentElements obj = new TopKFrequentElements();

        System.out.println(Arrays.toString(obj.topKFrequent(new int[]{1,2,1,2,1,2,3,1,3,2},2)));

        System.out.println(Arrays.toString(obj.topKFrequent(new int[]{1},1)));
    }
}


/*
 *
 * Approach: Traverse through the array and store frequency of each element in a map
 * Initialize an array of list named buckets which represents an array where each index stores list of
 * elements whose frequency is equal to that index
 * Initialize a result array and traverse from the end of buckets list and as soon as we find a non-empty bucket
 * store all the elements in that bucket in result array till we have exactly k elements in result
 *
 *
 * TC : O(n)  n = length of array
 * SC: O(n)
 *
 * Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2
 * Output: [1, 2]
 *
 */