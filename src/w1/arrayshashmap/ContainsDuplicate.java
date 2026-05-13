package w1.arrayshashmap;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num: nums){
            if(map.containsKey(num)){
                return true;
            }
            map.put(num, 1);
        }
        return false;
    }

    public static void main(String[] args) {
        //int[] nums =
    }
}

/*
*
* Approach: Single Pass using HashMap
* Traverse the array and check if the current number from array already exists in hashmap
* if yes we can say array contains duplicate if no then we will store the current value in
* hashmap with count 1
*
* TC: O(n)
* SC: O(n)
*
* Input: [1,2,3,1]
* Output: true
*
*
*/
