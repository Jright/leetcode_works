package No1651_1700;

public class No1672_RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for(int index = 0; index < accounts.length; index++){
            int curr = 0;
            for(int j = 0; j < accounts[index].length; j++){
                curr += accounts[index][j];
            }
            max = Math.max(curr, max);
        }
        return max;
    }
}
