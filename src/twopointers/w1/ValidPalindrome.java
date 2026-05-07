package twopointers.w1;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        String str = cleanUp(s);

        int left = 0, right = str.length() - 1;
        while (left <= right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public String cleanUp(String s){
        StringBuilder sb = new StringBuilder();
        for(char ch: s.toCharArray()){
            if(ch >= 'A' && ch <= 'Z'){
                sb.append((char)(ch + 32));
            }else if((ch >= 'a' && ch <= 'z') || (ch >='0' && ch <= '9')){
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ValidPalindrome obj = new ValidPalindrome();
        System.out.println(obj.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(obj.isPalindrome("race a car"));
        System.out.println(obj.isPalindrome(""));
        System.out.println(obj.isPalindrome("0P"));
    }
}

/*
 *
 * Approach: Traverse the string and remove all non-alphanumeric characters. Initialize two pointers
 * left = 0 and right = s.length() - 1 on the newly obtained string and compare if both the characters at
 * left and right indices are equal
 * if yes continue this process till left pointer is smaller than right pointer
 * if no means the string is not a valid palindrome
 *
 * TC : O(n)  n = length of string
 * SC: O(1)
 *
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 *
 */
