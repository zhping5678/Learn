package strOperator;

//将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。
//数值为0或者字符串不是一个合法的数值则返回0。
public class StrToIntSolution {
    public static void main(String[] args){
        System.out.println(StrToInt("2147483648"));
    }
    public static int StrToInt(String str) {
        if (str==null || str.length()==0) return 0;
        int len=str.length();
        char first=str.charAt(0);
        boolean negative=false;
        int index=0;
        if(first<'0'){
            index++;
            if(first=='-') negative=true;
            else if (first!='+') return 0;//不是数字也不是，不是+、-号
            if(len==1) return 0;//只有正负号不是数字
        }
        int result=0;
        while (index<len){
            int current=str.charAt(index)-48;
            if(current<0 || current>9) return 0;
            result=result*10+current;
            index++;
        }
        return negative? -result:result;
    }
}
