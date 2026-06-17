package w6.recursionbacktracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        combinationSum(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }

    public void combinationSum(int[] candidates, int target, int start, List<Integer> curr, List<List<Integer>> ans) {
        if(target == 0){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if(candidates[i] <= target){
                curr.add(candidates[i]);
                combinationSum(candidates, target - candidates[i], i, curr, ans);
                curr.remove(curr.size() - 1);
            }
        }

    }

    public static void main(String[] args) {
        CombinationSum obj = new CombinationSum();

        System.out.println(obj.combinationSum(new int[]{2,3,6,7}, 7));
        System.out.println(obj.combinationSum(new int[]{2,3,5}, 8));
        System.out.println(obj.combinationSum(new int[]{2}, 1));
    }
}
