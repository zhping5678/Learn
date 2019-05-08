package staticTest;

public class TestStaticMethod {

    public static void main(String[] args){
        System.out.println("主静态方法");
        f1();
        TestStatic.f2();
    }

    static void f1(){
        System.out.println("here f1");
    }

}