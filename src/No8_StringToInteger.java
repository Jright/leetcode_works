public class No8_StringToInteger {

    //TODO Unaccepted answer, too many corner cases. Check out atoi in Stlib.h(C)
    public static void main(String[] args){
        int beauty = myatoi("-91283472332");
        System.out.println(beauty);
    }

    public static int myatoi(String arg){

        if(arg.isEmpty() || arg.equals("-")){
            return 0;
        }

        int digitCount = 0;
        char[] chars = arg.toCharArray();

        if(isDigit(chars[0])){
            for(int i = 0; i < chars.length; i++){
                if(isDigit(chars[i])){
                    digitCount++;
                }else{
                    break;
                }
            }
            String substring = arg.substring(0, digitCount);
            Long aLong = Long.valueOf(substring);

            if(aLong > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }else if(aLong < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }else{
                return Integer.valueOf(substring);
            }

        }else if(chars[0] == '-'){
            digitCount = 1;
            for(int i = 1; i < chars.length; i++){
                if(isDigit(chars[i])){
                    digitCount++;
                }else{
                    break;
                }
            }
            String substring = arg.substring(1, digitCount);
            Long aLong = Long.valueOf(substring);

            if(aLong > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }else if(aLong < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }else{
                Integer integer = Integer.valueOf(substring);
                return -integer;
            }
        } else{
            return 0;
        }
    }

    public static boolean isDigit(char start){
        if(start <= '9' && start >= '0'){
            return true;
        }else{
            return false;
        }
    }

}
