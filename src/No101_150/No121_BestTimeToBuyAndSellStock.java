package No101_150;

public class No121_BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {

        if(prices.length <= 1){
            return 0;
        }

        int maxProfit = 0;

        int minIndex = 0;

        for(int i = 1; i < prices.length; i++){

            if(prices[i] - prices[minIndex] > maxProfit){
                maxProfit = prices[i] - prices[minIndex];
            }

            if(prices[i] < prices[minIndex]){
                minIndex = i;
            }
        }

        return maxProfit;

    }

}
