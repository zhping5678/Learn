package sort;

//插入排序
public class InsertSort {

    public void insertSort(int[] array){
        int temp;
        for(int i=1;i<array.length;i++){
            temp=array[i];
            int j=i-1;
            while ((j>=0)&&(array[j]>temp)) {
                array[j + 1] = array[j];
                j--;
            }
            array[j+1]=temp;
        }
    }
}
