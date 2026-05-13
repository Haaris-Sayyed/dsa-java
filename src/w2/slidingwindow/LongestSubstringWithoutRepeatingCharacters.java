package w2.slidingwindow;

import java.util.Arrays;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int[] charIndex = new int[128];
        Arrays.fill(charIndex, -1);

        int left = 0;
        for(int right = 0; right < n; right++){
            char currChar = s.charAt(right);
            if(charIndex[currChar] >= left){
                left = charIndex[currChar] + 1;
            }
            charIndex[currChar] = right;
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters obj = new LongestSubstringWithoutRepeatingCharacters();

        System.out.println(obj.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(obj.lengthOfLongestSubstring("bbbbb"));
        System.out.println(obj.lengthOfLongestSubstring("pwwkew"));
        System.out.println(obj.lengthOfLongestSubstring("aab"));
    }
}

/*
* Approach: The approach utilizes a Sliding Window technique optimized with a Hash Table (or frequency array) to
* identify the longest unique substring in a single pass. As the right pointer iterates through the string to expand
* the window, the algorithm tracks the last seen index of each character in an integer array; when a duplicate character
* is encountered that falls within the current window boundaries [charIndex[currChar] >= left], the left pointer "jumps" immediately to the index
* following the previous occurrence of that character [left = charIndex[currChar] + 1], effectively pruning the repeating element and all characters before it.
* This strategy ensures that the window always contains unique characters, and by calculating the distance between
* the two pointers [maxLength = right - left + 1] at each step the algorithm maintains a running maximum length
*
* Time Complexity: O(n) n = length of input string
* Space Complexity: O(1)
*
* Input: abcabcbb
* Output: 3
*
* */