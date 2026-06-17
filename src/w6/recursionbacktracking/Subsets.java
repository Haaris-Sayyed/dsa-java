package w6.recursionbacktracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        subsets(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    public void subsets(int[] nums, int start, List<Integer> curr, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(curr));

        for(int i = start; i < nums.length; i++){
            curr.add(nums[i]);
            subsets(nums, i + 1,curr, ans);
            curr.remove(curr.size() - 1);
        }

    }

    public static void main(String[] args) {
        Subsets obj = new Subsets();

        System.out.println(obj.subsets(new int[]{1,2,3}));
        System.out.println(obj.subsets(new int[]{0}));
    }
}
