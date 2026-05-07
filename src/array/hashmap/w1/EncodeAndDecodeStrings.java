package array.hashmap.w1;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {

    public String encode(List<String> list){
        String encodedStr = "";
        StringBuilder sb = new StringBuilder();
        for (String s : list){
            sb.append(s.length()).append("#").append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String s){
        List<String> list = new ArrayList<>();
        int i = 0;
        while (i < s.length()){
            int j = i;
            while (s.charAt(j) != '#'){
                j++;
            }
            int length = Integer.parseInt(s.substring(i,j));
            list.add(s.substring(j + 1, j + length + 1));
            i = j + 1 + length;
        }

        return list;
    }


    public static void main(String[] args) {
        EncodeAndDecodeStrings obj = new EncodeAndDecodeStrings();

        System.out.println(obj.encode(List.of("neet", "code")));
        System.out.println(obj.decode("4#neet4#code"));
    }
}

/*
 *
 * Encode Approach: Traverse the strings array and for each string concat length of string, delimiter and the string itself
 * do this for all the words in the list and create an encoded string.
 *
 * Decode Approach: Traverse the encoded string till the delimiter which gives us the length of the string, convert it to an integer
 * then fetch the next 'n' characters where n is length extracted in last step and add this extracted string to result. Do this till we reach the end of encoded string.
 *
 * TC : O(n)  n = total number of characters across all strings in the input list
 * SC: O(n)
 *
 * Input: list = ["neet", "code"]
 * Encode Output: 4#neet4#code
 * Decode Output: ["neet", "code"]
 *
 */