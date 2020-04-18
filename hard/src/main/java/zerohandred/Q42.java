package zerohandred;

import org.junit.Test;

/**
 * 42. 接雨水
 * <p>
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * <p>
 * Created by Toddy on 2020/4/4.
 */
public class Q42 {

    @Test
    public void test() {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }

    /**
     *
     */
    public int trap(int[] height) {
        int lMax = 0;
        int rMax = 0;
        int lIdx = 0;
        int rIdx = height.length - 1;
        int ans = 0;
        while (lIdx < rIdx) {
            if (height[lIdx] < height[rIdx]) {
                if (lMax < height[lIdx]) {
                    lMax = height[lIdx];
                } else {
                    ans += lMax - height[lIdx];
                }
                lIdx++;
            } else {
                if (rMax < height[rIdx]) {
                    rMax = height[rIdx];
                } else {
                    ans += rMax - height[rIdx];
                }
                rIdx--;
            }
        }
        return ans;
    }
}
