package other;

/**
 * 面试题51. 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * 示例 1:
 * <p>
 * 输入: [7,5,6,4]
 * 输出: 5
 * <p>
 * 限制：
 * 0 <= 数组长度 <= 50000
 * <p>
 * Created by Toddy on 2020/4/24.
 */
public class Q51 {

    private int res = 0;
    public int reversePairs(int[] nums) {
        int len = nums.length;

        //为了不改变原数组 新copy个数组进行计算
        int[] copy = new int[len];
        for(int i=0;i<len;i++){
            copy[i]=nums[i];
        }

        //归并排序
        mergeSort(copy,0,len-1);
        return res;
    }

    /**
     *nums 待排序数组
     *left 当前待排序区间的左下标
     *right 当前待排序区间的右下标
     */
    private void mergeSort(int[] nums,int left,int right){
        if(left>=right)return;

        //求中点 划分左右两个区间 递归排序
        int mid = (left+right)/2;
        mergeSort(nums,left,mid);
        mergeSort(nums,mid+1,right);

        //利用一个tmp辅助数组 开始对左右两个排序后的区间合并
        int l = left,r=mid+1,cur=0;
        int[] tmp = new int[right-left+1];
        while(l<=mid&&r<=right){
            //左边区间数小于等于右边 左边先放入tmp 并更新左边指针
            if(nums[l]<=nums[r]){
                tmp[cur]=nums[l++];
                //相对于正常归并排序多出的一个步骤 计算有多少个逆序对
                res+=r-(mid+1);
            }else{
                tmp[cur]=nums[r++];
            }
            cur++;
        }
        //如果右边节点先到右区间边界导致上边while退出
        while(l<=mid){
            tmp[cur++]=nums[l++];
            //相对于正常归并排序多出的一个步骤 计算有多少个逆序对
            res+=r-(mid+1);
        }
        while(r<=right){
            tmp[cur++]=nums[r++];
        }

        //将待排序数组 当前排好序的left~right区间重新赋值
        for(int i=0;i<tmp.length;i++){
            nums[left+i]=tmp[i];
        }

    }
}
