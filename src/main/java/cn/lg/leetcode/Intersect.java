package cn.lg.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 说明：
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 *
 *
 * 进阶：
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2y0c2/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 */
public class Intersect {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1},nums2={2, 2};

        System.out.println(Arrays.toString(intersect(nums1, nums2)));

    }

    /**
     * 将两个无序的 数组中，较小的那个放进table
     * 变量长arr 从table中找计算
     *
     * @param nums1
     * @param nums2
     */
    public  static  int[]   intersect(int[] nums1, int[] nums2){
        HashMap<Integer, Integer> table = new HashMap<>();
        int[] minArr;
        int[] maxArr;
        int[] res;
        int index = 0;
        if (nums1.length > nums2.length) {
            maxArr = nums1;
            minArr = nums2;
            res = new int[nums2.length];
        }else {
            maxArr = nums2;
            minArr = nums1;
            res = new int[nums1.length];
        }

        for (int num : minArr) {
            table.put(num, (table.get(num) == null ? 0 : table.get(num)) +1);
        }


        for (int mNum : maxArr) {
            if (table.containsKey(mNum) && table.get(mNum) > 0) {
                res[index++] = mNum;
                table.put(mNum, table.get(mNum) - 1);
            }
        }

        return Arrays.copyOfRange(res, 0, index);

    }
}
