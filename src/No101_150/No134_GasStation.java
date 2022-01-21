package No101_150;

public class No134_GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int deficit = 0;
        int sum = 0;
        int start = 0;

        for(int index = 0; index < n; index++){
            sum += gas[index];
            sum -= cost[index];

            if(sum < 0){
                deficit += sum;
                start = index + 1;
                sum = 0;
            }
        }
        return sum + deficit >= 0 ? start : -1;
    }
}
