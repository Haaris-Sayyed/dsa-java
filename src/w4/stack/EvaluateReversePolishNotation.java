package w4.stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String token: tokens){
                switch (token) {
                    case "+":
                        stack.push(stack.pop() + stack.pop());
                        break;
                    case "-":
                        stack.push(stack.pop() - stack.pop());
                        break;
                    case "*":
                        stack.push(stack.pop() * stack.pop());
                        break;
                    case "/":
                        int denominator = stack.pop();
                        int numerator = stack.pop();
                        stack.push(numerator / denominator);
                        break;
                    default:
                        stack.push(Integer.parseInt(token));
                }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation obj = new EvaluateReversePolishNotation();

        System.out.println(obj.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }

}

/*
*
* Approach: Traverse the array and if we encounter any operand [+, -, *, /] then we will pop the stack two times perform
*           current operation on these values and push the result back onto the stack, else if we encounter any digit then
*           we will push it onto the stack this way by the end of these operations we will have just a single entry
*           present in the stack which is the required answer we will get after evaluating the given reverse polish notation.
*
* TC: O(N) N = length of given string array
* SC: O(N)
*
* Input: ["2","1","+","3","*"] //((2 + 1) * 3) = 9
* Output: 9
*
*/
