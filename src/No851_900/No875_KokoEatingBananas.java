package No851_900;

public class No875_KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1;

        for(int pile : piles){
            right = Math.max(right, pile);
        }

        int mid;

        while(left < right){
            mid = left + (right - left) / 2;
            int hourSpent = 0;
            for(int pile : piles){
                hourSpent += Math.ceil((double) pile / mid);
            }

            if(hourSpent <= h){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return right;
    }
}
