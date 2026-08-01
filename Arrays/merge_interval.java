/*
Problem: Merge Intervals
Difficulty: Medium

Approach:

1. Sort the intervals based on their starting point.
2. Initialize the first interval as the current interval.
3. Traverse the remaining intervals:
   - If the current interval overlaps with the last merged interval,
     update the end of the last merged interval.
   - Otherwise, add the current interval to the result.
4. Convert the list of merged intervals into a 2D array.

Time Complexity: O(n log n)
Space Complexity: O(n)
*/

class Solution {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();

        for (int[] interval : intervals) {

            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } 
            else {
                merged.get(merged.size() - 1)[1] =
                        Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}