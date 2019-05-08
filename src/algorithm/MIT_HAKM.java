package algorithm;

//用来计算一个整数的二进制表示中有多少个1
public class MIT_HAKM {

    public static void main(String[] args){
        System.out.println(bitcount(1));
        System.out.println(bitcount(2));
        System.out.println(bitcount(3));
        System.out.println(bitcount(4));
        System.out.println(bitcount(15));
        System.out.println(bitcount(9));
    }

    static int bitcount( int n)
    {
        int tmp;

        tmp = n
                - ((n >> 1) & 033333333333)
                - ((n >> 2) & 011111111111);

        tmp = (tmp + (tmp >> 3)) & 030707070707;

        return (tmp%63);
    }
}
