package w4.stack;

import java.util.Stack;

class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);

        if(minStack.isEmpty() || minStack.peek() >= val){
            minStack.push(val);
        }
    }

    public void pop() {
        int popped = stack.pop();
        if(popped == minStack.peek()){
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStackObj = new MinStack();

        minStackObj.push(0);
        minStackObj.push(1);
        minStackObj.push(0);

        System.out.println(minStackObj.getMin());
        minStackObj.pop();
        System.out.println(minStackObj.stack);
        System.out.println(minStackObj.getMin());
        minStackObj.pop();
        System.out.println(minStackObj.stack);
        System.out.println(minStackObj.getMin());
        minStackObj.pop();
        System.out.println(minStackObj.stack);
        minStackObj.push(-2);
        minStackObj.push(-1);
        minStackObj.push(-2);

        System.out.println(minStackObj.getMin());
        minStackObj.pop();
        System.out.println(minStackObj.stack);
        System.out.println(minStackObj.top());
        System.out.println(minStackObj.getMin());
        minStackObj.pop();
        System.out.println(minStackObj.stack);
        System.out.println(minStackObj.getMin());
        minStackObj.pop();
        System.out.println(minStackObj.stack);

    }
}

/*
 * Approach: We will maintain two stacks. One for push, pop and peek operations and another monotonic stack to maintain
 *           a minimum value at top of stack at that moment in time. While pushing values in first stack we will check if
 *           min-stack is empty or if current value is smaller than or equal to min-stack top value then we will push
 *           current element to min-stack as well.
 *           While popping the first stack we will check if popped element is equal to min-stack top if yes we pop this
 *           element from min-stack also, this way we will be able to maintain minimum value in min-stack.
 *
 * TC: O(1)
 * SC: O(1)
 *
 * Input: ["MinStack","push","push","push","getMin","pop","top","getMin"]
 *        [[],[-2],[0],[-3],[],[],[],[]]
 *
 * Output: [null,null,null,null,-3,null,0,-2]
 *
 */

