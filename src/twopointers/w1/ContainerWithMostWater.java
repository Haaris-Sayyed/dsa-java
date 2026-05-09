package twopointers.w1;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
       int n = height.length;
       int left = 0;
       int right = n - 1;
       int ans = Integer.MIN_VALUE;

       while (left < right){
           int length = right - left;
           int breadth = Math.min(height[left], height[right]);

           ans = Math.max(ans, length * breadth);
           if(height[left] < height[right]) left++;
           else if(height[left] > height[right]) right--;
           else{
               left++;
               right--;
           }
       }
       return ans;
    }

    public static void main(String[] args) {
        ContainerWithMostWater obj = new ContainerWithMostWater();

        System.out.println(obj.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(obj.maxArea(new int[]{1,1}));
    }
}


/*
 *
 * Approach: Initialize two pointers left = 0 and right = n - 1 where n = length of height array
 * length of container will be right - left and breadth will be the minimum of two heights at index left and right
 * calculate area by multiplying length and breadth and compare if with max area found so far and update accordingly
 * now check if height at index left is less than height at index right then increment left pointer
 * else if height at index left is more than height at index right then decrement right pointer
 * else if height at both index is same then move both the pointers
 * repeat above steps till left pointer doesn't cross right pointer
 *
 * TC : O(n)  n = length of array
 * SC: O(1)
 *
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 *
 */