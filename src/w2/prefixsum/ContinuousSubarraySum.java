package w2.prefixsum;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum+= nums[i];
            if(map.containsKey(sum % k)){
                if(i - map.get(sum % k) >= 2) return true;
            }else{
                map.put(sum % k, i);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ContinuousSubarraySum obj = new ContinuousSubarraySum();

        System.out.println(obj.checkSubarraySum(new int[]{23,2,4,6,7}, 6));
        System.out.println(obj.checkSubarraySum(new int[]{23,2,6,4,7}, 13));
    }
}

/*
* 
* Approach: This approach utilizes Prefix Sums and Modular Arithmetic to determine if a subarray of at least two elements 
* sums to a multiple of k. The algorithm tracks the running prefix sum modulo k (the remainder) and stores the first 
* occurrence of each remainder in a hash map. If the same remainder appears again at a later index, it implies that the sum 
* of the elements between those two indices is a multiple of k, because (S_j - S_i) mod k = 0 if S_j mod k = S_i mod k. 
* To satisfy the constraint of the subarray length being at least two, the code checks if the difference between
* the current index and the stored index is greater than or equal to 2.
* The map is initialized with (0, -1) to account for subarrays starting from index 0 that are multiples of k themselves.
* 
* Time Complexity: O(n) n = length of array
* Space Complexity: O(n)
* 
* Input: nums = [23,2,4,6,7] , k = 6
* Output: true
*
*/