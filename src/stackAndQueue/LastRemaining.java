package stackAndQueue;


import java.util.LinkedList;

/*每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。
HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。
然后,他随机指定一个数m,让编号为0的小朋友开始报数。每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,
并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,
可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)*/

//约瑟夫环问题
public class LastRemaining {

    //使用java中的链表
    public int LastRemaining_Solution1(int n, int m) {
        LinkedList<Integer> list=new LinkedList<>();
        for(int i=0;i<n;i++){
            list.add(i);
        }
        int removeIndex=0;
        while (list.size()>1){
            removeIndex = (removeIndex+m-1)%list.size();
            list.remove(removeIndex);
        }
        return list.size()==1? list.get(0): -1;
    }

    //使用数组模拟环
    public int LastRemaining_Solution2(int n, int m){
        if(n<1 || m<1){
            return -1;
        }
        int[] array=new int[n];
        int index=-1,count=n,step=0;
        while (count>0){
            index++;
            if(index>=n) index=0;
            if(array[index]==-1) continue;
            step++;
            if(step==m){
                array[index]=-1;
                step=0;
                count--;
            }
        }
        return index;
    }
}
