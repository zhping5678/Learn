package algorithm;

import java.util.Scanner;

/*
假设你能重返过去，现在让你回到2015年，你能选择一支股票进行投资，你拥有这支股票未来n天的价格走势图，为了躲避证监会的监控，你只有一次买入卖出机会。
现在要求实现一个程序计算哪天买入哪天卖出能获得最大收益。
输入
第一行为天数n
接下来n行 为数组的n个整数元素，代表第n天该股票的价格
输出
输出为b，s      #代表第b天买入，第s天卖出
天数从0开始
如果没有适合的买入卖出输出-1,-1
同样收益时越晚买入越早卖出更符合需要
样例输入
5
2
1
4
5
3
样例输出
1, 3
*/
public class Profit {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] prices=new int[n];
        for(int i=0;i<n;i++){
            prices[i]=in.nextInt();
        }
        for(int i=0;i<n;i++){
            System.out.print(prices[i]+" ");
        }
        search(prices);
    }

    static void maxProfit(int[] prices){

    }

    static void  search(int[] num){
        int min=num[0]; //初始化买入最低价
        int buyIn=min;  //买入最低价
        int buyOut=0;   //卖出最高价
        int max_profit=-1; //最大利润
        int profit=0;      //当前利润
        for(int i=1;i<num.length;i++){
            profit=num[i]-min;
            if(profit>max_profit)
            {
                max_profit=profit;
                buyIn=min;
                buyOut=num[i];
            }
            if(num[i]<min)
            {
                min=num[i];
            }
        }
        System.out.println(buyIn+","+buyOut);
    }
}
