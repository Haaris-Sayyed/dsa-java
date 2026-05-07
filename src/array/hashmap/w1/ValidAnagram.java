package array.hashmap.w1;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] freq = new int[26];
        int n = s.length();
        for(int i = 0; i < n; i++){
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        for(int i = 0; i < 26; i++){
            if(freq[i] > 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        ValidAnagram obj = new ValidAnagram();
        String s = "anagram", t = "nagaram";
        System.out.println(obj.isAnagram(s, t));
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
