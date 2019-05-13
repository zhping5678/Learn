import equals.MyObject;

import java.util.HashMap;
import java.util.Map;

public class Main{
    public static void main(String [] args){
        Map<Integer,Integer> map2=new HashMap<>();
        MyObject myObject1=new MyObject(1);
        Map<MyObject,Integer> map=new HashMap<>();
        map.put(myObject1,1);
        MyObject myObject2=myObject1;
//        System.out.println(myObject1.hashCode()==myObject2.hashCode());
        map.put(myObject2,2);
//        System.out.println(map.size());

        Integer i= new Integer(20);
        Integer j= new Integer(20);
        System.out.println(i.hashCode()+" "+j.hashCode());
    }
}