

import me.newtrekwang.codeprac.class01.Sort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        int[] temp = {9,8,7,32,4,6,8};
        System.out.println("排序前："+Arrays.toString(temp));
        temp = Sort.mergeSort(temp,7);
        System.out.println("排序后："+Arrays.toString(temp));
    }
}
