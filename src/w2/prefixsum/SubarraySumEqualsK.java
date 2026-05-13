package w2.prefixsum;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        int currSum = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            count += map.getOrDefault(currSum - k, 0);
            map.put(currSum, map.getOrDefault(currSum,0) + 1);
        }

        return count;

    }

    public static void main(String[] args) {
        SubarraySumEqualsK obj = new SubarraySumEqualsK();
        System.out.println(obj.subarraySum(new int[]{1,1,1},2));
        System.out.println(obj.subarraySum(new int[]{1,2,3},3));
    }
}

/*
 * Approach: This approach uses the Prefix Sum technique combined with a Hash Map to find the number of
 * subarrays that sum to k in linear time. As you iterate through the array, you maintain a running total (currSum) and
 * store the frequency of each prefix sum encountered so far in a map. The core logic relies on the mathematical observation
 * that if the difference between the current prefix sum and a previously seen prefix sum equals k = currSum - previousSum then
 * the elements between those two points must sum to k. By checking the map for the value currSum - k, you can instantly determine
 * how many times that specific "starting" sum has occurred, allowing you to increment the count by that frequency.
 * The map is initialized with (0, 1) to handle cases where a subarray starting from the very first element sums exactly
 * to k.
 *
 * Time Complexity: O(n) n = length of array
 * Space Complexity: O(n)
 *
 * Input: nums = [1,1,1] , k = 2
 * Output: 2
 *
 */
