package equals;

public class MyObject {

    private int i;

    public MyObject(int x){
        this.i=x;
    }

    @Override
    public boolean equals(Object myObject){
        MyObject myObject1=(MyObject)myObject;
        return this.i==myObject1.i;
    }
}
