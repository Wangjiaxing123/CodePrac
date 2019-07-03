public class Sort {

    /**
     * 冒泡排序
     * @param arr
     * @return
     */
    public static int[] bubbleSort(int[] arr,int n){
        for (int i = n-1 ;i > 0;i-- ){
            // 如果长度为n,则总共冒n-1次
            for(int j = 0 ;j < i;j++){
                //每冒完一次，会得到一个最大值，排到最后面
                if (arr[j] > arr[j+1]){
                    SortUtils.swap(arr,j,j+1);
                }
            }
        }
        return arr;
    }

    /**
     * 选择排序
     * @param arr
     * @param n
     * @return
     */
    public static int[] sectionSort(int[] arr,int n){
        for(int i = 0;i < n-1;i++){
            // 如果长度为n,则需要选择n-1次，每次选择都会得出一个最小的数
            // i作为index最大会到n-2,不会出现越界
            for(int j = i+1;j <= n-1;j++){
                // j作为index最大会到n-1，不会出现越界
                if (arr[i] > arr[j]){
                    SortUtils.swap(arr,i,j);
                }
            }
        }
        return arr;
    }

    /**
     * 选择排序 优化
     * @param arr
     * @param n
     * @return
     */
    public static int[] sectionSort_1(int[] arr,int n){
        for(int i = 0;i < n-1;i++){
            // 如果长度为n,则需要选择n-1次，每次选择都会得出一个最小的数
            // i作为index最大会到n-2,不会出现越界
            int minIndex = i;
            for(int j = i+1;j <= n-1;j++){
                // j作为index最大会到n-1，不会出现越界
                if (arr[i] > arr[j]){
                    minIndex = j;
                }
            }
            if (minIndex != i){
                SortUtils.swap(arr,minIndex,i);
            }
        }
        return arr;
    }

    /**
     * 插入排序
     * @param arr
     * @param n
     * @return
     */
    public static int[] insertSort(int[] arr,int n){
        if (n == 0){
            return arr;
        }
        for (int i = 1;i< n;i++){
            for (int j = i;j > 0;j--){
                if (arr[j] < arr[j-1]){
                    SortUtils.swap(arr,j,j-1);
                }else{
                    break;
                }
            }
        }
        return arr;
    }





}
