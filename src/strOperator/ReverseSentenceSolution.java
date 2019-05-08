package strOperator;

/*
牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。
后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
*/
public class ReverseSentenceSolution {
    public static void main(String[] args){
        String s="student. a am I";
//        String s=" ";
//        System.out.println(" ".split(" ").length);
//        System.out.println("".split(" ").length);
        System.out.println(ReverseSentence2(s));
    }


    //剑指Offer两次翻转
    public static String ReverseSentence2(String str){
        if(str==null||str.trim().equals("")||str.length()==1){
            return str;
        }
        char[] chars=str.toCharArray();
        reverse(chars, 0, chars.length-1);
        int begin=0, end=0;
        while (begin<chars.length){
            if(chars[begin]==' '){
                begin++; end++;
            }
            else if(chars[end]==' '){// It's time to reverse the word between begin and end.
                reverse(chars, begin, end-1);
                begin=end;
            }
            else if(end==chars.length-1){
                reverse(chars, begin, end);
                begin = ++end;
            }
            else {
                end++;
            }
        }
        return String.valueOf(chars);
    }

    private static void reverse(char[] chars, int begin, int end){
        while (begin<end){
            char tmp=chars[begin];
            chars[begin]=chars[end];
            chars[end]=tmp;
            begin++;
            end--;
        }
    }

    //我的直接想法
    public static String ReverseSentence(String str) {
        if(str==null||str.length()<=1||str.trim().equals("")){
            return str;
        }
        String[] strs=str.split(" ");
        StringBuilder builder=new StringBuilder();
        for(int i=strs.length-1;i>0;i--){
            builder.append(strs[i]);
            builder.append(" ");
        }
        builder.append(strs[0]);
        return builder.toString();
    }
}
