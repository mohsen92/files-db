package problem1;

import java.util.Stack;

public class SubStringReverse {
    private final char startChar;
    private final char endChar;

    public SubStringReverse(char startChar, char endChar) {
        this.startChar = startChar;
        this.endChar = endChar;
    }

    public String reverseParenthesesSubString(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(c == endChar) {
                StringBuilder stringBuilder = new StringBuilder();
                while (stack.peek() != startChar){
                    stringBuilder.append(stack.pop());
                }
                stringBuilder.append(endChar);
                int i = 0;
                while (i < stringBuilder.length()){
                    stack.push(stringBuilder.charAt(i++));
                }
            } else {
                stack.push(c);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.empty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.reverse().toString();
    }

}
