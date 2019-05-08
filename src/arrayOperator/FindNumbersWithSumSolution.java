package arrayOperator;

import java.util.ArrayList;

//输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
public class FindNumbersWithSumSolution {
    public static void main(String[] args){
        int[] arr={0,1,4,5,6,7,10,14};
        for(int i: FindNumbersWithSum(arr,11)){
            System.out.print(i+" ");
        }
    }

    //不知道可不可以用滑动窗口的想法,事实证明是可以的
    public static ArrayList<Integer> FindNumbersWithSum(int[] array, int num){
        ArrayList<Integer> result=new ArrayList<>();
        if(array==null||array.length<2){
            return result;
        }
        int i=0,j=array.length-1;
        int a_i, a_j, tmpMul=0;
        while (i<j){
            a_i=array[i];
            a_j=array[j];
            if (a_i+a_j==num) {
                if(result.isEmpty()){
                   result.add(a_i);
                   result.add(a_j);
                   tmpMul=a_i*a_j;
                }else if(a_i*a_j<tmpMul){
                        result.set(0,a_i);
                        result.set(1,a_j);
                        tmpMul=a_i*a_j;
                }
                i++;
            }else if(a_i+a_j<num){//小于
                i++;
            }else{//大于
                j--;
            }
        }

        return result;
    }
}
