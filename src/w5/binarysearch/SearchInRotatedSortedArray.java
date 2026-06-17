package w5.binarysearch;

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        int firstHalfResult = binarySearch(nums, 0, pivot, target);
        return firstHalfResult == -1 ? binarySearch(nums, pivot + 1, nums.length - 1, target) : firstHalfResult;
    }

    public int findPivot(int[] nums){
        int start = 0;
        int end = nums.length - 1;

        while (start < end){
            int mid = start + (end - start) / 2;
            if(mid + 1 <= end && nums[mid] > nums[mid + 1]){
                return mid;
            }
            if(mid - 1 >= start && nums[mid - 1] > nums[mid]){
                return mid - 1;
            }
            if(nums[start] < nums[mid]){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }

    public int binarySearch(int[] nums, int start, int end, int target){
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) return mid;
            if(nums[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        return -1;
    }


    public static void main(String[] args) {
        SearchInRotatedSortedArray obj = new SearchInRotatedSortedArray();

        System.out.println(obj.search(new int[]{4,5,6,7,0,1,2}, 0));
        System.out.println(obj.search(new int[]{4,5,6,7,0,1,2}, 3));
        System.out.println(obj.search(new int[]{1}, 0));
    }
}
