package No451_500;

public class No476_NumberComplement {

    public int findComplement(int num) {
        if(num == 0){
            return 1;
        }

        int result = 0;
        int shift = 0;
        while(num != 0){
            int bit = (num & 1);
            if(bit == 1){
                bit = 0;
            }else{
                bit = 1;
            }
            result += (bit << shift);
            num = num >> 1;
            shift++;
        }

        return result;
    }
}
