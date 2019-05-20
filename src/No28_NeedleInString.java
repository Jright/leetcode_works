public class No28_NeedleInString {

    public static int strStr(String haystack, String needle) {
        if(needle == null || haystack == null){
            return -1;
        }

        if(haystack.length() < needle.length()){
            return -1;
        }

        if(needle.length() == 0){
            return 0;
        }

        int result = -1;
        int count = 0;
        String original = String.valueOf(haystack);
        while(haystack.length() >= needle.length()){
            haystack = original.substring(count);
            if(haystack.startsWith(needle)){
                return count;
            }else{
                count++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "issip";

        int i = strStr(haystack, needle);
        System.out.print(i);
    }


}
