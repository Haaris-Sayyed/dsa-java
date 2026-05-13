package w2.slidingwindow;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        int n = s.length();
        int left = 0, maxCount = 0;
        Map<Character, Integer> freq = new HashMap<>();
        int maxLength = 0;
        for(int right = 0; right < n; right++){
            char currChar = s.charAt(right);
            freq.put(currChar, freq.getOrDefault(currChar, 0) + 1);
            maxCount = Math.max(maxCount, freq.get(currChar));

            while(right - left + 1 - maxCount > k){
                freq.put(s.charAt(left), freq.get(s.charAt(left)) - 1);
                left++;
                maxCount = freq.values().stream().max(Comparator.naturalOrder()).get();
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement obj = new LongestRepeatingCharacterReplacement();

        System.out.println(obj.characterReplacement("ABAB", 2));
        System.out.println(obj.characterReplacement("AABABBA", 1));

    }
}

/*
 * Approach: This approach uses a Sliding Window with a frequency map to find the longest substring that can be transformed
 * into a single repeating character using at most $k$ replacements. As the right pointer expands the window, the algorithm
 * tracks the frequency of each character and maintains maxCount, which represents the count of the most frequent character
 * currently in the window. The core logic relies on the observation that the number of replacements needed to make every
 * character in the window identical is the total window size minus the frequency of the most popular character
 * [windowSize - maxCount]. If this value exceeds k, the window is no longer valid, prompting the left pointer to contract
 * the window and update character frequencies until the replacement constraint is once again satisfied.
 * Throughout this process, the algorithm records the largest valid window size encountered, ultimately returning
 * it as the maximum length.
 *
 * Time Complexity: O(n) n = length of input string
 * Space Complexity: O(k) k = number of unique characters in string
 *
 * Input: ABAB
 * Output: 4
 *
 */
