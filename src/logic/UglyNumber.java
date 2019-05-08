package logic;

import java.util.ArrayList;

//把只包含质因子2、3和5的数称作丑数（Ugly Number）。
//例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
public class UglyNumber {

    //动态规划
    public static int GetUglyNumber_Solution(int index) {
        if(index<7){
            return index;
        }
        ArrayList<Integer> results=new ArrayList<>();
        results.add(1);
        int t2=0,t3=0,t5=0;
        int next=0;
        while (results.size()<index){
            next=Math.min( results.get(t2)*2, Math.min(results.get(t3)*3, results.get(t5)*5));
            if(results.get(t2)*2==next){
                t2++;
            }
            if(results.get(t3)*3==next){
                t3++;
            }
            if(results.get(t5)*5==next){
                t5++;
            }
            results.add(next);
        }
        return next;
    }

    public static void main(String[] args){
        System.out.println(GetUglyNumber_Solution(10));
    }
}
