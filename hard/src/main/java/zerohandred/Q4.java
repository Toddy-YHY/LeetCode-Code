package zerohandred;

import org.junit.Test;

/**
 * 4. 寻找两个有序数组的中位数
 * <p>
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 * Created by Toddy on 2020/3/20.
 */
public class Q4 {

    @Test
    public void test() {
        int[] num1 = new int[]{1, 2, 3};
        int[] num2 = new int[]{2, 4, 5, 7};
        //中位数为3.0
        System.out.println(findMedianSortedArrays(num1, num2));
    }

    /**
     *
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        return 0;
    }
}
