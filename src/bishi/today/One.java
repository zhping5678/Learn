package bishi.today;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class One {

    private static int[] records=new int[10];//第几岁的牛有几只

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        System.out.println(calculate(n));
    }

    private static int calculate(int n){
        if(n==1||n==2){
            return 1;
        }
        if(n==3){
            return 2;
        }
        //n>=4
        records[0]=1;
        records[2]=1;
        int count=4;
        int newBorn;
        while (count<=n){
            newBorn=getNewBorn();
            updateAge(newBorn);
            count++;
        }
        int result=0;
        for(int i=0;i<10;i++){
            result+=records[i];
        }
        return result;
    }

    private static void updateAge(int newBorn){
        for(int i=9;i>0;i--){
            records[i]=records[i-1];
        }
        records[0]=newBorn;
    }

    private static int getNewBorn(){
        int sum=0;
        for(int i=1;i<6;i++){
            sum+=records[i];
        }
        return sum;
    }
}
