package arrayOperator;


/*
求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。*/
public class NumberOf1Between1AndN {

    public static void main(String[] a){
        System.out.println(calculate(10));
        System.out.println(calculate(11));
        System.out.println(calculate(312));System.out.println(calculate(1232));


    }

    //人家的巧妙算法——归纳
    public static int NumberOf1Between1AndN_Solution(int n){
        return 0;
    }
    //我的粗暴算法
    public static int NumberOf1Between1AndN_Solution2(int n){
        int res=0;
        for(int i=1;i<=n;i++){
            res+=calculate(i);
        }
        return res;
    }

    private static int calculate(int i){
        if(i==1){
            return 1;
        }
        if(i<10){
            return 0;
        }
        int bit=0;
        int num=i;
        while (num!=0){
            if(num%10 == 1){
                bit++;
            }
            num/=10;
        }
        return bit;
    }
}
