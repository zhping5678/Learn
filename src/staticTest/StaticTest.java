package staticTest;
 
public class StaticTest
{
    public static void main(String[] args)
    {
        staticFunction();
    }
 
    StaticTest st = new StaticTest();
 
    static
    {
        System.out.println("1");
    }
 
    {
        System.out.println("2");
    }
 
    StaticTest()
    {
        System.out.println("3");
        System.out.println("a="+a+",b="+b);
    }
    int a=110;
    public static void staticFunction(){
        System.out.println("4");
        System.out.println("b="+b);

    }
 
//    int a=110;
    static int b =112;
}