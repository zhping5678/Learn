package extend;


class Vehicle{
    private final void run(){
        System.out.println("Vehicle run");
    }
}

class Car extends Vehicle{
    private final void run(){
        System.out.println("Car run");
    }

    public static void main(String[] args){
        new Car().run();
    }
}