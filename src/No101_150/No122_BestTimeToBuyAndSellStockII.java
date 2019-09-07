package No101_150;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class No122_BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {

        if(prices.length <= 1){
            return 0;
        }

        int profit = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        int buy = 0;
        int sell = buy + 1;
        for(int i = 1; i < prices.length; i++){


            if(prices[i] > prices[i - 1]){
                // Don't sell for now
                if(i == prices.length - 1){
                    // If it is the last day then we have to sell it...
                    sell = i;
                    map.put(buy, sell);
                }
            }else{
                // We go back to the past and sell it...
                sell = i - 1;
                if(sell > buy){
                    map.put(buy, sell);
                }

                buy = i;
                sell = buy + 1;

            }
        }

        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, Integer> next = iterator.next();
            profit += prices[next.getValue()] - prices[next.getKey()];
        }


        return Math.max(profit, 0);

    }

}
