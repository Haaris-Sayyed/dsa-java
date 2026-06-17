package w5.binarysearch;

public class BinarySearch {

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch obj = new BinarySearch();

        System.out.println(obj.search(new int[]{-1,0,3,5,9,12}, 9));
        System.out.println(obj.search(new int[]{-1,0,3,5,9,12}, 2));

    }
}
