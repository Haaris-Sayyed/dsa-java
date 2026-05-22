package w4.stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[n];

        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]){
                  stack.pop();
            }

            answer[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        DailyTemperatures obj = new DailyTemperatures();

        System.out.println(Arrays.toString(obj.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73})));
        System.out.println(Arrays.toString(obj.dailyTemperatures(new int[]{30,40,50,60})));
        System.out.println(Arrays.toString(obj.dailyTemperatures(new int[]{30,60,90})));
    }
}

/*
 * Approach: We will traverse array from the end and while the stack is not empty and current index temperature value is
 *           greater than or equal to temperature value of index at stack top then we will pop the stack.
 *           Once the loop breaks we will evaluate current index answer as 0 if stack is empty otherwise current_index - index at stack top
 *           and push current index onto the stack.
 *
 * TC: O(N) N = length of input array
 * SC: O(N)
 *
 * Input: [73, 74, 75, 71, 69, 72, 76, 73]
 * Output: [1,1,4,2,1,1,0,0]
 *
 */