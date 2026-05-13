package w2.prefixsum;

import java.util.Arrays;

public class RangeSumQueryImmutable {

    private int[] prefixSum;

    public RangeSumQueryImmutable(int[] nums){
        int n = nums.length;
        prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return prefixSum[right + 1] - prefixSum[left];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        RangeSumQueryImmutable obj = new RangeSumQueryImmutable(nums);
        System.out.println(obj.sumRange(0,2));
        System.out.println(obj.sumRange(2,5));
        System.out.println(obj.sumRange(0,5));
    }
}

/*
*
* Approach: Instead of doing the range-sum calculation for each left, right pair and making the complexity O(n*n)
*       we calculate prefix sum for each index and store it in array.
*       Everytime we query for a range sum [left,right] we can obtain this value via a mathematical equation
*       RangeSum(left, right) = prefixSum[right + 1] - prefixSum[left]
*
* Time Complexity: O(n) n = length of array
* Space Complexity: O(n)
*
* Input: nums = [-2, 0, 3, -5, 2, -1], left = 2, right = 5
* Output: -1
*
*/