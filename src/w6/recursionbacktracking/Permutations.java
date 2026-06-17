package w6.recursionbacktracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        permute(nums, new ArrayList<>(), ans);
        return ans;
    }

    public void permute(int[] nums, List<Integer> curr, List<List<Integer>> ans) {
        if(curr.size() == nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(!curr.contains(nums[i])){
                curr.add(nums[i]);
                permute(nums, curr, ans);
                curr.remove(curr.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Permutations obj = new Permutations();

        System.out.println(obj.permute(new int[]{1,2,3}));
        System.out.println(obj.permute(new int[]{0,1}));
        System.out.println(obj.permute(new int[]{1}));
    }

}
