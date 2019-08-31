package No1_50;//Symbol       Value
//        I             1
//        V             5
//        X             10
//        L             50
//        C             100
//        D             500
//        M             1000


import java.util.HashMap;

public class No13_RomanToInteger {

    public static void main(String[] args){
        System.out.println(romanToInt("MDXIX"));
    }

    public static int romanToInt(String s){
        HashMap<Character, Integer> romanMap = new HashMap<>();

        romanMap.put('I',1);
        romanMap.put('V',5);
        romanMap.put('X',10);
        romanMap.put('L',50);
        romanMap.put('C',100);
        romanMap.put('D',500);
        romanMap.put('M',1000);

        char[] chars = s.toCharArray();
        int result = 0;
        result += romanMap.get(chars[chars.length - 1]);

        for(int i = chars.length - 2; i >= 0; i--){
            if(romanMap.get(chars[i]) < romanMap.get(chars[i + 1])){
                result = result - romanMap.get(chars[i]);
            }else{
                result = result + romanMap.get(chars[i]);
            }
        }

        return result;

    }



}
