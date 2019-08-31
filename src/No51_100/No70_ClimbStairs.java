package No51_100;

import java.util.HashMap;

public class No70_ClimbStairs {

    static HashMap<Integer, Integer> map = new HashMap<>();

    public static int climbStairs(int n) {

        if(n == 0 || n == 1){
            return 1;
        }

        if(map.containsKey(n)){
            return map.get(n);
        }

        int current = climbStairs(n - 1) + climbStairs(n - 2);
        map.put(n, current);
        return current;

    }

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
}
