package w2.slidingwindow;

import java.util.Arrays;

public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        if(n1 > n2) return false;

        int[] s1Counts = new int[26];
        int[] s2Counts = new int[26];

        for (int i = 0; i < n1; i++) {
            s1Counts[s1.charAt(i) - 'a']++;
            s2Counts[s2.charAt(i) - 'a']++;
        }

        if(Arrays.equals(s1Counts, s2Counts)) return true;

        for (int i = n1; i < n2; i++) {
            s2Counts[s2.charAt(i) - 'a']++;
            s2Counts[s2.charAt(i - n1) - 'a']--;
            if(Arrays.equals(s1Counts, s2Counts)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        PermutationInString obj = new PermutationInString();

        System.out.println(obj.checkInclusion("ab","eidbaooo"));
        System.out.println(obj.checkInclusion("ab","eidboaoo"));
    }
}

/*
 * Approach: The approach employs a Fixed-Size Sliding Window to identify a permutation by comparing character frequencies
 * rather than sorting or generating all possible string combinations. The core idea is that any permutation of s1 must have
 * the exact same character counts and length as s1 itself. The algorithm initializes two frequency arrays of size 26—one
 * for the target string s1 and one for the initial window of s2. As the window slides across s2 character by character,
 * it maintains a "rolling" count by adding the new character entering the right side and removing the character exiting
 * the left. By checking for equality between these frequency arrays at each shift, the algorithm can detect a permutation
 * in linear time, ensuring that the space remains constant regardless of the input size.
 *
 * Time Complexity: O(n2) n2 = length of input string s2
 * Space Complexity: O(1)
 *
 * Input: s1 = "ab" s2 = "eidbaooo"
 * Output: true
 *
 */