package strOperator;

/*
请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
*/
public class IsNumericSolution {
    //正则表达式
    public  boolean isNumeric(char[] str){
        String s=String.valueOf(str);
        return s.matches("[\\+\\-]?\\d*(\\.\\d+)?([eE][\\+\\-]?\\d+)?");
    }

    private int index=0;
    //from 剑指Offer
    public boolean isNumeric2(char[] str){
        if(str==null||str.length==0) return false;
        boolean flag=scanInteger(str);
        if(index<str.length && str[index]=='.'){
            index++;
            flag=scanUnsignedInteger(str)||flag;
        }
        if(index<str.length && (str[index]=='e'||str[index]=='E')){
            index++;
            flag=flag&&scanInteger(str);
        }
        return flag && (index==str.length);
    }

    private boolean scanInteger(char[] str){
        if(index<str.length && (str[index]=='+' || str[index]=='-')) index++;
        return scanUnsignedInteger(str);
    }

    private boolean scanUnsignedInteger(char[] str){
        int start=index;
        while (start<str.length && str[index]>='0' && str[index]<='9') index++;
        return start<index;
    }
}
