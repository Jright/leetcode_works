package No601_650;

public class No605_CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int ans = 0;

        for (int index = 0; index < flowerbed.length; index++) {

            if (flowerbed[index] == 1) {
                continue;
            }

            if (index - 1 >= 0 && flowerbed[index - 1] == 1) {
                continue;
            }

            if (index + 1 <= flowerbed.length - 1 && flowerbed[index + 1] == 1) {
                continue;
            }

            ans++;
            if(ans >= n){
                return true;
            }

            flowerbed[index] = 1;
        }
        return ans >= n;
    }
}
