package stackAndQueue;

public class Main {

    public static void main(String[] args){
//        StackAndQueue stackAndQueue=new StackAndQueue();
//        stackAndQueue.push(1);
//        stackAndQueue.push(2);
//        stackAndQueue.push(3);
//        System.out.println(stackAndQueue.pop());
        isPopOrder isPopOrder=new isPopOrder();
        System.out.println(isPopOrder.IsPopOrder(new int[]{1,2,3,4,5},new int[]{4,5,3,2,1}));

    }
}
