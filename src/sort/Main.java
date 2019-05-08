package sort;

public class Main {
    public static void main(String[] args){
        int[] array={7,6,5,4,3,2,1};
        int[] array2={1,2,3,4,5,6,0};
        int[] array3={2,1,3,0,9,-1,3,4};
//        new BubbleSort().bubbleSort2(array);
//        new SelectSort().selectSort(array);
//        new SelectSort().selectSort(array);
//        new MergeSort().mergeSort(array,0, array.length-1);
//        new QuickSort().quickSort(array);
//        for(int i:array){
//            System.out.print(i+" ");
//        }
        System.out.println(new MergeSort().InversePairs(array2));
    }
}
