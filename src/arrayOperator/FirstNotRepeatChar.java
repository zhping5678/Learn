package arrayOperator;

import java.util.LinkedHashMap;

//在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
public class FirstNotRepeatChar {

    public int FirstNotRepeatintChar(String str){
        if(str==null||str.length()==0){
            return -1;
        }
        LinkedHashMap<Character,Integer> chars=new LinkedHashMap<>();
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(chars.containsKey(c)){
                int time=chars.get(c);
                chars.put(c,++time);
            }else{
                chars.put(c,1);
            }
        }
        for(int j=0;j<str.length();j++){
            if(chars.get(str.charAt(j))==1){
                return j;
            }
        }
        return -1;
    }
}
