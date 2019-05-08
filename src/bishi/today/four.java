package bishi.today;

import java.util.Scanner;

public class four {
    public static void main(String[] agrs){
        int n, k;
        Scanner in=new Scanner(System.in);
        n=in.nextInt();
        k=in.nextInt();
        int[] num=new int[n+1];
        for(int i = 1; i <= n; i++){
            num[i]=in.nextInt();
        }
        in.close();
        int l = 1, r = 1, zr = 0, ans = 0;
        while(r <= n){
            while(r <= n && zr <= k){
                if(num[r]!=0){
                    if(zr == k) break;
                    else ++zr;
                }
                ++r;
            }
            if(r-l > ans)
            {
                ans = r-l;
            }
            while(l <= n && (num[l]!=0)) ++l;
            --zr; ++l;
        }
        System.out.println(ans);
    }
}
