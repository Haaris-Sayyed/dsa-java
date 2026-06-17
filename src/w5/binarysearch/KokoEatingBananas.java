package w5.binarysearch;

import java.util.Arrays;

public class KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = Arrays.stream(piles).max().getAsInt();

        while (start < end){
            int mid = start + (end - start) / 2;
            if(hoursRequired(piles, mid) > h){
                start = mid + 1;
            }else {
                end = mid;
            }
        }
        return start;

    }

    public int hoursRequired(int[] piles, int speed){
        int timeTaken = 0;
        for(int pile: piles){
            timeTaken += pile / speed;
            timeTaken += pile % speed > 0 ? 1 : 0;
        }
        return timeTaken;
    }

    public static void main(String[] args) {
        KokoEatingBananas obj = new KokoEatingBananas();

        System.out.println(obj.minEatingSpeed(new int[]{3,6,7,11}, 8));
        System.out.println(obj.minEatingSpeed(new int[]{30,11,23,4,20}, 5));
        System.out.println(obj.minEatingSpeed(new int[]{30,11,23,4,20}, 6));

    }
}
