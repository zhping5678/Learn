package sort;

//选择排序
public class SelectSort {

    public void selectSort(int [] array){
        int index;
        for(int i=0;i<array.length;i++){
            index=i;
            for(int j=i+1;j<array.length;j++){
                if(array[j]<array[index]){
                    index=j;
                }
            }
            //swap
            int temp=array[i];
            array[i]=array[index];
            array[index]=temp;
        }
    }
}
