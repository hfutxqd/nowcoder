package q37548e94a270412c8b9fb85643c8ccc2;

import java.util.Stack;

public class Solution {
    /**
     *
     * @param s string字符串
     * @return bool布尔型
     */
    public boolean isValid (String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (stack.size() == 0) {
                stack.push(ch);
            } else {
                if (stack.peek() == '{' && ch == '}') {
                    stack.pop();
                } else if (stack.peek() == '[' && ch == ']') {
                    stack.pop();
                } else if (stack.peek() == '(' && ch == ')') {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }
        return stack.size() == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("[](([[]]){}{[]}([]))"));
    }
}