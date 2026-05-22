package w4.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generateParenthesisBacktrack(ans, new StringBuilder(), 0, 0 ,n);
        return ans;
    }

    public void generateParenthesisBacktrack(List<String> ans, StringBuilder current, int open, int close, int max) {
        if(current.length() == 2 * max){
            ans.add(current.toString());
            return;
        }
        if(open < max){
            current.append("(");
            generateParenthesisBacktrack(ans, current, open + 1, close, max);
            current.deleteCharAt(current.length() - 1);
        }
        if(close < open){
            current.append(")");
            generateParenthesisBacktrack(ans, current, open, close + 1, max);
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses obj = new GenerateParentheses();

        System.out.println(obj.generateParenthesis(3));
        System.out.println(obj.generateParenthesis(8));
    }

}

/*
* Approach: The problem asks us to generate all combinations of well-formed parentheses. Instead of generating all possible 2^{2n} sequences of brackets and filtering out the invalid ones, 
*           code uses backtracking with constraints to build only valid sequences from the ground up.
*           At each step of the recursion tree, there is a choice to be made based on two strict invariants that guarantee valid pairings:
*           - Place an Open Parenthesis (: You can always add an open parenthesis as long as the count of open parentheses is less than n (open < max).
*           - Place a Close Parenthesis ): You can only add a close parenthesis if it won't break the balance. This means the count of closed parentheses must be strictly less than the count of open ones currently placed (close < open).
*           Once the current string builder reaches a length of 2n, a valid sequence has been completed. It is added to the results list, and the algorithm backtracks by removing the last character (deleteCharAt) to explore alternative paths.
*
* TC: O(2^2*N) N = pairs of parentheses
* SC: O(2*N)
*
* Input: N = 3
* Output: ["((()))","(()())","(())()","()(())","()()()"]
*
*/