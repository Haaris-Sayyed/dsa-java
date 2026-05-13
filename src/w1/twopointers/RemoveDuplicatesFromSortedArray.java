package w1.twopointers;

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 1;

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i - 1]) {
                nums[i] = nums[j];
                i++;
            }
        }

        return i;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray obj = new RemoveDuplicatesFromSortedArray();

        System.out.println(obj.removeDuplicates(new int[]{1,1,2}));
        System.out.println(obj.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }
}

/*
*
* Approach: This approach employs the Two-Pointers technique to modify the array in-place.
* The pointer i acts as the "slow-runner" that tracks the boundary of the unique elements, while j is the "fast-runner" 
* that scans through the entire array. Since the input array is sorted, duplicates are guaranteed to be adjacent; 
* therefore, the algorithm compares the current element at j with the last unique element placed at i - 1. Whenever 
* a new unique value is encountered (nums[j] \neq nums[i-1]), it is moved to the position tracked by i, and i is incremented.
* By the end of the loop, the first i elements of the array contain the unique values in their original order, and 
* the function returns i as the new length.
*
* Time Complexity : O(n) n = length of array
* Space Complexity: O(1)
*
* Input: nums = [1,1,2]
* Output: 2  [1,2]
*
*
*/