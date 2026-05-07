package twopointers.w1;

import java.util.Arrays;

public class TwoSumII {

    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;

        while(left < right){
            if(numbers[left] + numbers[right] > target){
                right--;
            }else if(numbers[left] + numbers[right] < target){
                left++;
            }else{
                return new int[]{left + 1, right + 1};
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        TwoSumII obj = new TwoSumII();

        System.out.println(Arrays.toString(obj.twoSum(new int[]{2,7,11,15}, 9)));
        System.out.println(Arrays.toString(obj.twoSum(new int[]{2,3,4}, 6)));
        System.out.println(Arrays.toString(obj.twoSum(new int[]{-1,0}, -1)));
    }
}

/*
 *
 * Approach: Initialize two pointers left = 0, right = nums.length - 1
 * Since the nums array is sorted in ascending order we will check if
 * nums[left] + nums[right] > target => decrement right pointer
 * nums[left] + nums[right] < target => increment left pointer
 * otherwise left and right indices are our solution
 * continue above steps till we don't reach mid of nums array
 *
 * TC : O(n)  n = length of array
 * SC: O(1)
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [1,2]
 *
 */