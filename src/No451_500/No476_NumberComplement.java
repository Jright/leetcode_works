package No451_500;

public class No476_NumberComplement {
    public int findComplement(int num) {
        if(num == 0){
            return 1;
        }

        int res = 0;
        int shift = 0;
        int curr = 0;
        int bit = 0;
        while(num != 0){
            bit = num & 1;
            curr = bit == 1 ? 0 : 1;
            res += (curr << shift);
            num = num >> 1;
            shift++;
        }
        return res;
    }
}
