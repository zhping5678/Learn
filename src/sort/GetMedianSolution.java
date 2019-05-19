package sort;


import java.util.Comparator;
import java.util.PriorityQueue;

/*
* 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
* 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
* 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
*/
public class GetMedianSolution {
    private int count;
    private PriorityQueue<Integer> minHeap=new PriorityQueue<>();//小顶堆,存放比较大的那一半数

    //大顶堆，存放比较小的那堆树
    private PriorityQueue<Integer> maxHeap =new PriorityQueue<>(11, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });

    /*
    Java的PriorityQueue 是从JDK1.5开始提供的新的数据结构接口，默认内部是自然排序，结果为小顶堆，也可以自定义排序器，
    比如下面反转比较，完成大顶堆。
    思路：
    为了保证插入新数据和取中位数的时间效率都高效，这里使用大顶堆+小顶堆的容器，并且满足：
        1、两个堆中的数据数目差不能超过1，这样可以使中位数只会出现在两个堆的交接处；
        2、大顶堆的所有数据都小于小顶堆，这样就满足了排序要求.
        3、大数按小顶堆放，小数按大顶堆放
    */
    public void Insert(Integer num) {
        count++;
        if((count&1)==0){//如果是第偶数个元素
            if (!maxHeap.isEmpty() && num< maxHeap.peek()){
                //找到小数中的最大值，比较。决定该数字应该插入到哪个堆中
                maxHeap.offer(num);
                num= maxHeap.poll();//最大的数
            }
            minHeap.offer(num);
        }else{//第奇数个元素
            if(!minHeap.isEmpty() && num>minHeap.peek()){
                minHeap.offer(num);
                num=minHeap.poll();
            }
            maxHeap.offer(num);
        }
    }

    public Double GetMedian() {
        if ((count&1)==0){
            return (maxHeap.peek()+minHeap.peek())*1.0/2;
        }else{
            return maxHeap.peek()*1.0;
        }
    }
}
