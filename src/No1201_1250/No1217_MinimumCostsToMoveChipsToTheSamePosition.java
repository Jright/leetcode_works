package No1201_1250;

public class No1217_MinimumCostsToMoveChipsToTheSamePosition {

    public int minCostToMoveChips(int[] position) {
        int evenCount = 0;
        int oddCount = 0;

        for(int index = 0; index < position.length; index++){
            if(position[index] % 2 == 0){
                evenCount++;
            }else{
                oddCount++;
            }
        }
        return Math.min(evenCount, oddCount);
    }
}
