package arrayOperator;

public class FindNumsAppearOnce {

    /**
     * 一个数组，除了其中两个数字，其他都出现两次，找出只出现一次的两个数
     * @param array 整数数组
     * @param num1 长度为1，存放结果中的第一个数
     * @param num2 长度为1，存放结果中的第二个数
     */
    //想法：异或法
    /*
    要知道，做异或运算，1^0=0^1=1, 0^0,1^1=0
    把所有数字异或在一起，出现两次的数字异或后为0，最后得到的结果为只出现一次的两个数字的异或值
    */
    public void FindNumsAppearOnce1(int[] array, int num1[], int num2[]){
        if(array==null||array.length<=1){
            return;
        }
        int xorSum=array[0];
        for(int i=1;i< array.length;i++){
            xorSum^=array[i];
        }
        System.out.println(xorSum);
        //接下来的问题是怎么把xorSum还原成两个单一的数字
        //得到xorSum中的最低的1的位置
        //根据最低位的1，把原数组分为两部分，一部分该位是0，一部分该位是1，相同的两两异或抵消
        int index=getFirstOneBit(xorSum);
        for(int num:array){
            if( (num&(1<<index)) ==0){
                num1[0]^=num;
            }else{
                num2[0]^=num;
            }
        }
    }
    private int getFirstOneBit(int num){
        int index=0;
        while ((num&1)==0){
            num=num>>1;
            index++;
        }
        return index;
    }

    /**
     * 数组中只有一个数字出现一次，其他数字都出现两次
     * @param array 输入数字
     * @return 只出现一次的数字
     */
    public int FindNumAppearOnce2(int[] array){
        if(array==null||array.length==0){
            return 0;
        }
        int res=array[0];
        for(int i=1;i<array.length;i++){
            res^=array[i];
        }
        return res;
    }

    /**
     * 数组中只有一个数字出现一次，其他数字都出现三次
     * @param array 输入数组
     * @return 只出现一次的数字
     */
    //申请了32位数组,然后把原数组中的每一个数字,展开成二进制,哪一位为1,那么bits[]那一位就+1.
    //最终,判断bit中每一位是否是3的倍数(或者是0),如果是,那么我们要找的数字在这一位肯定为0,反之为1
    public int FindNumAppearOnce3(int [] array){
        if(array==null||array.length==0){
            return 0;
        }
        if(array.length==1){
            return array[0];
        }
        int[] bits=new int[32];
        for(int i=0;i<array.length;i++){
            for(int j=0;j<32;j++){//把数组的每一位变成2进制
                bits[j]=bits[j]+((array[i]>>>j)&1);
            }
        }
        int res=0;
        for(int k=0;k<32;k++){
            if(bits[k]%3!=0){
                res=res|(1<<k);
            }
        }
        return res;
    }
}
