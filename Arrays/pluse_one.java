public /*
Problem: Plus One
Difficulty: Easy

Approach:

1. Traverse the array from the last digit to the first.
2. If the current digit is less than 9:
   - Increment it by 1.
   - Return the array immediately since no carry remains.
3. If the current digit is 9:
   - Change it to 0 and continue to the previous digit.
4. If all digits are 9:
   - Create a new array of size n + 1.
   - Set the first element to 1.
   - The remaining elements are already initialized to 0.
5. Return the new array.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {

            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;

        return result;
    }
} {
    
}
