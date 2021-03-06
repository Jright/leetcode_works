package No51_100;

public class No69_Sqrt {

    // Two tricks, the binary search and the long data type (in case int multiply overflows)
    public int mySqrt(int y) {
        long mid;
        long start = 0;
        long end = (long)y + 1;
        int ans = 0;
        while(start < end){
            mid = (start + end) / 2;
            if(guess(mid, y)){
                ans = (int) mid;
                mid = mid + 1;
                start = mid;
            }else{
                end = mid;
            }
        }

        return ans;
    }

    public boolean guess(long x, long y){
        return x * x <= y;
    }
}
