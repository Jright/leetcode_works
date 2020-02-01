package No101_150;

import java.util.ArrayList;
import java.util.List;

public class No118_PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resultList = new ArrayList<>();

        if(numRows == 0){
            return resultList;
        }

        List<Integer> firstList = new ArrayList<>();
        firstList.add(1);
        resultList.add(firstList);

        if(numRows == 1){
            return resultList;
        }

        List<Integer> secondList = new ArrayList<>();
        secondList.add(1);
        secondList.add(1);
        resultList.add(secondList);

        if(numRows == 2){
            return resultList;
        }

        for(int i = 3; i <= numRows; i++){
            List<Integer> list = new ArrayList<>();

            list.add(1);

            for(int j = 1; j < i - 1; j++){
                List<Integer> lastList = resultList.get(resultList.size() - 1);

                list.add(lastList.get(j) + lastList.get(j - 1));
            }

            list.add(1);

            resultList.add(list);
        }

        return resultList;

    }
}
