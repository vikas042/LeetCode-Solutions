/*
Problem: Simplify Path
Difficulty: Medium

Approach:
1. Split the path using "/".
2. Use a stack to store valid directory names.
3. Ignore:
   - Empty strings
   - "."
4. For "..":
   - Remove the last directory if the stack is not empty.
5. All other names are valid directory names.
6. Build the canonical path from the stack.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {

    public String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();

        String[] parts = path.split("/");

        for (String part : parts) {

            if (part.equals("") || part.equals(".")) {
                continue;
            }

            if (part.equals("..")) {

                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }

            else {
                stack.push(part);
            }
        }

        StringBuilder result = new StringBuilder();

        for (String dir : stack) {
            result.append("/").append(dir);
        }

        if (result.length() == 0) {
            return "/";
        }

        return result.toString();
    }
}