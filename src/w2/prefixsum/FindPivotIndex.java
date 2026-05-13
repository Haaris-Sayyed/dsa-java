package w2.prefixsum;

import java.util.Arrays;

public class FindPivotIndex {

    public int pivotIndex(int[] nums) {
         int n = nums.length;
         int[] prefixSum = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        for (int i = 0; i < n; i++) {
            if(prefixSum[i] == prefixSum[n] - prefixSum[i + 1]) return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        FindPivotIndex obj = new FindPivotIndex();
        System.out.println(obj.pivotIndex(new int[]{1,7,3,6,5,6}));
        System.out.println(obj.pivotIndex(new int[]{1,2,3}));
        System.out.println(obj.pivotIndex(new int[]{2,1,-1}));
    }
}

/*
* 
* Approach: This approach utilizes a Prefix Sum Array to efficiently calculate and compare the sums of elements to the left 
* and right of every possible pivot index. First, you construct an auxiliary array, prefixSum, where each index i stores 
* the sum of all elements before it, such that the total sum of the entire array is captured at prefixSum[n]. 
* During the second pass, for any index i, the sum of elements to its left is simply prefixSum[i], 
* while the sum of elements to its right is derived by subtracting the prefix sum up to the current element (including itself) 
* from the total sum: totalSum - prefixSum[i + 1]. By iterating through the array and returning the first index where 
* these two values are equal, you identify the leftmost pivot point.
* 
* Time Complexity: O(n) n = length of array
* Space Complexity: O(n)
* 
* Input: nums = [1,7,3,6,5,6]
* Output: 3
* 
*/