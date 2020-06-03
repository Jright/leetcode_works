package No1001_1050;

import java.util.*;

public class No1029_TwoCityScheduling {

    public static int twoCitySchedCost(int[][] costs) {
        int result = 0;

        int A = costs.length / 2;
        int B = A;

        TreeMap<Integer, List<Integer>> map = new TreeMap<>();

        for(int i = 0; i < costs.length; i++){
            int difference = Math.abs(costs[i][0] - costs[i][1]);
            if(map.get(difference) == null){
                List<Integer> indexList = new ArrayList<>();
                indexList.add(i);
                map.put(difference, indexList);
            }else{
                List<Integer> integers = map.get(difference);
                integers.add(i);
                map.put(difference, integers);
            }
        }

        for(int difference: map.descendingKeySet()){
            List<Integer> indexes = map.get(difference);
            for(int index: indexes){
                if(A != 0 && B != 0){
                    if(costs[index][0] > costs[index][1]){
                        result += costs[index][1];
                        B--;
                    }else if(costs[index][0] < costs[index][1]){
                        result += costs[index][0];
                        A--;
                    }else{
                        if(A > B){
                            result += costs[index][0];
                            A--;
                        }else{
                            result += costs[index][1];
                            B--;
                        }
                    }
                }else if(A != 0){
                    result += costs[index][0];
                    A--;
                }else if(B != 0){
                    result += costs[index][1];
                    B--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] array = new int[4][2];
        array[0] = new int[]{10, 20};
        array[1] = new int[]{30, 200};
        array[2] = new int[]{400, 50};
        array[3] = new int[]{30, 20};
//        [[10,20],[30,200],[400,50],[30,20]];
        int result = twoCitySchedCost(array);
        System.out.println(result);
    }
}
