package No451_500;

import java.util.HashMap;
import java.util.Map;

public class No460_LFUCache {

    static class ListNode<T> {
        T val;
        ListNode<T> next, prev;
    }

    static class MyList<T> {
        ListNode<T> sn; // sentinel node for easy implementation

        MyList() {
            sn = new ListNode<>();
            sn.next = sn.prev = sn;
        }

        public ListNode<T> addFirst(T val) {
            ListNode<T> node = new ListNode<>();
            node.val = val;
            node.prev = sn;
            node.next = sn.next;
            node.prev.next = node;
            node.next.prev = node;
            return node;
        }

        public void remove(ListNode<T> node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = node.prev = null;
        }

        public boolean isEmpty() {
            return sn.next == sn;
        }

        public ListNode<T> first() {
            if (isEmpty())
                return null;
            return sn.next;
        }

        public ListNode<T> last() {
            if (isEmpty())
                return null;
            return sn.prev;
        }
    }

    static class Data {
        int key, val;
        int freq;

        Data(int key, int val) {
            this.key = key;
            this.freq = 1;
            this.val = val;
        }
    }

    Map<Integer, ListNode<Data>> map;
    Map<Integer, MyList<Data>> freqMap;
    int cap, lfreq;

    public No460_LFUCache(int capacity) {
        map = new HashMap<>();
        freqMap = new HashMap<>();
        freqMap.put(1, new MyList<>());
        cap = capacity;
        lfreq = -1; // least frequency available at any given time.
    }

    // Increment the frequency of a given key
    // (Remove the node from the list of *freq* and add it to the list of *freq + 1*)
    private ListNode<Data> incrementFreq(int key) {
        ListNode<Data> node = map.get(key);
        Data data = node.val;
        MyList<Data> oldList = freqMap.get(data.freq);
        oldList.remove(node);
        if (data.freq == lfreq && oldList.isEmpty()) {
            lfreq++;
        }
        data.freq++;
        if (!freqMap.containsKey(data.freq))
            freqMap.put(data.freq, new MyList<>());
        ListNode<Data> newNode = freqMap.get(data.freq).addFirst(data);
        map.put(key, newNode);
        return newNode;
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        ListNode<Data> node = incrementFreq(key);
        return node.val.val;
    }

    public void put(int key, int value) {
        if (cap == 0)
            return;
        if (map.containsKey(key)) {
            ListNode<Data> node = incrementFreq(key);
            node.val.val = value;
        } else {
            if (map.size() == cap) {
                MyList<Data> list = freqMap.get(lfreq);
                ListNode<Data> last = list.last();
                list.remove(last);
                map.remove(last.val.key);
            }
            Data data = new Data(key, value);
            map.put(key, freqMap.get(1).addFirst(data));
            lfreq = 1;
        }
    }
}
