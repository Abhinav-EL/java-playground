import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://neetcode.io/problems/string-encode-and-decode/question?list=blind75
Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.

Machine 1 (sender) has the function:

string encode(vector<string> strs) {
    // ... your code
    return encoded_string;
}
Machine 2 (receiver) has the function:

vector<string> decode(string s) {
    //... your code
    return strs;
}
So Machine 1 does:

string encoded_string = encode(strs);
and Machine 2 does:

vector<string> strs2 = decode(encoded_string);
strs2 in Machine 2 should be the same as strs in Machine 1.

Implement the encode and decode methods.

Example 1:

Input: dummy_input = ["Hello","World"]

Output: ["Hello","World"]

Explanation:
Machine 1:
Codec encoder = new Codec();
String msg = encoder.encode(strs);
Machine 1 ---msg---> Machine 2

Machine 2:
Codec decoder = new Codec();
String[] strs = decoder.decode(msg);
Example 2:

Input: dummy_input = [""]

Output: [""]
 */
public class EncodeDecodeStrings {
    public static String SEPEARATOR = "QQ";

    public static void main(String[] args) {
        EncodeDecodeStrings test = new EncodeDecodeStrings();
        List<String> toEncodeList = new ArrayList<>();
        toEncodeList.add("a");
        toEncodeList.add("superbowl6");
        String testStr = test.encode(toEncodeList);

        List<String> retList = test.decode(testStr);
        System.out.println(toEncodeList.containsAll(retList));
    }
    
    public String encode(List<String> strs) {
        StringBuffer sbr = new StringBuffer();
        for(String val: strs){
            sbr.append(val.length()+SEPEARATOR);
            sbr.append(val);
        }
        System.out.println("Encode "+ sbr.toString());
        return sbr.toString();
    }

    public List<String> decode(String str) {
        List<String> retList = new LinkedList<>();
        char[] strCharArray = str.toCharArray();
        if(strCharArray.length==3){
            retList.add("");
            return retList;
        }

        int mainPointer = 0;
        int secondPointer=0;
        while(secondPointer+1<strCharArray.length){
            
            StringBuffer sizeBuffer = new StringBuffer();
            sizeBuffer.append(strCharArray[secondPointer]);
            // If the size is > 9
            while(!('Q'==(strCharArray[secondPointer+1])&& 'Q'==(strCharArray[secondPointer+2]))){
                secondPointer++;
                System.out.println("Size "+ strCharArray[secondPointer]);
                sizeBuffer.append(strCharArray[secondPointer]);
            }
            int size = Integer.parseInt(sizeBuffer.toString()); // Word Length
            
            StringBuffer strBuffer = new StringBuffer();
            mainPointer = mainPointer+SEPEARATOR.length() + sizeBuffer.length(); // move 2 places Separator + the no. of digits of Size (1 for 5 and 2 for 11)
            secondPointer = mainPointer+size;
            
            System.out.println("Main Pointer "+ mainPointer);
            System.out.println("Second Pointer "+ secondPointer);
            while(mainPointer<secondPointer){
                strBuffer.append(strCharArray[mainPointer]);
                mainPointer++;
            }
            retList.add(strBuffer.toString());
            System.out.println("word "+ strBuffer.toString());
        }
        System.out.println("Decode list "+ retList);
        return retList;
    }

}
