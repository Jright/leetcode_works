package No1_50;

public class No10_RegularExpressionMatching {

    public static void main(String[] args) {
        System.out.println(isMatch("Parz", "Z*rz"));
    }

    public static boolean isMatch(String text, String pattern){

        if(pattern.isEmpty()){
            return text.isEmpty();
        }

        boolean isFirstMatch = !text.isEmpty() && (text.charAt(0) == pattern.charAt(0) || pattern.charAt(0) == '.');

        if(pattern.length() >= 2 && pattern.charAt(1) == '*'){

//            If a star is present in the pattern, it will be in the second position \text{pattern[1]}pattern[1]
//            Then, we may ignore this part of the pattern, or delete a matching character in the text  //TODO Why????
//            If we have a match on the remaining strings after any of these operations, then the initial inputs matched.
            return (isFirstMatch && isMatch(text.substring(1), pattern)) || isMatch(text, pattern.substring(2));

        }else{

            return isFirstMatch && isMatch(text.substring(1), pattern.substring(1));

        }

    }


}
