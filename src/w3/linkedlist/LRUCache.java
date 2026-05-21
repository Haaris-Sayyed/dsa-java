package w3.linkedlist;


import java.util.HashMap;
import java.util.Map;

class Node{
    int key;
    int value;
    Node prev, next;

    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }

}


public class LRUCache {
    private final int capacity;
    private final Map<Integer, Node> keyToNode;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.keyToNode = new HashMap<>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(!keyToNode.containsKey(key)) return -1;
        Node node = keyToNode.get(key);
        remove(node);
        insertAtFront(node);
       return node.value;
    }

    public void put(int key, int value) {
        if(keyToNode.containsKey(key)){
            Node node = keyToNode.get(key);
            node.value = value;
            remove(node);
            insertAtFront(node);
        }else{
            if(keyToNode.size() == capacity){
                Node lru = tail.prev;
                remove(lru);
                keyToNode.remove(lru.key);
            }
            Node newNode = new Node(key, value);
            insertAtFront(newNode);
            keyToNode.put(key, newNode);
        }
    }

    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insertAtFront(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // return -1 (not found)
        System.out.println(lRUCache.get(3));    // return 3
        System.out.println(lRUCache.get(4));    // return 4

    }
}

/*
 *
 * Approach: To achieve lightning-fast access and updates, it combines two distinct data structures:
 *           a HashMap and a Doubly Linked List.
 *
 *           The HashMap (keyToNode): This provides O(1) fast lookups. The keys are the cache keys, and the values point
 *                                    directly to the corresponding nodes inside our doubly linked list.
 *           The Doubly Linked List (head and tail): This tracks the usage history.The Front (head.next): Represents the most
 *                                                   recently used items.The Back (tail.prev): Represents the least recently used items.Dummy
 *           Sentinel Nodes: The head and tail are initialized as empty "dummy" boundary nodes. This completely eliminates
 *                           annoying null pointer checks when inserting or removing items from the edges of the list.
 *
 *           get: If the key exists, we find its node via the map. To mark it as recently used, we splice it out of its current
 *                position (remove) and pop it right behind the dummy head (insertAtFront).
 *
 *           put: If the key already exists, we update its value and move it to the front. If it's a new key and the cache is full (size == capacity), we look at tail.
 *               prev to find the oldest item, evict it from both the linked list and the map, and then insert our new node at the front.
 *
 * TC : O(1)
 * SC: O(N) Let N be the total number of nodes in the linked list.
 *
 * Input: ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 *        [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 *
 * Output: [1,-1,-1,3,4]
 *
 */