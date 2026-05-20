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
