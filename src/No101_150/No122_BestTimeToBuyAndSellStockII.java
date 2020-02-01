package No101_150;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// Comments of fun4LeetCode
//9158
//Last Edit: October 11, 2018 9:29 PM:
//I think we need some clarification on "you may not engage in multiple transactions " +
//        "at the same time (i.e., you must sell the stock before you buy again)".
//        If it is required that you cannot sell and buy on the same day, then the code
//        above is not following this rule, even though it will give you the right answer.
//        Just say we have prices given by [1, 2, 3], following this rule, if you buy at price
//        1 and then sell it at price 2, the profit is 1. But now you cannot buy at price 2
//        again and sell it at price 3, which will lose 1 profit. The right way to do is buy
//        at 1 and sell at 3, the profit is 3 - 1 = 3 - 2 + 2 - 1 = 2. So if this is the case,
//        you should at least convey this rule in your code. If not, then the code above is indeed a good one.
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
