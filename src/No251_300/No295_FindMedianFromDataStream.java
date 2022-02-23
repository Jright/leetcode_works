package No251_300;

import java.util.PriorityQueue;

public class No295_FindMedianFromDataStream {

    private PriorityQueue<Integer> left;
    private PriorityQueue<Integer> right;

    /** initialize your data structure here. */
    public No295_FindMedianFromDataStream() {
        this.left = new PriorityQueue<>((a, b) -> b - a);
        this.right = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (!left.isEmpty() && left.peek() >= num) {
            left.add(num);
        } else {
            right.add(num);
        }

        int difference = left.size() - right.size();

        if (difference == -2) {
            left.add(right.poll());
        } else if (difference == 2) {
            right.add(left.poll());
        }
    }

    public double findMedian() {
        int m = right.size();
        int n = left.size();

        if (n == m) {
            return (double) (right.peek() + left.peek()) / (double) 2;
        } else {
            return n > m ? left.peek() : right.peek();
        }
    }
}
