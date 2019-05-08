package stackAndQueue;

import java.util.Stack;

//用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型
//想法：stack1入栈,出栈时stack2若为空,把stack1的内容倒叙插入,不为空,直接出栈
public class StackAndQueue {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        int t;
        if(stack2.empty()){
            while (!stack1.empty()){
                t=stack1.pop();
                stack2.push(t);
            }
        }
        return stack2.pop();
    }
}
