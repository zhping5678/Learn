package arrayOperator;


/*LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,
并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。
LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，否则就输出false。
为了方便起见,你可以认为大小王是0。*/
public class IsContinuousSolution {

    public static void main(String[] args){
        int[] nums={3,3,6,0,0};
        System.out.println(isContinuous(nums));
    }
    //想法：用max和min分别记录最大和最小值，满足以下要求
    //1.数组长度==5
    //2.除0外没有重复数字
    //3.max-min<5
    public static boolean isContinuous(int[] numbers){
        if(numbers==null||numbers.length<5){
            return false;
        }
        int min=14,max=-1;
        int[] count=new int[14];//用来判断是否有重复的数字
        for(int i:numbers){
            if (i==0){
                continue;
            }
            count[i]++;
            if(count[i]>1){
                return false;
            }
            if(i>max){
                max=i;
            }
            if(i<min){
                min=i;
            }
        }
        return (max-min<5);

    }

    //我最开始的想法有瑕疵，没有考虑是不是有重复的牌，虽然能通过测试用例，但是是错的
    public static boolean isContinuousError(int [] numbers){
        if(numbers==null||numbers.length<5){
            return false;
        }
        int count_0=0;
        int min=20, max=-1;
        for(int i=0;i<5;i++){
            if(numbers[i]!=0 && numbers[i]>max){
                max=numbers[i];
            }
            if(numbers[i]!=0 && numbers[i]<min){
                min=numbers[i];
            }
            if(numbers[i]==0){
                count_0++;
            }
        }
        System.out.println("max: "+max+", min: "+min );
        if(count_0==4){
            return true;
        }
        if(max-min>=5 || max-min<=2){
            return false;
        }
        return true;
    }
}
