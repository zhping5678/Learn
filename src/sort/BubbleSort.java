package sort;

//Bubble Sort
public class BubbleSort {

    public void bubbleSort1(int [] array){
        for(int i=1;i<array.length;i++){
            for(int j=0;j<array.length-i;j++){
                if(array[j]>array[j+1]){
                    //swap
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
    }
    //improve 判断上一次是否有交换
    public void bubbleSort2(int [] array){
        boolean hasSwap=false;
        for(int i=1;i<array.length;i++){
            for(int j=0;j<array.length-i;j++){
                if(array[j]>array[j+1]){
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                    hasSwap=true;
                }
            }
            if(!hasSwap){
                break;
            }
        }
    }
}
