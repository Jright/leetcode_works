package No1_50;

// Copied answer
// https://leetcode.wang/leetCode-50-Pow.html
public class No50_Pow {

    public double myPow(double x, int n) {

        if(x == -1){
            if((n & 1) != 0){
                return -1;
            }else{
                return 1;
            }
        }

        if(x == 1){
            return 1;
        }

        if(n == Integer.MIN_VALUE){
            return 0;
        }

        double multiply = 1;

        if(n > 0){
            // for(int i = 0; i < n; i++){
            //      multiply *= x;
            // }
            multiply = helper(x, n);
        }else{
            n = -n;
            // for(int i = 0; i < n; i++){
            //     multiply *= x;
            // }
            multiply = helper(x, n);
            multiply = 1 / multiply;
        }

        return multiply;
    }

    private double helper(double x, int n){
        if(n == 0){
            return 1;
        }

        if((n & 1) == 0){
            double temp = helper(x, n / 2);
            return temp * temp;
        }else{
            double temp = helper(x, n / 2);
            return temp * temp * x;
        }
    }

}
