/*
Problem: Text Justification
Difficulty: Hard

Approach:

1. Greedily fit as many words as possible into the current line.
2. Compute:
   - Total characters of the words.
   - Total spaces needed.
3. If it is the last line or the line contains only one word:
   - Left justify by placing one space between words.
   - Append remaining spaces at the end.
4. Otherwise:
   - Distribute spaces evenly among the gaps.
   - Extra spaces are assigned to the leftmost gaps.
5. Add each justified line to the result.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {

    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> result = new ArrayList<>();

        int index = 0;

        while (index < words.length) {

            int totalChars = words[index].length();
            int last = index + 1;

            while (last < words.length) {

                if (totalChars + 1 + words[last].length() > maxWidth) {
                    break;
                }

                totalChars += 1 + words[last].length();
                last++;
            }

            StringBuilder line = new StringBuilder();

            int gaps = last - index - 1;

            // Last line or only one word
            if (last == words.length || gaps == 0) {

                for (int i = index; i < last; i++) {

                    line.append(words[i]);

                    if (i < last - 1) {
                        line.append(" ");
                    }
                }

                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            }

            else {

                int wordsLength = 0;

                for (int i = index; i < last; i++) {
                    wordsLength += words[i].length();
                }

                int totalSpaces = maxWidth - wordsLength;
                int spaceEach = totalSpaces / gaps;
                int extraSpaces = totalSpaces % gaps;

                for (int i = index; i < last; i++) {

                    line.append(words[i]);

                    if (i < last - 1) {

                        int spaces = spaceEach;

                        if (extraSpaces > 0) {
                            spaces++;
                            extraSpaces--;
                        }

                        for (int j = 0; j < spaces; j++) {
                            line.append(" ");
                        }
                    }
                }
            }

            result.add(line.toString());

            index = last;
        }

        return result;
    }
}