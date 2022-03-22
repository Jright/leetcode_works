package No1651_1700;

public class No1663_SmallestStringWithAGivenNumericValue {
    public String getSmallestString(int n, int k) {
        char[] result = new char[n];
        for(int position = 0; position < n; position++){
            int positionLeft = (n - position - 1);
            if(k > positionLeft * 26){
                int add = k - (positionLeft * 26);
                result[position] = (char)('a' + add - 1);
                k -= add;
            }else{
                result[position] = 'a';
                k--;
            }
        }
        return new String(result);
    }
}
