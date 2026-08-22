/*
Problem: Design HashSet
Difficulty: Easy

Approach:

1. Use a boolean array to store the keys.
2. The key itself is used as the index.
3. true  -> key exists
4. false -> key does not exist

Time Complexity:
add      -> O(1)
remove   -> O(1)
contains -> O(1)

Space Complexity: O(maxKey)
*/

class MyHashSet {

    private boolean[] data;

    public MyHashSet() {

       
        data = new boolean[1000001];
    }

    public void add(int key) {

        data[key] = true;
    }

    public void remove(int key) {

        data[key] = false;
    }

    public boolean contains(int key) {

        return data[key];
    }
}