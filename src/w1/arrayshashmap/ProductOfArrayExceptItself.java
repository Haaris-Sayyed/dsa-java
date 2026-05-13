package w1.arrayshashmap;

import java.util.Arrays;

public class ProductOfArrayExceptItself {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n + 1];
        int[] suffix = new int[n + 1];

        Arrays.fill(prefix, 1);
        Arrays.fill(suffix, 1);

        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        for (int i = n - 1; i >= 0 ; i--) {
            suffix[i] = nums[i] * suffix[i + 1];
        }

        int[] answer = new int[n];

        for (int i = 1; i <= n; i++) {
            answer[i - 1] = prefix[i - 1] * suffix[i];
        }
        return answer;
    }

    public int[] productExceptSelfConstantSpace(int[] nums) {
        int n = nums.length;
        int prefix = 1;
        int suffix = 1;
        int[] ans = new int[n];

        for(int i = 0; i < n; i++){
            ans[i] = prefix;
            prefix = prefix * nums[i];
        }

        for(int i = n - 1; i >= 0; i--){
            ans[i] = ans[i] * suffix;
            suffix = suffix * nums[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptItself obj = new ProductOfArrayExceptItself();

        System.out.println(Arrays.toString(obj.productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(obj.productExceptSelf(new int[]{-1,1,0,-3,3})));

        System.out.println(Arrays.toString(obj.productExceptSelfConstantSpace(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(obj.productExceptSelfConstantSpace(new int[]{-1,1,0,-3,3})));
    }

}

/*
 *
 * Constant space Approach: Store the prefix of each index in answer array. Initialize suffix = 1 and calculate
 * suffix of every index while traversing back and multiply suffix with current answer to get required result.
 *
 * TC : O(n)  n = length of array
 * SC: O(1)
 *
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 *
 */