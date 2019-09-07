package No101_150;

import java.util.ArrayList;
import java.util.List;

public class No119_PascalTriangleII {

    // This is a mathmatical solution.
    // Try search "pascal triangle mathematical formula".
    public List<Integer> getRow(int rowIndex){

        long base = 1;

        int deominator = 1;

        int molecule = rowIndex;

        List<Integer> result = new ArrayList<>();

        result.add(1);

        for(int i = 0; i < rowIndex; i++){
            base = base * (molecule --) / (deominator++);
            result.add((int) base);
        }
        return result;
    }
}
