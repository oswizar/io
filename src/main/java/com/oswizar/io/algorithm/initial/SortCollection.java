package com.oswizar.io.algorithm.initial;

import org.junit.Test;

/**
 * @date: 2019/5/28 10:32
 * @author: oswizar
 * @description:
 */
public class SortCollection {
    static int count = 0;

    private static final int[] arr = {23, 5, 1, 4, 2, 8, 16, 15, 28};

    /**
     * 交换数组元素
     *
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /**
     * @param arr
     */
    public static void selectSort(int[] arr) {
        // 只需要进行length-1轮比较，因为经过length-1轮之后就已经完全排好序
        for (int i = 0; i < arr.length - 1; i++) {
            // 每一趟循环比较时，minIndex用于存放最值的数组下标
            // 这样当前批次比较完毕最终存放的就是此趟内最小的元素的下标
            int minIndex = i;
            // 把当前元素(最值)与之后的每个元素逐位比较
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    // 把最值下标变更为符合要求的元素下标
                    minIndex = j;
                }
            }
            // 如果minIndex发生变化，则进行元素交换
            if (minIndex != i) {
                swap(arr, minIndex, i);
            }
        }
    }

    /**
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        // 只需要进行length-1轮比较，因为经过length-1轮之后就已经完全排好序
        for (int i = 0; i < arr.length - 1; i++) {
            // 设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已然完成
            boolean flag = true;
            // 每轮都从头开始比较，每轮都能找到最值
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    // 只要发生交换，更改flag的状态
                    flag = false;
                }
            }
            // 如果flag无变化，表示排序已完成，结束比较
            if (flag) {
                break;
            }
        }
    }

    /**
     * @param arr
     */
    public static void insertionSort(int[] arr) {
        // 为什么不是从[0]开始，[0]之前没有与[0]进行比较的元素
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            // 将要插入的新元素与之前的序列进行比较，确定新元素的位置
            while (j > 0 && arr[j] < arr[j - 1]) {
                swap(arr, j, j - 1);
                j--;
            }
        }
    }


    /**
     * @param arr
     */
    public static void shellSortBySwap(int[] arr) {
        // 增量gap,逐渐缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 从第gap个元素，逐个对其所在组进行直接插入排序操作
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                while (j >= gap && arr[j] < arr[j - gap]) {
                    // 插入排序采用交换法
                    swap(arr, j, j - gap);
                    j -= gap;
                }
            }
        }
    }


    /**
     * @param arr
     */
    public static void shellSortByMove(int[] arr) {
        // 增量gap,逐渐缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 从第gap个元素，逐个对其所在组进行直接插入排序操作
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[i - gap]) {
                    while (j >= gap && temp < arr[j - gap]) {
                        // 插入排序采用移动法
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
        }
    }

    // 6 1 2 7 9 3 4 5 10 8
    public static void quickSort(int[] arr, int left, int right) {
        int i, j, temp, t;
        // 递归终止条件
        if (left > right) {
            return;
        }

        i = left;
        j = right;

        // temp为基准数
        temp = arr[left];
        while (i != j) {
            while (temp <= arr[j] && i < j) {
                j--;
                System.out.println(count++);
            }

            while (temp >= arr[i] && i < j) {
                i++;
                System.out.println(count++);
            }
            // 如果满足条件就交换
            if (i < j) {
                t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        // 最后将基准数与i和j相等位置的数交换（之前已经temp = arr[left],交换只需再进行如下两步）
        arr[left] = arr[i];
        arr[i] = temp;

        // 递归处理左边的数组
        quickSort(arr, left, i - 1);
        // 递归处理右边的数组
        quickSort(arr, i + 1, right);

    }


    /**
     * 建堆调整
     *
     * @param arr             看作是完全二叉树
     * @param currentRootNode 当前节点位置
     * @param size            节点总数（数组长度）
     */
    public static void heapify(int[] arr, int currentRootNode, int size) {
        if (currentRootNode < size) {
            // 定义左右子树的位置
            int left = 2 * currentRootNode + 1;
            int right = 2 * currentRootNode + 2;

            // 把当前节点的位置看成是最大值的下标
            int max = currentRootNode;

            if (left < size) {
                // 如果比当前节点值大，记录位置
                if (arr[max] < arr[left]) {
                    max = left;
                }
            }
            if (right < size) {
                // 如果比当前节点值大，记录位置
                if (arr[max] < arr[right]) {
                    max = right;
                }
            }

            // 如果最大的不是根元素位置，那么交换
            if (max != currentRootNode) {
                int temp = arr[max];
                arr[max] = arr[currentRootNode];
                arr[currentRootNode] = temp;

                // 继续比较，直达完成一次建堆
                heapify(arr, max, size);
            }


        }
    }

    /**
     * 建堆，最大值在堆的顶部（根节点）
     *
     * @param arr  数组
     * @param size 数组长度
     */
    public static void maxHeapify(int[] arr, int size) {
        // 从数组的尾部开始建堆，直到第一个元素（角标为0）
        for (int i = size - 1; i >= 0; i--) {
            // 建堆调整
            heapify(arr, i, size);
        }
    }

    /**
     * 堆排序（建堆，交换；建堆，交换；...）
     *
     * @param arr  数组
     * @param size 数组长度
     */
    public static void heapSort(int[] arr, int size) {
        // 建堆，交换
        for (int i = 0; i < size; i++) {

            // 每次完成建堆就可以减少一个元素了
            maxHeapify(arr, size - i);

            // 交换
            int temp = arr[0];
            arr[0] = arr[size - 1 - i];
            arr[size - 1 - i] = temp;
        }

    }


    @Test
    public void test() {
//        int[] arr = {6, 10, 2, 7, 9, 3, 4, 5, 1, 8};
//        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        int[] arr = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
//                selectSort(arr);
//        bubbleSort(arr);
//        insertionSort(arr);
//                shellSortBySwap(arr);
//                shellSortByMove(arr);
        quickSort(arr, 0, arr.length - 1);
//        fun2(arr, arr.length);
//        fun3(arr);

//        heapSort(arr, arr.length);
        for (int item : arr) {
            System.out.println(item);
        }
    }

    void fun2(int Array[], int len) {
        int i = 0;
        int temp = 0;
        while (i < len) {
            temp++;
            if (i == 0 || Array[i - 1] < Array[i]) {
                i += temp;
                temp = 0;
            } else {
                int tempdata = Array[i];
                Array[i] = Array[i - 1];
                Array[i - 1] = tempdata;
                i--;
            }
        }
    }

    public void fun3(int[] arr) {

//        int a[]={22,3,6,54,86,21,35,1,65,4};
//         {6, 10, 2, 7, 9, 3, 4, 5, 1, 8}
        int team = arr.length - 1;
        for (int i = 0; i < team; i++) {
            boolean flag = true;
            if (arr[i] > arr[i + 1]) {
                int tem = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = tem;
                flag = false;
                System.out.println(count++);
            }
            if (i == team - 1) {
                if (flag) {
                    break;
                }
                i = -1;
                team--;
            }
        }

//        System.out.println("排好序：");
//        for(int aa:arr){
//            System.out.print(aa+" ");
//        }
    }

}
