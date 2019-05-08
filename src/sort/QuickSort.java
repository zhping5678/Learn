package sort;

public class QuickSort {

    public void quickSort(int[] array){
        quickSort(array,0,array.length-1);
    }

    public void quickSort(int[] array,int left, int right){
        if(left<right){
            int pivotIndex = partition(array,left,right);
            quickSort(array,left,pivotIndex-1);
            quickSort(array,pivotIndex+1,right);
        }
    }

    private int partition(int [] arr, int left, int right){
        int pivot=arr[left];
        int low=left;
        int high=right;
        while (low<high){
            while (low<high && arr[high]>=pivot){
                high--;
            }
            while (low<high &&arr[low]<=pivot ){
                low++;
            }
            if(high>low) {
                swap(arr, low, high);
            }
        }

        arr[left]=arr[low];
        arr[low]=pivot;
        return low;
    }

    void swap(int[] arr,int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
