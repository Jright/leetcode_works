import java.util.Arrays;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.

 Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

 Example 1:
 nums1 = [1, 3]
 nums2 = [2]

 The median is 2.0
 Example 2:
 nums1 = [1, 2]
 nums2 = [3, 4]

 The median is (2 + 3)/2 = 2.5

 */

//FIXME This merge method is O(m + n)
public class No4_FindMedianofTwoSortedArray {

    public static void main(String[] args){
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};
        float result = findMedianOfTwoSortedArray(nums1, nums2);
        System.out.println("result = " + result);
    }

    public static float findMedianOfTwoSortedArray(int[] nums1,int[] nums2){

        int low1 = 0, high1 = nums1.length - 1, low2 = 0, high2 = nums2.length - 1;
        int runner = 0;
        int[] result = new int[nums1.length + nums2.length];
        Arrays.fill(result,0);

        while(low1 <= high1 && low2 <= high2){
            result[runner++] = nums1[low1] >= nums2[low2] ? nums2[low2++] : nums1[low1++];
        }

        while(low1 <= high1){
            result[runner++] = nums1[low1++];
        }

        while(low2 <= high2){
            result[runner++] = nums2[low2++];
        }

        int mid = result.length / 2;

        for(Integer i : result){
            System.out.print(i + " ");
        }
        System.out.println();
        if(result.length % 2 == 0){
           return ((float) result[mid] + (float) result[mid - 1]) / 2 ;
        }else{
            return (float) result[mid];
        }
    }


}
