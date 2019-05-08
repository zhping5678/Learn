public class InnerClass {

    private int a=1;
    private static int b=2;
    private static final int c=3;


    public static void main(String[] args){

    }

    public void f1(){

    }
    public static void f2(){}


    class Inner{
        int in_a=a;
        int in_b=b;
        int in_c=c;

    }
}
