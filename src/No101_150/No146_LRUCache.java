package No101_150;

import java.util.HashMap;
import java.util.Map;

public class No146_LRUCache {

    static class DoubleLinkedNode{
        int key;
        int value;
        DoubleLinkedNode prev;
        DoubleLinkedNode next;
    }

    private final Map<Integer, DoubleLinkedNode> cache = new
            HashMap<>();
    private int size;
    private final int capacity;
    private final DoubleLinkedNode head;
    private final DoubleLinkedNode tail;

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

    public No146_LRUCache(int capacity){
        this.size = 0;
        this.capacity = capacity;
        head = new DoubleLinkedNode();
        tail = new DoubleLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key){
        DoubleLinkedNode node = cache.get(key);
        if(node == null){
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value){
        DoubleLinkedNode node = cache.get(key);
        if(node == null){
            DoubleLinkedNode newNode = new DoubleLinkedNode();
            newNode.key = key;
            newNode.value = value;
            cache.put(key, newNode);
            addNode(newNode);
            size++;

            if(size > capacity){
                DoubleLinkedNode tail = popTail();
                cache.remove(tail.key);
                size--;
            }

        }else{
            node.value = value;
            moveToHead(node);
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
