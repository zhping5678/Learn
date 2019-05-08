package recursion;

public class frogJumpFloor {

    public static void main(String[] args){

    }

    //青蛙跳台阶,一次可以跳1阶,也可以跳2阶,若要跳上n级台阶,共有多少种跳法,顺序不同算两种
    static int jumpFloor(int total){
        if(total==1||total==2){
            return total;
        }
        return jumpFloor(total-1)+jumpFloor(total-2);
    }

    //一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
    //思路：分析可得f(n)=2*f(n-1)
    static int jumpFloorII(int total){
        if(total==1||total==2){
            return total;
        }
        return 2*jumpFloorII(total);
    }

}
