package ninehandred;

import org.junit.Test;

/**
 * 912. 排序数组
 * 给你一个整数数组 nums，请你将该数组升序排列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 * 示例 2：
 * <p>
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 *  
 * 提示：
 * <p>
 * 1 <= nums.length <= 50000
 * -50000 <= nums[i] <= 50000
 * <p>
 * Created by Toddy on 2020/3/31.
 */
public class Q912 {

    @Test
    public void test() {
        int[] nums = {1, 3, 5, 7, 4, 2};
        int[] ints = sortArray3(nums);
        for (int num : ints) {
            System.out.print(num + ",");
        }
    }

    /**
     * 冒泡排序
     */
    public int[] sortArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }

    /**
     * 快速排序
     */
    public int[] sortArray2(int[] nums) {

        return nums;
    }

    /**
     * 根据题目限制的范围，只要100001个桶就可以放下所有的数字，
     * 遍历数组，根据当前数字将50000+当前数字的桶数量加一，
     * 最后根据桶中的数字，数字是几就替换原数组中的几个位置，值为桶的索引-50000，将数组填满，
     * 注意，这里只要插入的数量达到原数组长度，就可以break了。
     */
    public int[] sortArray3(int[] nums) {
        int[] ints = new int[100001];
        for (int num : nums) {
            ints[num + 50000]++;
        }
        int idx = 0;
        for (int i = 0; i < ints.length; i++) {
            if (i > 0) {
                for (int j = 0; j < ints[i]; j++) {
                    nums[idx] = i - 50000;
                    idx++;
                }
                if (idx == nums.length) {
                    break;
                }
            }
        }
        return nums;
    }
}
