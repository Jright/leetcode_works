package No851_900;

import java.util.*;

public class No895_MaximumFrequencyStack {

    Map<Integer, Integer> freq;
    Map<Integer, ArrayDeque<Integer>> group;
    int maxfreq;

    public No895_MaximumFrequencyStack() {
        freq = new HashMap<>();
        group = new HashMap<>();
        maxfreq = 0;
    }

    public void push(int x) {
        int f = freq.getOrDefault(x, 0) + 1;
        freq.put(x, f);
        if (f > maxfreq) {
            maxfreq = f;
        }
        group.computeIfAbsent(f, z -> new ArrayDeque<Integer>()).push(x);
    }

    public int pop() {
        int x = group.get(maxfreq).pop();
        freq.put(x, freq.get(x) - 1);
        if (group.get(maxfreq).size() == 0) {
            maxfreq--;
        }
        return x;
    }
}
