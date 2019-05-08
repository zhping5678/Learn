package logic;

//给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
public class MultipleSolution {

    //先求左边，再求右边
    public int[] multiply(int[] A) {
        if(A==null){
            return null;
        }
        int len=A.length;
        int[] B=new int[len];

        B[0]=1;
        for(int i=1;i<len;i++){
            B[i] = B[i-1]*A[i-1];
        }

        int tmp=1;
        for(int j=len-2;j>=0;j--){
            tmp*=A[j+1];
            B[j]*=tmp;
        }
        return B;
    }

    //动态规划，先把左边和右边的都存起来
    public int[] multiply2(int[] A){
        if(A==null){
            return null;
        }
        int len=A.length;
        int[] before=new int[len];
        int[] after=new int[len];
        int[] B=new int[len];
        before[0]=after[0]=1;
        for(int i=1;i<len;i++){
            before[i]=before[i-1]*A[i-1];
            after[i]=after[i-1]*A[len-i];
        }
        for(int i=0;i<len;i++){
            B[i]=before[i]*after[len-i-1];
        }
        return B;
    }
}
