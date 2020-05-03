package No751_800;

import java.util.ArrayList;
import java.util.List;

public class No763_PartitionLabels {

    public List<Integer> partitionLabels(String S) {
        List<Integer> resultList = new ArrayList<>();
        int[] last = new int[26];

        for(int i = 0; i < S.length(); i++){
            last[S.charAt(i) - 'a'] = i;
        }

        int j = 0;
        int anchor = 0;

        for(int i = 0; i < S.length(); i++){
            j = Math.max(j, last[S.charAt(i) - 'a']);
            if(i == j){
                resultList.add(i - anchor + 1);
                anchor = i + 1;
            }
        }

        return resultList;

    }

}
