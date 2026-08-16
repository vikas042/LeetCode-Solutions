/*
Problem: Gas Station
Difficulty: Medium

Approach:

1. Calculate total gas and total cost.
2. If total gas is less than total cost,
   return -1 because completing the circuit is impossible.
3. Use a greedy approach to find the starting station.
4. If the current tank becomes negative,
   the current start cannot be the answer.
5. Set the next station as the new starting point
   and reset the tank.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int totalGas = 0;
        int totalCost = 0;

        int tank = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {

            totalGas += gas[i];
            totalCost += cost[i];

            tank += gas[i] - cost[i];

           
            if (tank < 0) {

                start = i + 1;
                tank = 0;
            }
        }

        // Not enough gas to complete the circuit
        if (totalGas < totalCost) {
            return -1;
        }

        return start;
    }
}