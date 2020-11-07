package cn.lg.leetcode;

public class MountainArray {

    public static boolean fun (){
        int[] arr = {0, 3, 2, 1};

        /**
         * 起  升   将
         * 0   1    2
         *
         */
        int state = 0;

        for (int i = 0; i < arr.length-1; i++) {
            if (state == 0 && arr[i] < arr[i + 1]) {
                state = 1;
            } else if (state == 0 && arr[i] > arr[i + 1]) {
                return false;
            }

            if (state == 1 && arr[i] > arr[i + 1]) {
                state = 2;
            }

            if (state == 2 && arr[i] < arr[i + 1]) {
                return false;
            }

        }
        return true;
    }
    public static void main(String[] args) {

        System.out.println(fun());
    }
}
