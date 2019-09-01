package No51_100;

public class No88_MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = nums1.length - 1;

        int i1 = m - 1;
        int i2 = n - 1;

        while (i >= 0) {

            if (i1 >= 0 && i2 >= 0) {
                if (nums1[i1] > nums2[i2]) {
                    nums1[i] = nums1[i1];
                    i1--;
                } else {
                    nums1[i] = nums2[i2];
                    i2--;
                }
            } else if (i1 >= 0) {
                nums1[i] = nums1[i1];
                i1--;
            } else if (i2 >= 0) {
                nums1[i] = nums2[i2];
                i2--;
            }
            i--;

        }
    }

        public static void main (String[]args){

            int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};

            int m = 3;

            int[] nums2 = new int[]{2, 5, 6};

            int n = 3;

            merge(nums1, m, nums2, n);

            for (int i = 0; i < nums1.length; i++) {
                System.out.println(nums1[i]);
            }
        }
    }
