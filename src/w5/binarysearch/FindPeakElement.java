package w5.binarysearch;

public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int ans = 0;
        while(start < end){
            int mid = start + (end - start) / 2;
            if(mid + 1 < nums.length && nums[mid] > nums[mid + 1]) end = mid;
            else start = mid + 1;
        }
        return start;
    }

    public static void main(String[] args) {

        FindPeakElement obj = new FindPeakElement();

        System.out.println(obj.findPeakElement(new int[]{1,2,3,1}));
        System.out.println(obj.findPeakElement(new int[]{1,2,1,3,5,6,4}));
    }
}
