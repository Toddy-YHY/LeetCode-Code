package other;

import org.junit.Test;

/**
 * 面试题 16.03. 交点
 * 给定两条线段（表示为起点start = {X1, Y1}和终点end = {X2, Y2}），如果它们有交点，请计算其交点，没有交点则返回空值。
 * <p>
 * 要求浮点型误差不超过10^-6。若有多个交点（线段重叠）则返回 X 值最小的点，X 坐标相同则返回 Y 值最小的点。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * line1 = {0, 0}, {1, 0}
 * line2 = {1, 1}, {0, -1}
 * 输出： {0.5, 0}
 * 示例 2：
 * <p>
 * 输入：
 * line1 = {0, 0}, {3, 3}
 * line2 = {1, 1}, {2, 2}
 * 输出： {1, 1}
 * 示例 3：
 * <p>
 * 输入：
 * line1 = {0, 0}, {1, 1}
 * line2 = {1, 0}, {2, 1}
 * 输出： {}，两条线段没有交点
 *  
 * <p>
 * 提示：
 * <p>
 * 坐标绝对值不会超过 2^7
 * 输入的坐标均是有效的二维坐标
 * <p>
 * Created by Toddy on 2020/4/12.
 */
public class Q16_03 {

    @Test
    public void test() {

    }

    public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        int x1 = start1[0];
        int y1 = start1[1];
        int x2 = end1[0];
        int y2 = end1[1];
        int x3 = start2[0];
        int y3 = start2[1];
        int x4 = end2[0];
        int y4 = end2[1];
        boolean hasAnswer = false;

        double[] ans = new double[2];
        if ((y4 - y3) * (x2 - x1) == (y2 - y1) * (x4 - x3)) {
            if ((y2 - y1) * (x3 - x1) == (y3 - y1) * (x2 - x1)) {
                if (inside(x1, y1, x2, y2, x3, y3)) {
                    hasAnswer = update(ans, (double) x3, (double) y3, hasAnswer);
                }
                if (inside(x1, y1, x2, y2, x4, y4)) {
                    hasAnswer = update(ans, (double) x4, (double) y4, hasAnswer);
                }
                if (inside(x3, y3, x4, y4, x1, y1)) {
                    hasAnswer = update(ans, (double) x1, (double) y1, hasAnswer);
                }
                if (inside(x3, y3, x4, y4, x2, y2)) {
                    hasAnswer = update(ans, (double) x2, (double) y2, hasAnswer);
                }
            }
        } else {
            double t1 = (double) (x3 * (y4 - y3) + y1 * (x4 - x3) - y3 * (x4 - x3) - x1 * (y4 - y3)) / ((x2 - x1) * (y4 - y3) - (x4 - x3) * (y2 - y1));
            double t2 = (double) (x1 * (y2 - y1) + y3 * (x2 - x1) - y1 * (x2 - x1) - x3 * (y2 - y1)) / ((x4 - x3) * (y2 - y1) - (x2 - x1) * (y4 - y3));
            if (t1 >= 0.0 && t1 <= 1.0 && t2 >= 0.0 && t2 <= 1.0) {
                ans[0] = x1 + t1 * (x2 - x1);
                ans[1] = y1 + t1 * (y2 - y1);
                hasAnswer = true;
            }
        }
        if (hasAnswer) {
            return ans;
        }
        return new double[0];
    }

    // 判断 (xk, yk) 是否在「线段」(x1, y1)~(x2, y2) 上
    private boolean inside(int x1, int y1, int x2, int y2, int xk, int yk) {
        return (x1 == x2 || (Math.min(x1, x2) <= xk && xk <= Math.max(x1, x2))) && (y1 == y2 || (Math.min(y1, y2) <= yk && yk <= Math.max(y1, y2)));
    }

    private boolean update(double[] ans, double xk, double yk, boolean hasAnswer) {
        if (!hasAnswer || xk < ans[0] || (xk == ans[0] && yk < ans[1])) {
            ans[0] = xk;
            ans[1] = yk;
            return true;
        }
        return hasAnswer;
    }
}
