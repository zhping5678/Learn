package treenode;

import listnode.ListNode;

import java.util.ArrayList;
import java.util.Stack;

//请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
public class PrintZSolution {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        if(pRoot==null) return result;
        ArrayList<TreeNode> queue=new ArrayList<>();
        queue.add(pRoot);
        boolean left=true;
        while (!queue.isEmpty()){
            int begin=0, end=queue.size();
            ArrayList<Integer> line=new ArrayList<>();
            while (begin<end){
                TreeNode node=queue.get(begin);
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
                if (left){
                    line.add(node.val);
                }else{
                    TreeNode nodeEnd=queue.get(end-begin-1);
                    line.add(nodeEnd.val);
                }
                begin++;
            }
            while (end>0){
                queue.remove(0);
                end--;
            }
            left=!left;
            result.add(line);
        }
        return result;

    }

    //使用栈
    public ArrayList<ArrayList<Integer>> Print2(TreeNode pRoot){
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        if(pRoot==null) return result;
        boolean odd=true;
        Stack<TreeNode> oddLine=new Stack<>();
        Stack<TreeNode> evenLine=new Stack<>();
        oddLine.push(pRoot);
        while (!oddLine.empty() || !evenLine.empty()){
            ArrayList<Integer> tmp=new ArrayList<>();
            if(odd){
                while (!oddLine.empty()){
                    TreeNode node=oddLine.pop();
                    if(node!=null){
                        tmp.add(node.val);
                        evenLine.push(node.left);
                        evenLine.push(node.right);
                    }
                }
            }else{
                while (!evenLine.empty()){
                    TreeNode node=evenLine.pop();
                    if(node!=null){
                        tmp.add(node.val);
                        oddLine.push(node.right);
                        oddLine.push(node.left);
                    }
                }
            }
            if(!tmp.isEmpty()){
                result.add(tmp);
            }
            odd=!odd;
        }
        return result;
    }

}
