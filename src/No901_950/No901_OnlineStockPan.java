package No901_950;

import java.util.Stack;

public class No901_OnlineStockPan {

    Stack<Integer> prices;
    Stack<Integer> weights;

    public No901_OnlineStockPan() {
        prices = new Stack<>();
        weights = new Stack<>();
    }

    public int next(int price) {
        int w = 1;
        while(!prices.isEmpty() && prices.peek() <= price){
            prices.pop();
            w += weights.pop();
        }

        prices.push(price);
        weights.push(w);
        return w;
    }

}
