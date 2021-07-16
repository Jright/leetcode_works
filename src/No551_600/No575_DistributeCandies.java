package No551_600;

import java.util.HashSet;
import java.util.Set;

public class No575_DistributeCandies {

    public int distributeCandies(int[] candyType) {
        if(candyType == null || candyType.length == 0){
            return 0;
        }

        Set<Integer> uniqueSet = new HashSet<>(candyType.length / 2);

        for(int index = 0; index < candyType.length; index++){
            uniqueSet.add(candyType[index]);
            if(uniqueSet.size() >= candyType.length / 2){
                return candyType.length / 2;
            }
        }

        return uniqueSet.size();
    }
}
