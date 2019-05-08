package arrayOperator;

public class ReplaceSpace {

    public String replaceSpace(StringBuffer str) {
        StringBuffer bf=new StringBuffer();

        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!=' '){
                bf.append(str.charAt(i));
            }else{
                bf.append("%20");
            }
        }
        return bf.toString();
    }
}
