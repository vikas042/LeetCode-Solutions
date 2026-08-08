/*
Problem: LRU Cache
Difficulty: Medium

Approach:
- HashMap gives O(1) access to nodes.
- Doubly Linked List maintains the order of usage.
- Head = Most Recently Used
- Tail = Least Recently Used

For every get() or put(), the accessed node is moved
to the front.

Time Complexity:
- get() -> O(1)
- put() -> O(1)

Space Complexity: O(capacity)
*/

class LRUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> map;

    private Node head;
    private Node tail;

    public LRUCache(int capacity) {

        this.capacity = capacity;
        map = new HashMap<>();

     
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    private void addNode(Node node) {

        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node) {

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToFront(Node node) {

        removeNode(node);
        addNode(node);
    }

    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        moveToFront(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {

            Node node = map.get(key);

            node.value = value;

            moveToFront(node);

            return;
        }

        Node newNode = new Node(key, value);

        map.put(key, newNode);
        addNode(newNode);

        if (map.size() > capacity) {

            Node lru = tail.prev;

            removeNode(lru);
            map.remove(lru.key);
        }
    }
}