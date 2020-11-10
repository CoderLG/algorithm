package cn.lg.zuo.sort;

import java.util.Random;

/**
 * 递归的时间复杂度
 * T(n)=aT(n/b)+o(n^d)
 * n是总的样本量   n/b是子的样本量
 *
 * log(b,a) > d    o(n^log(b,a))
 * log(b,a) = d    o(n^d * log(n))
 * log(b,a) < d    o(n^d)
 *
 *
 * 快速排序：排第一个数，左小右大，递归
 */
public class Quick {
    public static int[] arr = {49, 38, 65, 97, 76, 13, 27, 49};
    int[] ar = new int[1];
    public static final Random random = new Random() ;


    /**
     * 将代表荷兰国旗的最右边的数，与其相同的数放到中间，大数放右边，小数放左边
     *
     * 低位放小的  高位放大的 中间放中间的
     */

    public static void  swap(int[] arr, int start, int end) {
        if (end <= start)
            return;

        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    public static int[] nationalFlag(int[] arr, int start, int end){
        int randmonNum= random.nextInt(end - start) + start+1;
        System.out.println("randmonNum is " + randmonNum);
        int targetNum = arr[randmonNum];
        int low = start;
        int hight = end;
        int index = start-1;
        while (low <= hight) {
            if (arr[low] < targetNum) {
                swap(arr, ++index, low++);
            } else if (arr[low] == targetNum) {
                low++;
            } else {
                swap(arr,low,hight--);
            }
        }
        return new int[]{index,low};
    }

    /**
     * 经典快排 取一个数，比他大的放右边，比他小的数放左边  递归
     * @param arr
     * @param start
     * @param end
     */
    public static void quickSort(int[] arr, int start, int end) {
        boolean startRun = false;
        int targetNum = arr[start];
        int startN = start;
        int endN = end;


        while (start < end) {
            if (startRun) {
                if (targetNum < arr[start]) {
                    arr[end] = arr[start];
                    arr[start] = targetNum;
                    startRun = false;
                    end--;
                } else {
                    start++;
                }
            } else {
                if (targetNum > arr[end]) {
                    arr[start] = arr[end];
                    arr[end] = targetNum;
                    startRun = true;
                    start++;
                } else {
                    end--;
                }
            }
        }

        if (startN < start - 1)
            quickSort(arr, startN, start - 1);
        if (start + 1 < endN)
            quickSort(arr, start + 1, endN);


    }

    /**
     * 基于荷兰国旗的快排  相等的不用再次排序  增加随机因子 使其时间复杂度稳定在 O(n * logn)
     *
     * @param arr
     * @param start
     * @param end
     */
    public  static  void   quickSortBaseOnNationalFlag(int[] arr, int start, int end) {

        if (end <= start)
            return;

        int randmonNum= random.nextInt(end - start) + start+1;
//        System.out.println("randmonNum is " + randmonNum);
        int targetNum = arr[randmonNum];
        int low = start;
        int hight = end;
        int index = start-1;
        while (low <= hight) {
            if (arr[low] < targetNum) {
                swap(arr, ++index, low++);
            } else if (arr[low] == targetNum) {
                low++;
            } else {
                swap(arr,low,hight--);
            }
        }

        quickSortBaseOnNationalFlag(arr, start, index);

        quickSortBaseOnNationalFlag(arr, low, end);



    }

    public static void main(String[] args) {
//        nationalFlag(arr, 0, arr.length - 1);
//        quickSort(arr, 0, arr.length - 1);
        quickSortBaseOnNationalFlag(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + "   ");
        }
        System.out.println();
    }


}
