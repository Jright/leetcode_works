package No351_400;

import java.util.*;

public class No380_InsertDeleteGetRandomO1 {

    Map<Integer, Integer> map;
    List<Integer> list;

    public No380_InsertDeleteGetRandomO1() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }

        map.put(val, list.size());
        list.add(list.size(), val);
        return true;
    }

    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }


        int lastElement = list.get(list.size() - 1);
        int index = map.get(val);
        list.set(index, lastElement);
        map.put(lastElement, index);

        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        Random random = new Random();

        return list.get(random.nextInt(list.size()));
    }
}
