package No101_150;

import java.util.HashMap;
import java.util.Map;

public class No146_LRUCache {

    private int capacity;
    private int size;
    private DoubleLinkedNode head;
    private DoubleLinkedNode tail;

    private Map<Integer, DoubleLinkedNode> map = new HashMap<>();

    public No146_LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new DoubleLinkedNode();
        tail = new DoubleLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DoubleLinkedNode node = map.get(key);
        if(node == null){
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DoubleLinkedNode node = map.get(key);

        if(node == null){
            node = new DoubleLinkedNode();
            node.key = key;
            node.value = value;

            map.put(key, node);
            addNode(node);
            size++;

            if(size > capacity){
                DoubleLinkedNode tailNode = popTail();
                map.remove(tailNode.key);
                size--;
            }
        }else{
            node.value = value;
            moveToHead(node);
        }
    }

    class DoubleLinkedNode{
        int key;
        int value;
        DoubleLinkedNode prev;
        DoubleLinkedNode next;
    }

    private void addNode(DoubleLinkedNode node){
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DoubleLinkedNode node){
        DoubleLinkedNode prev = node.prev;
        DoubleLinkedNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void moveToHead(DoubleLinkedNode node){
        removeNode(node);
        addNode(node);
    }

    private DoubleLinkedNode popTail(){
        DoubleLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}
