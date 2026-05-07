package array.hashmap.w1;

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

    public static void main(String[] args) {
        ProductOfArrayExceptItself obj = new ProductOfArrayExceptItself();

        System.out.println(Arrays.toString(obj.productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(obj.productExceptSelf(new int[]{-1,1,0,-3,3})));
    }

}

/*
 *
 * Approach: We can use an integer array freq of length 26 to keep track of the frequency of each letter in the two strings.
 * We first check if the length of both strings is the same. If not, we return false because anagrams must have the same length.
 * We loop through each character in both strings and increment the frequency of the corresponding letter in s
 * and decrement the frequency of the corresponding letter in t.
 * Finally, we loop through the freq array and check if all frequencies are zero.
 * If not, we return false. If all frequencies are zero, we return true because both
 * strings are anagrams of each other.
 *
 * TC : O(n)  n = length of string
 * SC: O(1)
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 *
 */