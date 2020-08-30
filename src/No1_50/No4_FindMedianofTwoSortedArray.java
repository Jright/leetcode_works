package No1_50;

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

// Got the answer and great explaination on https://www.youtube.com/watch?time_continue=479&v=LPFhl65R7ww&feature=emb_logo
public class No4_FindMedianofTwoSortedArray {

    public static void main(String[] args){
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};
        double result = findMedianOfTwoSortedArray(nums1, nums2);
        System.out.println("result = " + result);
    }

    public static double findMedianOfTwoSortedArray(int[] nums1,int[] nums2){
        int x = nums1.length;
        int y = nums2.length;
        if(x > y){
            return findMedianOfTwoSortedArray(nums2, nums1);
        }

        int left = 0;
        int right = x;

        while(left <= right){
            int partitionX = left + (right - left) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

            if(maxLeftX <= minRightY && maxLeftY <= minRightX){
                // found the median group
                if((x + y) % 2 == 0){
                    return (double) (Math.max(maxLeftX, maxLeftY)
                            + Math.min(minRightX, minRightY)) / 2;
                }else{
                    return (double) (Math.max(maxLeftX, maxLeftY));
                }
            }else if(maxLeftX > minRightY){
                right = partitionX - 1;
            }else{
                left = partitionX + 1;
            }

        }

        throw new IllegalArgumentException("Illegal input arrays");
    }


}
