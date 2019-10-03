public class Sort {

    //堆排序
    public static void heapSort(int[] array) {
        createHeapBig(array);
        for (int i = 0; i < array.length - 1; i++) {
            // 无序 [0, array.length - i)
            // 交换 array[0], array[length - i - 1]
            // 无序 [0, array.length - i - 1)
            // 无序长度 array.length - i - 1
            // 下标 0 进行向下调整
            swap(array, 0, array.length - i - 1);
            shiftDownBig(array, 0, array.length - i - 1);
        }
    }

    private static void createHeapBig(int[] array) {
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            shiftDownBig(array, i, array.length);
        }
    }

    private static void shiftDownBig(int[] array, int i, int size) {
        while (2 * i + 1 < size) {
            int max = 2 * i + 1;
            if (max + 1 < size && array[max+1] > array[max]) {
                max = max + 1;
            }
            if (array[i] >= array[max]) {
                return;
            }
            swap(array, i, max);
            i = max;
        }
    }

    private static void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
}
