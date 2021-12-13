package No1401_1450;

public class No1446_ConsecutiveCharacters {
    public int maxPower(String s) {
        int max = 1;

        int curr = 1;

        char lastChar = s.charAt(0);

        for(int index = 1; index < s.length(); index++){
            if(s.charAt(index) == lastChar){
                curr++;
                if(curr > max){
                    max = curr;
                }
            }else{
                curr = 1;
                lastChar = s.charAt(index);
            }
        }
        return max;
    }
}
