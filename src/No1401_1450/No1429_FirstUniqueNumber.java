package No1401_1450;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class No1429_FirstUniqueNumber {

    Set<Integer> set;
    Set<Integer> all;

    public No1429_FirstUniqueNumber(int[] nums) {
        set = new LinkedHashSet<>();
        all = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (!all.contains(nums[i])) {
                all.add(nums[i]);
                set.add(nums[i]);
            } else {
                if (set.contains(nums[i])) {
                    set.remove(nums[i]);
                }
            }
        }
    }

    public int showFirstUnique() {
        if (set.size() == 0){
            return -1;
        }
        return set.iterator().next();
    }

    public void add(int value) {
        if (!all.contains(value)) {
            all.add(value);
            set.add(value);
        } else {
            if (set.contains(value))
                set.remove(value);
        }
    }
}
