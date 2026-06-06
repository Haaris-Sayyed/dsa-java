package w4.stack;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class CarFleet {

    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars  = new int[n][2];

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> b[0] - a[0]);

        Stack<Double> stack = new Stack<>();

        for (int[] car: cars){
            double timeTaken = (double) (target - car[0]) / car[1];
            if(stack.isEmpty() || timeTaken > stack.peek()){
                stack.push(timeTaken);
            }
        }

        return stack.size();
    }

    public static void main(String[] args) {
        CarFleet obj = new CarFleet();
        System.out.println(obj.carFleet(12, new int[]{10,8,0,5,3}, new int[]{2,4,1,1,3}));
        System.out.println(obj.carFleet(10, new int[]{3}, new int[]{3}));
        System.out.println(obj.carFleet(100, new int[]{0,2,4}, new int[]{4,2,1}));
    }
}

/*
 *
 * Approach: To solve the problem, the algorithm uses a greedy approach by processing the cars from closest to farthest
 *           from the target destination.
 *           It first pairs each car's position with its speed and sorts them in descending order based on their starting
 *           positions, because a car's progress is ultimately bottlenecked by any slower cars ahead of it.
 *           As it iterates through this sorted list, it calculates the time each car needs to reach the target
 *           time = (target - position) / speed  and uses a stack to track the fleet leaders. If a trailing car takes
 *           less time or the same amount of time to finish than the car ahead of it (stack.peek()), it means the trailing
 *           car is faster, will catch up, and will merge into that existing fleet (so it is ignored). If it takes strictly
 *           longer, it can never catch up, meaning it forms a brand-new fleet leader and its time is pushed onto the stack;
 *           ultimately, the final size of the stack represents the total number of unique car fleets that cross the finish line.
 *
 * TC : O(nlogn)  n = length of array
 * SC: O(n)
 *
 * Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
 * Output: 3
 *
 */