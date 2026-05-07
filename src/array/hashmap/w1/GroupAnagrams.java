package array.hashmap.w1;

import java.util.ArrayList;
import java.util.List;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();

        ans.add(new ArrayList<>());
        ans.get(0).add(strs[0]);
        for(int i = 1; i < strs.length; i++){
            int size = ans.size();
            boolean found = false;
            for(int j = 0; j < size; j++){
                if(ans.get(j).getFirst().length() == strs[i].length() && isAnagram(ans.get(j).getFirst(), strs[i])){
                    ans.get(j).add(strs[i]);
                    found = true;
                    break;
                }
            }
            if(!found){
                ans.add(new ArrayList<>());
                ans.getLast().add(strs[i]);
            }

        }
        return ans;
    }

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
        GroupAnagrams obj = new GroupAnagrams();
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        System.out.println(obj.groupAnagrams(strs));
    }
}

/*
 *
 * Approach: Traverse through the words array, initialize found as false and check if the length of the current word is
 * equal to the first word in the bucket, and we will do this process for all the buckets/ groups of
 * anagrams we have so far and if the length is matching then we will check if the strings are anagrams
 * if yes we will add current word to the group and change found to true, else if after going through all anagram groups we did
 * not find any match then we will create a new bucket/group and keep the current word in it.
 *
 * TC : O(n*n*k)  n = length of words array, k = length of each word
 * SC: O(n*k)
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [[eat, tea, ate], [tan, nat], [bat]]
 *
 */
