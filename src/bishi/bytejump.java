package bishi;

import java.util.ArrayList;
import java.util.Scanner;

public class bytejump {

    public static void calculateK(){
        Scanner in = new Scanner(System.in);
        int peopleNum=in.nextInt();
        int[] k_arr=new int[peopleNum];
        for(int i=0;i<peopleNum;i++){
            k_arr[i]=in.nextInt();
        }

        int q=in.nextInt();
        int[] k_count=new int[q];
        int l,r,k;
        for(int j=0;j<q;j++){
            l=in.nextInt();
            r=in.nextInt();
            k=in.nextInt();
            for(int m=l-1;m<r;m++){
                if(k_arr[m]==k){
                    k_count[j]++;
                }
            }
        }
        in.close();
        for(int i:k_count){
            System.out.println(i);
        }
    }

    static int BinarySearchMax(int[] data,int target){
        int left=0;
        int right=data.length-1;
        while (left<=right){
            int mid=(left+right)/2;
            if(data[mid]<=target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        if(data[right]==target){
            return right;
        }
        return -1;
    }

    public static void main(String[] args){
        int[] arr={0,1,2,3,4,5,5,5,6};
        System.out.print(BinarySearchMax(arr,4));
    }
}
