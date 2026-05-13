package w1.twopointers;

import java.util.Arrays;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int left = 0;

        for (int right = 0; right < n; right++) {
            if(nums[right] != 0){
                if(left != right){
                    swap(nums,left,right);
                }
                left++;
            }

        }
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return;
    }

    public static void main(String[] args) {
        MoveZeroes obj = new MoveZeroes();
        int[] nums = new int[]{0,1,0,3,12};
        obj.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

        int[] nums1 = new int[]{0};
        obj.moveZeroes(nums1);
        System.out.println(Arrays.toString(nums1));
    }

}

/*
 *
 * Approach: Initialize two pointer left and right both pointing at index 0
 * Move right index from 0 all the way to n, where n = length of nums array
 * check if element at right index in a non-zero number if yes, swap elements at index left and right
 * and increment left index by 1
 *
 * TC : O(n)  n = length of array
 * SC: O(1)
 *
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 *
 */