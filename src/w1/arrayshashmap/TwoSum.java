package w1.arrayshashmap;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            int rem = target - nums[i];
            if(map.containsKey(rem)){
                return new int[]{map.get(rem), i};
            }
            map.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        int[] arr = new int[]{2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(ts.twoSum(arr, target)));
    }

}

/*
*
* Approach: Single Pass using HashMap
* Traverse through the array and calculate the remaining component i.e rem = target - nums[i]
* Search this component in hashmap if we have this value present in map it implies we have the required pair
* return this pair indices.
* If this rem component is not present in map put the current number and its index in hashmap
*
* TC: O(n)
* SC: O(n)
*
* Input: [2, 7, 11, 15]
* Output: [0, 1]
*
* */