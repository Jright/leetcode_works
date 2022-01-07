package No1051_1100;

public class No1094_CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] road = new int[1001];
        for(int trip[] : trips){
            road[trip[1]] += trip[0];
            road[trip[2]] -= trip[0];
        }

        int curr = 0;
        for(int index = 0; index < road.length; index++){
            curr += road[index];
            if(curr > capacity){
                return false;
            }
        }
        return true;
    }
}
