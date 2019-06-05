public class SortUtils {
    /**
     * 交换值
     * @param arr
     * @param index1
     * @param index2
     */
    public static void swap(int[] arr,int index1,int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
