package arrayOperator;

import java.util.ArrayList;
import java.util.Collections;

//输入一个字符串,按字典序打印出该字符串中字符的所有排列。
// 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
public class CombinateChars {

    private ArrayList<String> results=new ArrayList<>();


    public ArrayList<String> Permutation(String str){
        if(str==null||str.length()==0){
            return results;
        }
        if(str.length()==1){
            results.add(str);
            return results;
        }
        PermutationHelper(str.toCharArray(),0);
        Collections.sort(results);
        return results;
    }

    /**
     * 排列组合
     * @param chars 要排列的字符串
     * @param i 固定的是那个字符
     */
    private void PermutationHelper(char[] chars, int i){
        if(i==chars.length-1){//
            String str=String.valueOf(chars);
            if(!results.contains(str)){
                results.add(str);
            }
        } else{
            for(int j=i;j<chars.length;j++){
                swap(chars, i ,j);
                PermutationHelper(chars,i+1);
                swap(chars,i,j);

            }
        }
    }

    private void swap(char[] chars,int i,int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
