package No451_500;

public class No461_HammingDistance {

    public int hammingDistance(int x, int y) {
        int result = 0;

        if(x == y){
            return result;
        }

        while(x != y){
            int x0 = x & 1;
            int y0 = y & 1;
            if(x0 != y0){
                result++;
            }
            x = x >> 1;
            y = y >> 1;
        }

        return result;
    }

}
