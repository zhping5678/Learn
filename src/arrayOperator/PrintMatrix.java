package arrayOperator;

import java.util.ArrayList;

/*
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
*/
public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix){
        ArrayList<Integer> result=new ArrayList<Integer>();
        int width=matrix[0].length;
        int height=matrix.length;
        int left=0, right=width-1, top=0, bottom=height-1;//上下左右打印的范围
        while ((left<=right) && (top<=bottom)){
            //从左到右
            for(int i=left;i<=right;i++){
                result.add(matrix[top][i]);
            }
            //从上到下
            for(int j=top+1;j<=bottom;j++){
                result.add(matrix[j][right]);
            }
            //从右到左
            if(top!=bottom){
                for(int k=right-1;k>=left;k--){
                    result.add(matrix[bottom][k]);
                }
            }

            //从下到上
            if(left!=right){
                for(int n=bottom-1;n>top;n--){
                    result.add(matrix[n][left]);
                }
            }
            top++;left++;bottom--;right--;
        }
        return result;
    }
}