package serializable;

import java.io.*;

public class TestSerializable{
    public static void main(String[] args){
        read();
//        write();
    }

    private static void read(){
        People people=null;
        try {
            FileInputStream inputStream=new FileInputStream(new File("E://test.ser"));
            ObjectInputStream objectInputStream=new ObjectInputStream(inputStream);
            people=(People)objectInputStream.readObject();
            objectInputStream.close();
            inputStream.close();
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }finally {
            System.out.println(people.toString());
        }
    }

    private static void write(){
        People people=new People();
        people.setName("zz");
        people.setAddress("南京");
        people.setAge(18);
        people.setHeight(170.5);

        try{
            FileOutputStream stream=new FileOutputStream(new File("E://test.ser"));
            ObjectOutputStream outputStream=new ObjectOutputStream(stream);
            outputStream.writeObject(people);
            outputStream.close();
            stream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}