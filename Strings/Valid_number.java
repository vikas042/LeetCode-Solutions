/*
Problem: Valid Number
Difficulty: Hard

Approach:

1. Traverse the string once while keeping track of:
   - digitSeen     : whether at least one digit has been found.
   - dotSeen       : whether a decimal point has been found.
   - exponentSeen  : whether 'e' or 'E' has been found.
2. A digit is always valid and marks digitSeen = true.
3. A '.' is valid only if:
   - no previous dot exists.
   - no exponent has appeared.
4. 'e' or 'E' is valid only if:
   - no previous exponent exists.
   - at least one digit has already been seen.
   After encountering an exponent, reset digitSeen because
   digits are required after the exponent.
5. '+' or '-' is valid only:
   - at the beginning of the string, or
   - immediately after 'e' or 'E'.
6. Any other character makes the string invalid.
7. Return true only if digits exist in the final valid part.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public boolean isNumber(String s) {

        boolean digitSeen = false;
        boolean dotSeen = false;
        boolean exponentSeen = false;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {

                digitSeen = true;
            }

            else if (ch == '.') {

                if (dotSeen || exponentSeen) {
                    return false;
                }

                dotSeen = true;
            }

            else if (ch == 'e' || ch == 'E') {

                if (exponentSeen || !digitSeen) {
                    return false;
                }

                exponentSeen = true;
                digitSeen = false;
            }

            else if (ch == '+' || ch == '-') {

                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            }

            else {
                return false;
            }
        }

        return digitSeen;
    }
}