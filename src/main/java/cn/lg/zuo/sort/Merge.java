package cn.lg.zuo.sort;

/**
 *
 * 归并排序： 分而治之
 *
 * 归并排序是稳定排序，它也是一种十分高效的排序，能利用完全二叉树特性的排序一般性能都不会太差。
 * java中Arrays.sort()采用了一种名为TimSort的排序算法，就是归并排序的优化版本。
 * 从上文的图中可看出，每次合并操作的平均时间复杂度为O(n)，而完全二叉树的深度为|log2n|。
 * 总的平均时间复杂度为O(nlogn)。而且，归并排序的最好，最坏，平均时间复杂度均为O(nlogn)。
 *
 * int[] tarArr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
 *
 * https://www.cnblogs.com/chengxiao/p/6194356.html
 *
 *
 * 思想: 二分递归 先排左边，在排右边，两个有序数组，用双指针排序 双指针排序（官方叫法不明）：前提为有序，申请一块 m+n
 * 大小的数组，利用双指针便利比较两部分，谁小谁放进新申请的数组中， 有一个到达终点就停止，将未停止的那个数组后边的数 再依次放进这个数组
 *
 * 小数和问题：一个数他的左边比他小的数之和，称谓小数和，求这个数组的小数和？ merge的时候，左边移动的时候，那么 右边的数都比这个数大
 *
 * 逆序数个数问题：一个数他的左边（未必是连续的）有比他自己小的几个数，就有几个逆序数，求这个输入的逆序数个数
 * 
 */
public class Merge {

    public static void mergeSort(int[] targetArr,int start,int end, int [] tempArr) {
        if(end <= start)
            return;

        /**
         * 优化
         * todo
         */
        int mid = (start + end) / 2;


        mergeSort(targetArr,start,mid,tempArr);
        mergeSort(targetArr,mid+1,end,tempArr);

        int leftIndex = start;
        int rightIndex = mid + 1;
//        排那部分，就用那部分的数组
        int tempIndex = start;


        do {
            if (targetArr[leftIndex] > targetArr[rightIndex]) {
                tempArr[tempIndex++] = targetArr[rightIndex++];
            } else {
                tempArr[tempIndex++] = targetArr[leftIndex++];
            }

            if (leftIndex > mid || rightIndex > end)
                break;

        } while (true);

        if (leftIndex > mid) {
            for (int i = rightIndex; i < end + 1; i++) {
                tempArr[tempIndex++] = targetArr[i];
            }
        }else {
            for (int i = leftIndex; i < mid+1; i++) {
                tempArr[tempIndex++] = targetArr[i];
            }
        }


        for (int i = start; i < end + 1 ; i++)
            targetArr[i] = tempArr[i];

    }



    public static int minSum(int[] targetArr,int start,int end, int [] tempArr) {
        int res = 0;

        if(end <= start)
            return res;

        /**
         * 优化
         */
//        int mid = (start + end) / 2;

//        位数运算比算数运算快  切能解决边界问题
        int mid = start + ((end -start ) >> 1);

        res += minSum(targetArr,start,mid,tempArr);
        res += minSum(targetArr,mid+1,end,tempArr);

        int leftIndex = start;
        int rightIndex = mid + 1;
//        排那部分，就用那部分的数组
        int tempIndex = start;


        do {
            if (targetArr[leftIndex] > targetArr[rightIndex]) {
                tempArr[tempIndex++] = targetArr[rightIndex++];
            } else {
//                +1 因为首位都用了
                res += targetArr[leftIndex] * (end - rightIndex + 1);
                tempArr[tempIndex++] = targetArr[leftIndex++];
            }

            if (leftIndex > mid || rightIndex > end)
                break;

        } while (true);

        if (leftIndex > mid) {
            for (int i = rightIndex; i < end + 1; i++) {
                tempArr[tempIndex++] = targetArr[i];
            }
        }else {
            for (int i = leftIndex; i < mid+1; i++) {
                tempArr[tempIndex++] = targetArr[i];
            }
        }


        for (int i = start; i < end + 1 ; i++)
            targetArr[i] = tempArr[i];


        return res;
    }


    //逆序数的个数
    public static int reversedOrder(int[] targetArr,int start,int end, int [] tempArr) {
        int res = 0;

        if(end <= start)
            return res;

        /**
         * 优化
         * todo
         */
//        int mid = (start + end) / 2;

//        位数运算比算数运算快  切能解决边界问题
        int mid = start + ((end -start ) >> 1);

        res += reversedOrder(targetArr,start,mid,tempArr);
        res += reversedOrder(targetArr,mid+1,end,tempArr);

        int leftIndex = start;
        int rightIndex = mid + 1;
//        排那部分，就用那部分的数组
        int tempIndex = start;


        do {
            if (targetArr[leftIndex] > targetArr[rightIndex]) {
                res += (mid - leftIndex + 1);
                tempArr[tempIndex++] = targetArr[rightIndex++];
            } else {
                tempArr[tempIndex++] = targetArr[leftIndex++];
            }

            if (leftIndex > mid || rightIndex > end)
                break;



        } while (true);

        if (leftIndex > mid) {
            for (int i = rightIndex; i < end + 1; i++) {
                tempArr[tempIndex++] = targetArr[i];
            }
        }else {
            for (int i = leftIndex; i < mid+1; i++) {
                tempArr[tempIndex++] = targetArr[i];
            }
        }


        for (int i = start; i < end + 1 ; i++)
            targetArr[i] = tempArr[i];


        return res;
    }




    public static void main(String[] args) {
        int[] tarArr = {7, 6, 5, 4, 2, 1, 3};
//        最终的排序需要一个长度为 target.length 的数组
        int[] tempArr = new int[tarArr.length];
//        mergeSort(tarArr,0,tarArr.length-1,tempArr);
//        System.out.println(minSum(tarArr, 0, tarArr.length - 1, tempArr));
        System.out.println(reversedOrder(tarArr, 0, tarArr.length - 1, tempArr));


        for (int i : tarArr) {
            System.out.println(i);
        }
    }
}
