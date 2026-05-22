package w4.stack;

import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char ch: s.toCharArray()){
            if(ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
            }else{
                if(stack.isEmpty() || stack.peek() != correspondingOpeningCharacter(ch)){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public char correspondingOpeningCharacter(char ch){
        if(ch == ')') return '(';
        if(ch == ']') return '[';
        return '{';
    }

    public static void main(String[] args) {
        ValidParentheses obj = new ValidParentheses();

        System.out.println(obj.isValid("()"));
        System.out.println(obj.isValid("()[]{}"));
        System.out.println(obj.isValid("(]"));
        System.out.println(obj.isValid("([)]"));

    }

}

/*
* Approach: Traverse the string character by character and if we encounter an opening bracket we will push it onto the stack
*           else if we encounter a closing bracket we will check if stack is empty of if the stack top doesn't contain matching
*           opening bracket and if so we will return false
*           otherwise we will pop current top character from stack
*           After traversing the complete string if we have an empty stack means the parentheses string was a valid string
*           hence we return true otherwise if stack is not empty we return false
*
* TC: O(N) N = length of string
* SC: O(N)
*
* Input: "()[]{}"
* Output: true
*
*/