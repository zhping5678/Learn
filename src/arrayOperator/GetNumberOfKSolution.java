package arrayOperator;


//统计一个数字在排序数组中出现的次数
public class GetNumberOfKSolution {

    //人家说，看到已经排序的数组，首先想到二分法
    //因为是整数数组，所以可以查找k-0.5和k+0.5应该在的位置做减法
    public int GetNumberOfK1(int[] array, int k){
        return BinarySearch(array,k+0.5)-BinarySearch(array,k-0.5);
    }

    private int BinarySearch(int [] array,double k){
        int low=0;
        int high=array.length-1;
        int mid;
        while (low<=high){
            mid=(low+high)/2;
            if(array[mid]>k){
                high=mid-1;
            }else{//k>array[mid]
                low=mid+1;
            }
        }
        return low;
    }

    //或者使用二分查找，找到第一次和最后一次出现的位置，此处省略
    public int GetNumberOfK2(int [] array, int k){
        //找到第一个出现的位置
        //找到第二个出现的位置
        //相减
        return 0;
    }
}
