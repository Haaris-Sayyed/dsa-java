package w1.twopointers;

import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k){
                int total = nums[i] + nums[j] + nums[k];
                if(total > 0){
                    k--;
                }else if(total < 0){
                    j++;
                }else{
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;

                    while (nums[j] == nums[j - 1] && j < k){
                        j++;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ThreeSum obj = new ThreeSum();
        System.out.println(obj.threeSum(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(obj.threeSum(new int[]{0,0,0}));
        System.out.println(obj.threeSum(new int[]{}));
    }

}

/*
 *
 * Approach: Sort the given nums array
 * Traverse array using a pointer i (i = 0 -> n)
 * if i > 0 check if nums[i] == nums[i - 1] then increment i pointer to avoid duplicate triplets
 * then initialize two pointers j = i + 1 and k = nums.length - 1
 * while j < k we will traverse this subarray and consider every i, j , k pair and check if
 * nums[i] + nums[j] + nums[k] > 0 if yes decrement k
 * otherwise increment j and if nums[i] + nums[j] + nums[k] = 0 then (i,j,k) is our one of the required triplet
 * add this to our answer array
 * then increment j pointer and check if nums[j] == nums[j - 1] increment j pointer till j < k to avoid duplicates.
 *
 * TC : O(n*n)  n = length of array
 * SC: O(1)
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 *
 */