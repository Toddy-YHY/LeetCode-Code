package zerohandred;

import org.junit.Test;

/**
 * Created by Toddy on 2020/3/23.
 */
public class Q35 {

    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 4, 7, 9};
        System.out.println(searchInsert2(nums, 3));
    }

    /**
     * 遍历数组,边界判断
     */
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                return i;
            }
            if (nums[i] > target) {
                return i;
            }
        }
        return nums.length;
    }

    /**
     * 二分查找更快
     */
    public int searchInsert2(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int left = 0;
        int right = len;
        while (left < right) {
            int i = (left + right) >>> 1;
            if (nums[i] < target) {
                left = i + 1;
            } else {
                right = i;
            }
        }
        return left;
    }
}
