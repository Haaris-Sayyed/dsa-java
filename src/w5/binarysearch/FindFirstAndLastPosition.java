package w5.binarysearch;

import java.util.Arrays;

public class FindFirstAndLastPosition {

    public int[] searchRange(int[] nums, int target) {
        return new int[]{
                searchIndex(nums, target, true),
                searchIndex(nums, target, false)
        };
    }

    public int searchIndex(int[] nums, int target, boolean findFirstIndex){
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;
        while (start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                ans = mid;
                if(findFirstIndex){
                    end = mid - 1;
                } else{
                    start = mid + 1;
                }
            }else if(nums[mid] > target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FindFirstAndLastPosition obj = new FindFirstAndLastPosition();

        System.out.println(Arrays.toString(obj.searchRange(new int[]{5,7,7,8,8,10}, 8)));
        System.out.println(Arrays.toString(obj.searchRange(new int[]{5,7,7,8,8,10}, 6)));
        System.out.println(Arrays.toString(obj.searchRange(new int[]{}, 0)));
    }
}
