package staticTest;

public class TestStatic {
    static int cnt =6;
    static int anInt = 11;

    static{
//        anInt=20;
        System.out.println("here:"+cnt+", "+anInt);
        cnt += 9;

    }
    public static void main(String[] args){
        System.out.println("cnt:"+cnt);
    }

    static void f2(){
        System.out.println("here f2");
    }
    static{
        System.out.println("hhh:"+cnt);
        cnt /=3;
        anInt=30;
    }

}
