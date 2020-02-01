package No151_200;

public class No172_FactorialTrailingZeroes {

    public int trailingZeroes(int n) {
        return n == 0 ? 0 : (n / 5) + trailingZeroes(n / 5);
    }
}
