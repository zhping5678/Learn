package serializable;

import java.io.Serializable;

public class People implements Serializable {

    private static final long serialVersionUID=1L;

    private String name;

    private String address;

    private int age;

    private double height;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString(){
        return this.name+","+this.address+","+this.age+","+this.height;
    }
}
