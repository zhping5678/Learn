package equals;

import java.util.Arrays;

public class TestEquals {
    public static void main(String[] args){
        testEqual();
    }
    static void testHashCode(){
        MyObject obj1=new MyObject(1);
        MyObject obj2=new MyObject(2);
        MyObject obj3=obj1;
        System.out.println("obj1-hash: "+obj1.hashCode());
        System.out.println("obj2-hash: "+obj2.hashCode());
        System.out.println("obj3-hash: "+obj3.hashCode());
    }
    static void testEqual(){
        Integer i1=128;
        Integer i2=128;
        System.out.println(i1==i2);

        Integer x1=Integer.valueOf(128);
        Integer x2=Integer.valueOf(128);
        System.out.println(x1==x2);
    }

    static void a(){
        Float  s=new  Float(0.1f);

        Float  t=new  Float(0.1f);

        Double  u=new  Double(0.1f);

        System.out.println("s:"+s);
        System.out.println("u:"+u);
        System.out.println("s==t?"+(s==t));
        System.out.println("s.equals(t)?"+(s.equals(t)));
        System.out.println("s.equals(u)?"+(s-u));
    }
    static void f(){
    }

    static void g(){
        Integer x1=new Integer(1);
        Integer x2=new Integer(1);
        System.out.println("x1==x2:"+(x1==x2));
        System.out.println("x1.equals(x2):"+(x1.equals(x2)));
    }

    void h(){
        Integer x1=new Integer(1);
        Integer x2=x1;
        System.out.println("x1==x2:"+(x1==x2));
        System.out.println("x1.equals(x2):"+(x1.equals(x2)));
    }

    void m(){
        String x1=new String("aaa");
        String x2=new String("aaa");
        System.out.println("x1==x2:"+(x1==x2));
        System.out.println("x1.equals(x2):"+(x1.equals(x2)));

    }

    static void n(){
        MyObject o=new MyObject(2);
        MyObject o1=new MyObject(1);
        MyObject o2=new MyObject(1);
        System.out.println(o.hashCode());
        System.out.println(o1.hashCode());
        System.out.println(o2.hashCode());

    }

    void k(){
        Integer[] i={1,2,3};
        Integer[] j=i;
        System.out.println(Arrays.equals(i,j));
        System.out.println(i==j);
        System.out.println(i.equals(j));

    }

}
