package No351_400;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No362_DesignHitCounter {

    private Queue<Integer> hits;

    public No362_DesignHitCounter() {
        this.hits = new LinkedList<>();
    }

    public void hit(int timestamp) {
        this.hits.add(timestamp);
    }

    public int getHits(int timestamp) {
        while(!this.hits.isEmpty()){
            int diff = timestamp - this.hits.peek();
            if(diff >= 300){
                this.hits.remove();
            }else{
                break;
            }
        }
        return this.hits.size();
    }
}
