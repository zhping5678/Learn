package arrayOperator.slide_windows;

import java.util.ArrayDeque;
import java.util.ArrayList;


/*给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
{[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
{2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
*/
public class MaxInWindows {

    public static void main(String[] args){
        int[] num={2,3,4,2,6,2,5,1};
        int size=3;
        ArrayList<Integer> maxs=maxInWindows(num, size);
        for (int i:maxs){
            System.out.print(i+" ");
        }
    }

    public static ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> res = new ArrayList<>();
        if(size == 0) return res;
        int begin;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < num.length; i++){
            begin = i - size + 1;//滑动窗口的首地址

            //对于新来的元素K，从后向前一次删掉比k小的，因为不可能再成为滑动窗口的最大值
            while (!q.isEmpty() && num[i]>=num[q.peekLast()]){
                q.pollLast();
            }
            //判断队首元素是否过期
            if (!q.isEmpty() && begin>q.peekFirst()){
                q.pollFirst();
            }
            q.add(i);
            //当滑动窗口首地址大于0时才加入结果队列
            if(begin >= 0)
                res.add(num[q.peekFirst()]);
        }
        return res;
    }
}
