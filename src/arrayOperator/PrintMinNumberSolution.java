package arrayOperator;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*
 *输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class PrintMinNumberSolution {

    public static void main(String [] args){
        int[] nums={3334,3,3333332};
        System.out.println(PrintMinNumber1(nums));
    }

    public static String PrintMinNumber1(int [] numbers){
        ArrayList<String> nums=new ArrayList<>();
        for(int i=0;i<numbers.length;i++){
            nums.add(String.valueOf(numbers[i]));
        }
        Collections.sort(nums, new Comparator<String>() {
            @Override
            public int compare( String str1, String str2) {
                String s1=str1+""+str2;
                String s2=str2+""+str1;
                return s1.compareTo(s2);
            }
        });
        StringBuilder stringBuffer=new StringBuilder();
        for(String s:nums){
            stringBuffer.append(s);
        }
        return stringBuffer.toString();
    }
    public static String PrintMinNumber(int[] numbers){
        String[] nums=new String[numbers.length];
        for(int i=0;i<numbers.length;i++){
            nums[i]=String.valueOf(numbers[i]);
        }
        int index;
        for(int i=0;i<nums.length;i++){
            index=i;
            for(int j=i+1;j<nums.length;j++){
                if(compare(nums[j],nums[index])<0){
                    index=j;
                }
            }
            String temp=nums[i];
            nums[i]=nums[index];
            nums[index]=temp;

        }
        StringBuilder stringBuffer=new StringBuilder();
        for(String s:nums){
            stringBuffer.append(s);
        }
        return stringBuffer.toString();
    }

    //str1<str2 返回-1
    public static int compare(String str1,String str2){
        //这里nb
        String s1=str1+""+str2;
        String s2=str2+""+str1;
        return s1.compareTo(s2);
    }


}
