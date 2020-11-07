package cn.lg.sort;

/**
 * 各种排序 被时代抛弃的排序： 冒泡排序（每次找一个放在最后） O（n*n） 选择排序（每次找一个放在最前） O(n*n)
 *
 * 插入排序 (抓牌) 在最差的情况下，完全逆序的情况下 O（n*n）
 */
public class Base {

    public static final int[] arr = {4, 5, 3, 2, 1};


    static {
        System.out.println("aa");
        MaoPao();
    }
    /**
     * 冒泡排序
     * 从头到位的便利，每次比较，并将大的向后排
     * 每次排出一个，放到后头
     */
    public static void MaoPao() {
        int n = 1;
        //如果共计5个数，那么排4个数之后，第5个数自然就排好序了
        while (n < arr.length) {
            for (int i = 0; i < arr.length - n; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            n++;
        }

        printArr();
    }

    public static void printArr() {
        for (int num : arr) {
            System.out.println(num);
        }
    }


    /**
     * 选择排序
     * 遍历一遍，找到一个最小的，放在第一位
     * 如此循环
     */
    public static void xuanZe() {
        int index = 0;
        while (index < arr.length - 1) {
            int minIndex = index;
            for (int i = minIndex + 1; i < arr.length; i++) {
                if (arr[minIndex] > arr[i]) {
                    minIndex = i;
                }
            }
            if (minIndex != index) {
                int temp = arr[index];
                arr[index] = arr[minIndex];
                arr[minIndex] = temp;
            }

            index++;
        }
        printArr();
    }


    /**
     * 插入排序，向抓牌一样，每次拿到一张新牌，就拍一遍，使手里的盘总是有序的
     */
    public static void insert() {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
        printArr();
    }

    public static void main(String[] args) {
//        MaoPao();
//        xuanZe();
        insert();
    }


}
