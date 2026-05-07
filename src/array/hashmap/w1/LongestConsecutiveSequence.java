package array.hashmap.w1;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num: nums){
            set.add(num);
        }

        int ans = 0;
        for (int n: set){
            if(!set.contains(n - 1)){
                int m = n + 1;
                while (set.contains(m)){
                    m++;
                }

                ans = Math.max(ans, m - n);
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        LongestConsecutiveSequence obj = new LongestConsecutiveSequence();

        System.out.println(obj.longestConsecutive(new int[]{100,4,200,1,3,2}));
        System.out.println(obj.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
        System.out.println(obj.longestConsecutive(new int[]{1,0,1,2}));
        System.out.println(obj.longestConsecutive(new int[]{1,2,6,7,8}));
    }
}


/*
 *
 * Approach: Traverse the array and store all numbers in hashset to remove duplicates and for faster lookups
 * Initialize answer as 0. Traverse set and check if n - 1 exists in set if yes it means it is not start of the sequence
 * if n - 1 doesn't exist in the set it means n is the start of sequence and then run a loop till a consecutive
 * element of n is present in set and at the end of loop calculate length of sequence as m - n where m is last element of sequence.
 * compare the current sequence length with so far best length and update the answer accordingly.
 *
 * TC : O(n)  n = length of nums array
 * SC: O(n)
 *
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 *
 */
