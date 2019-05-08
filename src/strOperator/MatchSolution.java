package strOperator;

/*
请实现一个函数用来匹配包括'.'和'*'的正则表达式。
模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
在本题中，匹配是指字符串的所有字符匹配整个模式。
例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
*/
public class MatchSolution {
    public static void main(String[] args){
        char [] str="aaa".toCharArray();
        char[] pattern="ab*a".toCharArray();
        System.out.println(match(str, pattern));

    }

    //递归比较好
    public static boolean match(char[] str, char[] pattern){
        if (str==null||pattern==null) return false;
        return match(str,0,pattern,0);
    }

    private static boolean match(char[] str, int i, char[] pattern, int j){
        if (j==pattern.length){
            return i==str.length;
        }
        if(j+1<pattern.length && pattern[j+1]=='*'){//后一位是‘*’
            if(i!=str.length &&(str[i]==pattern[j] || pattern[j]=='.')){
                return match(str,i+1,pattern,j)||match(str, i, pattern, j+2);
            }else{//不匹配,即*前字母出现0次
                return match(str,i,pattern,j+2);
            }
        }else{//后面不是‘*’
            if(i!=str.length &&(str[i]==pattern[j] || pattern[j]=='.'))
                return match(str,i+1,pattern,j+1);
            return false;
        }
    }
}
