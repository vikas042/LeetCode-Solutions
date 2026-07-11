/*
Problem: Valid Parentheses
Difficulty: Easy

Approach:

1. Use a Stack to keep track of opening brackets.
2. Traverse each character in the string.
3. If the character is an opening bracket:
   - Push it onto the stack.
4. If the character is a closing bracket:
   - If the stack is empty, return false.
   - Pop the top element and check if it matches
     the corresponding opening bracket.
5. If any mismatch occurs, return false.
6. After traversing the string, return true only if
   the stack is empty.

Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.Stack;

class Solution {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }

            else {

                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}