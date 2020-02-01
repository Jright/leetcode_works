package No151_200;

public class No190_ReverseBits {

    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
//        int[] binary = new int[32];
//
//        for(int i = 0; i < binary.length; i++){
//            if(n == 0){
//                break;
//            }
//
//            binary[i] = n % 2;
//            n = n >> 1;
//        }
//
//        int result = 0;
//
//        for(int j = binary.length - 1; j >= 1; j--){
//            result += Math.pow(2, binary.length - 1 - j);
//        }
//
//        if(binary[0] == 1){
//            result = -result;
//        }
//        return result;
        if(n == 0){
            return 0;
        }

        int result = 0;
        for(int i = 0; i < 32; i++){
            result = result << 1;
            if((n & 1) == 1){
                result++;
            }
            n = n >> 1;
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] ints = reverseBits(5);
//        for(int i : ints){
//            System.out.print(i);
//        }
    }
}
