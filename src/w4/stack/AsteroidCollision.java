package w4.stack;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            if(stack.isEmpty() || asteroids[i] > 0){
                stack.push(asteroids[i]);
            }else{
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -asteroids[i]){
                    stack.pop();
                }
                if(stack.isEmpty() || stack.peek() < 0){
                    stack.push(asteroids[i]);
                }else if(stack.peek() == -asteroids[i]){
                    stack.pop();
                }
            }
        }
        return stack.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        AsteroidCollision obj = new AsteroidCollision();

        System.out.println(Arrays.toString(obj.asteroidCollision(new int[]{5,10,-5})));
        System.out.println(Arrays.toString(obj.asteroidCollision(new int[]{8,-8})));
        System.out.println(Arrays.toString(obj.asteroidCollision(new int[]{10,2,-5})));
        System.out.println(Arrays.toString(obj.asteroidCollision(new int[]{3,5,-6,2,-1,4})));
    }
}

/*
 *
 * Approach: To solve this problem, the algorithm uses a Stack to simulate the collisions of asteroids moving left and right,
 *           processing them one by one from left to right. Asteroids moving right (positive numbers) or any asteroid facing
 *           an empty path are safely pushed onto the stack because they can't collide with anything already behind them.
 *           However, when a left-moving asteroid (negative number) appears, it will crash into any right-moving asteroids
 *           currently at the top of the stack. The code runs a loop to smash and remove smaller right-moving asteroids from
 *           the stack because the larger left-moving one destroys them. This crashing stops when the left-moving asteroid
 *           either hits an equally sized asteroid (destroying both), runs into a larger right-moving asteroid (destroying
 *           itself), or clears out all opposition. At the end, whatever asteroids survive are left in the stack, which is
 *           converted back into an array as the final result.
 *
 * TC : O(n)  n = length of array
 * SC: O(n)
 *
 * Input:  asteroids = [5,10,-5]
 * Output: [5,10]
 *
 */
