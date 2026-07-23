/*
Problem: Best Time to Buy and Sell Stock
Difficulty: Easy

Approach:

1. Initialize the minimum price as the first day's price.
2. Initialize the maximum profit as 0.
3. Traverse the array from the second day onward.
4. If the current price is lower than the minimum price,
   update the minimum price.
5. Otherwise, calculate the profit by selling today.
6. Update the maximum profit if the current profit is larger.
7. Return the maximum profit.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public int maxProfit(int[] prices) {

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {

            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }

            else {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
        }

        return maxProfit;
    }
}
