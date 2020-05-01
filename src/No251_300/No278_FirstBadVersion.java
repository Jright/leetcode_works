package No251_300;

public class No278_FirstBadVersion {
    public int firstBadVersion(int n) {
        if(n <= 1){
            return n;
        }

        int left = 1;
        int right = n;
        int mid = left + ((right - left) / 2);
        while(left < right){
            if(isBadVersion(mid)){
                right = mid;
            }else{
                left = mid + 1;
            }
            mid = left + ((right - left) / 2);
        }
        return mid;
    }

    /**
     * Fake function
     * @return
     */
    public boolean isBadVersion(int index){
        return false;
    }
}
