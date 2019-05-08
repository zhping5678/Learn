package shiftOperator;

public class CountNumOf1 {

    public static void main(String[] args){

    }

    //高效做法:利用n&(n-1)使最右的1变为0:e.g.7&6=(0111)&(0110)=0110:减1相当于把第一个1和他的右边取反e.g.7=0111 6=0110 5=0101
    public static int NumberOfOne2(int n){
        int count=0;
        while(n!=0){
            //循环几次说明其中有几个1
            count++;
            n=(n-1)&n;
        }
        return count;
    }
    //一般做法，1不断左移，做与运算
    public static int NumberOfOne1(int n) {
        int count=0;
        int bit=1;
        while(bit!=0){
            if((n&bit)!=0){
                count++;
            }
            bit=bit<<1;
        }
        return count;
    }
}
