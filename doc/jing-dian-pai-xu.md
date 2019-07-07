# 交换

```
/**
     * 交换值
     * @param arr
     * @param index1
     * @param index2
     */
    public static void swap(int[] arr,int index1,int index2){
             int temp=arr[index1];
             arr[index1]=arr[index2];
             arr[index2]=temp;
    }
```

# 冒泡排序

```
 /**
     * 冒泡排序 
     * @param a 数组
     * @param n 个数
     * @return
     */
         public static int[] bubbleSort_1(int[] a,int n){
             for(int i= n-1;i > 0;i--){
                 for(int j = 0;j < i;j++){
                     if(a[j] > a[j+1]){
                         int temp = a[j];
                         a[j] = a[j+1];
                         a[j+1] = temp;
                     }
                 }
             }
             return a;
         }
```
# 选择排序实现1

```java
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
                    me.newtrekwang.codeprac.class01.SortUtils.swap(arr,i,j);
                }
            }
        }
        return arr;
    }
```


# 选择排序实现2

```
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
                me.newtrekwang.codeprac.class01.SortUtils.swap(arr,minIndex,i);
            }
        }
        return arr;
    }
```

# 插入排序

```
    /**
     * 插入排序
     * @param A
     * @param n
     * @return
     */
    public static int[] insertionSort(int[] A,int n){
        for (int i=1;i<n;i++){
            for (int j=i;j>0;j--){
                if (A[j]<A[j-1]){
                    swap(A,j,j-1);
                }else {
                    break;
                }
            }
        }
        return A;
    }
```

# 归并排序

1,基于分治法，基本思路是对于两个有序的数组，将其合并为一个有序数组，可以很容易写出代码，并且时间复杂度为O\(n\)

```
public void merge(int[] a, int[] b, int[] c){
    int i=0,j=0,k=0;
    while (i<=a.length && j<=b.length){
        if (a[i]<=b[i]){
            c[k++]=a[i++];
        }
        else{
            c[k++]=b[j++];
        }
    }
    while (i<=a.length){
        c[k++]=a[i++];
    }
    while (j<=b.length){
        c[k++]=b[j++];
    }
}
```

2.假如有一个无序数组需要排序，但它的两个完全划分的子数组A和B分别有序，借助上述代码，很容易实现

3.那么，如果A,B无序，怎么办呢？可以把它们再分成更小的数组。

4.如此一直划分到最小，每个子数组都只有一个元素，则可以视为有序数组。

5.从这些最小的数组开始，逆着上面的步骤合并回去，整个数组就排好了。

总而言之，归并排序就是使用递**归**，先分解数组为子数组，再合**并**数组。

```
 public int[] mergeSort(int[] A, int n) {
        // write code here
        int[] temp=new int[n];
         internalMergeSort(A,temp,0,n-1);
        return temp;
    }
    
    public static void internalMergeSort(int[] arr,int[] temp,int left,int right){
        //当left==right时，不用再划分了
        if(left<right){
            int middle=(left+right)/2;
            internalMergeSort(arr,temp,left,middle);
            internalMergeSort(arr,temp,middle+1,right);
            mergeSortedArray(arr,temp,left,middle,right);
            
        }
    }
    
     // 合并两个有序子序列 arr[left, ..., middle] 和 arr[middle+1, ..., right]。temp是辅助数组。
    public static void mergeSortedArray(int arr[], int temp[], int left, int middle, int right){
        int i=left;
        int j=middle+1;
        int k=0;
        while(i<=middle&&j<=right){
            if(arr[i]<=arr[j]){
                temp[k++]=arr[i++];
            }
            else{
                temp[k++]=arr[j++];
            }
        }
        //剩余的放进去
        while(i<=middle){
            temp[k++]=arr[i++];
        }
        //剩余的放进去
        while(j<=right){
            temp[k++]=arr[j++];
        }
        
        //把数组复制回原数组
        for(i=0;i<k;++i){
            arr[left+i]=temp[i];
        }
        
    }
```

# 桶排序




