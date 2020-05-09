package No351_400;

public class No367_ValidPerfectSquare {

    public boolean isPerfectSquare(int num){
        if(num <= 1){
            return true;
        }

        // In case of the multiplication overflow for integer
        long left = 1;
        long right = num / 2;
        long mid = 0;
        long temp = 0;
        while(left <= right){
            mid = left + (right - left) / 2;
            temp = mid * mid;
            if(temp == num){
                return true;
            }else if(temp < num){
                // be careful with this boundary moving
                left = mid + 1;
            }else{
                // be careful with this boundary moving
                right = mid - 1;
            }
        }
        return false;
    }
}
