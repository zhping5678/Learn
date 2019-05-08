package arrayOperator;

/*在一个长度为n的数组里的所有数字都在0到n-1的范围内。
数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2.*/
public class DuplicateSolution {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false

    //注意点：数组中的数字有范围

    //想法一：借用额外的数组空间判断是否重复
    public static boolean duplicate(int[] numbers, int length, int [] duplication) {
        if(numbers==null) return false;
        boolean[] exist=new boolean[length];
        for(int i:numbers){
            if(exist[i]){
                duplication[0]=i;
                return true;
            }
            exist[i]=true;
        }
        return false;
    }

    //想法二：改变了原来的数组
    //第一次出现，把对应坐标位置的数值+length，再次访问时
    public static boolean duplicate2(int[] numbers, int length, int[] duplication){

        if(numbers==null){
            return false;
        }
        for(int i=0;i!=length;++i){
            int index=numbers[i]%length;
            if(numbers[index]>=length){
                duplication[0]=index;
                return true;
            }
            numbers[index]+=length;
        }
        return false;
    }

    //想法三(from 剑指Offer)
    //把当前序列当成是一个下标和下标对应值是相同的数组；
    //遍历数组，判断当前位的值和下标是否相等：
    // 2.1. 若相等，则遍历下一位；
    // 2.2. 若不等，则将当前位置i上的元素和a[i]位置上的元素比较：若它们相等，则成功！若不等，则将它们两交换。
    //  换完之后a[i]位置上的值和它的下标是对应的，但i位置上的元素和下标并不一定对应；
    //  重复2.2的操作，直到当前位置i的值也为i，将i向后移一位，再重复2.
    public static boolean duplicate3(int[] numbers, int length, int[] duplication){
        if(numbers==null) return false;
        for(int i:numbers){
            if (i<0 || i>=length) return false;
        }
        for(int i=0;i<length;i++){
            while (i!=numbers[i]){
                if(numbers[i]==numbers[numbers[i]]){
                    duplication[0]=numbers[i];
                    return true;
                }
                int temp=numbers[i];
                numbers[i]=numbers[temp];
                numbers[temp]=temp;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int [] nums={4,3,2,1,1,5,6};
        int len=7;
        int[] dup=new int[1];
        System.out.println(duplicate3(nums, len, dup));
        System.out.println(dup[0]);
    }
}
