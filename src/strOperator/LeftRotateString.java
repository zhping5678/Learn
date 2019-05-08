package strOperator;

public class LeftRotateString {


    public static void main(String[] args){
        System.out.println(LeftRotateString_Solution("1234567",3));
        System.out.println(LeftRotateString_Solution("1234567",7));
        System.out.println(LeftRotateString_Solution("1234567",10));
    }
    public static String LeftRotateString_Solution(String str,int n){
        if(str==null||str.length()<=1||str.length()==n){
            return str;
        }
        if(str.length()>n){
            return str.substring(n)+str.substring(0,n);
        }

        return LeftRotateString_Solution(str, n-str.length());

    }
}
