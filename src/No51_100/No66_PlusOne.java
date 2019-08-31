package No51_100;

// Source: https://leetcode.com/problems/plus-one/discuss/24082/My-Simple-Java-Solution
public class No66_PlusOne {

    public int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i++) {
           if(digits[i] < 9){
               digits[i]++;
               return digits;
           }

           digits[i] = 0;
        }

        int[] newArray = new int[digits.length + 1];
        newArray[0] = 1;
        return newArray;

    }

}
