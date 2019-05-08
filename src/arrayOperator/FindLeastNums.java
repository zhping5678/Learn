package arrayOperator;

import java.util.ArrayList;
import java.util.Arrays;

//输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
public class FindLeastNums {

    //堆排序算法，把最小的k个数放到一个最大堆中，比较第k+1个数和堆顶的大小，如果小于堆顶，放入，并调整
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k){
        return null;
    }
    //无脑做法
    public ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k) {
        ArrayList<Integer> result=new ArrayList<>();
        if(input==null||input.length==0||k>input.length){
            return result ;
        }
        Arrays.sort(input);

        for(int i=0;i<k;i++){
            result.add(input[i]);
        }
        return result;
    }
}
