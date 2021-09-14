package No1051_1100;

public class No1089_DuplicateZeros {

    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 0, 0, 0, 0, 7};
        duplicateZeros(arr);
        for (int num : arr) {
            System.out.println(num);
        }
    }

    public static void duplicateZeros(int[] arr) {
        int arrLength = arr.length;
        if (arrLength <= 1) {
            return;
        }

        int zeroCount = 0;

        for (int i = 0; i < arrLength; i++) {
            if (arr[i] == 0) {
                zeroCount++;
            }
        }

        if (zeroCount == 0) {
            return;
        }

        int newLength = arrLength + zeroCount;

        int j = newLength - 1;

        for (int i = arrLength - 1; i >= 0 && j >= 0; i--, j--) {
            if (arr[i] != 0) {
                if (j < arrLength) {
                    arr[j] = arr[i];
                }
            } else {
                if (j < arrLength) {
                    arr[j] = arr[i];
                }
                j--;
                if (j < arrLength) {
                    arr[j] = arr[i];
                }
            }
        }
    }
}
