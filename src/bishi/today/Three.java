package bishi.today;

import java.util.Scanner;

public class Three {

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int d=in.nextInt();
        int[] location=new int[n];
        for(int i=0;i<n;i++){
            location[i]=in.nextInt();
        }
        in.close();

        int result=0;
        int i=0,j=n-1;
        int one, three, tmpMul=0;
        while (i+1<j){
            one=location[i];
            three=location[j];
            if (three-one<=d) {
                result=result+(j-i-1);
                result=result%99997867;
            }else {
                i++;
            }
        }

        /*int one,two,three;
        int result=0;
        for(int i=0;i<n;i++){
            one=location[i];
            for(int j=i+1;j<n;j++){
                two=location[j];
                if(two-one<=d){
                    for(int k=j+1;k<n;k++){
                        three=location[k];
                        if(three-one<=d){
                            result=(result+1)%99997867;
                        }else{
                            break;
                        }
                    }
                }else{
                    break;
                }
            }
        }
        */
        System.out.println(result);
    }
}
