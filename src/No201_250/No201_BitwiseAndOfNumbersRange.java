package No201_250;

public class No201_BitwiseAndOfNumbersRange {

    public int rangeBitwiseAnd(int m, int n){
        int shift = 0;
        while(m != n){
            m >>= 1;
            n >>= 1;
            shift++;
        }
        return m << shift;
    }
}
