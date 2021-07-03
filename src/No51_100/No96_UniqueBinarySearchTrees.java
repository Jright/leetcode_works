package No51_100;

public class No96_UniqueBinarySearchTrees {

    public int numTrees(int n) {
        if(n <= 1){
            return n;
        }

        int[] array = new int[n + 1];
        array[0] = 1;
        array[1] = 1;

        for(int index = 2; index <= n; index++){
            for(int index2 = 1; index2 <= index; index2++){
                array[index] += array[index2 - 1] * array[index - index2];
            }
        }

        return array[n];
    }
}
