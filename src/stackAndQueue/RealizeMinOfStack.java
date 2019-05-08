package stackAndQueue;

import java.util.Stack;
//定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
//实现栈的min方法，要求时间复杂度为O(1),借用辅助栈，存储主栈中的最小值
public class RealizeMinOfStack {

    Stack<Integer> stackMain=new Stack<>();
    Stack<Integer> stackHelp=new Stack<>();

    public void push(int node) {
        stackMain.push(node);
        //如果push的新值比help栈中的值小，push进去
        if(stackHelp.empty()){
            stackHelp.push(node);
        }else if(node<=stackHelp.peek()){
            stackHelp.push(node);
        }

    }

    public void pop() {

        if(stackMain.peek().equals(stackHelp.peek())){
            stackHelp.pop();
        }
        stackMain.pop();
    }

    public int top() {
        return stackMain.peek();
    }

    public int min() {
        return stackHelp.peek();
    }
}
