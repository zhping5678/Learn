package sort;

import java.util.Arrays;

//归并排序
public class MergeSort {
    private int count=0;

    //归并排序的拓展应用
    /*在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
    输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007*/
    public  int InversePairs(int[] array){
        mergeSort(array,0,array.length-1);
        return count%1000000007;
    }

    public void mergeSort(int [] array,int start, int end){
        if(array==null||start>=end){
            return;
        }
        int middle=(start+end)/2;
        mergeSort(array, start, middle);
        mergeSort(array, middle+1, end);

//        merge(array,start, middle,end);
        merge(start,middle,end,array);
    }
    public void merge(int left,int middle, int right, int []arr){
        int[] temp=new int[right-left+1];
        int pointer=0;
        int i=left;
        int j=middle+1;
        while (i<=middle && j<=right){
            if(arr[i]<=arr[j]){
                temp[pointer++]=arr[i++];
            }else{
                temp[pointer++]=arr[j++];
                count+=middle-i+1;
            }
        }
        while (i<=middle){
            temp[pointer++]=arr[i++];
        }
        while (j<=right){
            temp[pointer++]=arr[j++];
        }
        System.arraycopy(temp,0,arr,left,temp.length);
    }

    public void merge(int[] arr, int left,int middle, int right){
        int[] temp=new int[right-left+1];
        int pointer=0;
        int i=left;
        int j=middle+1;
        while (i<=middle && j<=right){
            if(arr[i]<=arr[j]){
                temp[pointer++]=arr[i++];
            }else{
                temp[pointer++]=arr[j++];
            }
        }
        while (i<=middle){
            temp[pointer++]=arr[i++];
        }
        while (j<=right){
            temp[pointer++]=arr[j++];
        }
        System.arraycopy(temp,0,arr,left,temp.length);
    }
}
