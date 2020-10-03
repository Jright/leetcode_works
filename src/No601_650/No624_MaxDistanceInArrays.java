package No601_650;

import java.util.*;

public class No624_MaxDistanceInArrays {

    public int maxDistance(List<List<Integer>> arrays) {
        int arraysLength = arrays.size();

        if (arraysLength == 0) {
            return Integer.MIN_VALUE;
        }

        int result = 0;
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);

        for(int i = 1; i < arrays.size(); i++){
            int competitor = Math.max(Math.abs(arrays.get(i).get(arrays.get(i).size() - 1) - min),
                    Math.abs(max - arrays.get(i).get(0)));
            result = Math.max(result, competitor);
            min = Math.min(min, arrays.get(i).get(0));
            max = Math.max(max, arrays.get(i).get(arrays.get(i).size() - 1));
        }


        return result;
    }
}
