package shiftOperator;

public class Power {

    public static void main(String[] args){

    }

    //思路：x^7=x^(0111)=x^4*x^2*x^1=x^0100*x^0010*x^0001
    //判断位是否是1,同时基数一直以x^2、x^4、x^8变化,因为每一位都是2的幂,如果是1,需要在result上乘上current
    public static double power(double base, int exponent){
        if (base==0){
            return 0;
        }
        if(exponent==0){
            return 1;
        }
        int e=Math.abs(exponent);
        double re=1;
        double current=base;
        while(e!=0){
            if((exponent&1)==1){
                re*=current;
            }
            current*=current;
            e=e>>1;
        }
        return exponent>0?re:(1/re);
    }
}
