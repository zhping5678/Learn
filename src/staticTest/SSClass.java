package staticTest;

class SSClass
{
    static
    {
        System.out.println("SSClass");
    }
    public SSClass(){
        System.out.println("init SSClass");
    }
}

class SuperClass extends SSClass
{
    static
    {
        System.out.println("SuperClass init!");
    }
 
    public static int value = 123;
 
    public SuperClass()
    {
        System.out.println("init SuperClass");
    }
}

class SubClass extends SuperClass
{
    static
    {
        System.out.println("SubClass init");
    }
 
    static int a;
 
    public SubClass()
    {
        System.out.println("init SubClass");
        value=321;
    }
}
class NotInitialization
{
    public static void main(String[] args)
    {

        SubClass sub=new SubClass();

        System.out.println(sub.value);
//        System.out.println(SubClass.value);
//        System.out.println(ConstClass.HELLOWORLD);
        System.out.println(new ConstClass().HELLOWORLD);
    }
}

class ConstClass
{
    static
    {
        System.out.println("ConstClass init!");
    }
    public static  final String HELLOWORLD = "hello world";
}
