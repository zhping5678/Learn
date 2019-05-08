package treenode;

import java.util.ArrayList;

//按行打印树的结构
public class PrintByLine {

    //使用队列，层次访问
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        if(pRoot==null){
            return result;
        }
        ArrayList<TreeNode> queue=new ArrayList<>();

        queue.add(pRoot);
        while (queue.size()>0){
            int low=0;
            int high=queue.size();
            ArrayList<Integer> line=new ArrayList<>();
            while (low<high){
                TreeNode rootNode=queue.remove(0);
                line.add(rootNode.val);
                if(rootNode.left!=null){
                    queue.add(rootNode.left);
                }
                if(rootNode.right!=null){
                    queue.add(rootNode.right);
                }
                low++;
            }
            result.add(line);
        }
        return result;
    }

    //递归
    public ArrayList<ArrayList<Integer>> print(TreeNode pRoot){
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        if(pRoot==null){
            return result;
        }
        depth(pRoot,1,result);
        return result;
    }
    private void depth(TreeNode root, int level, ArrayList<ArrayList<Integer>> result){
        if(root!=null){
            if(result.size()<level){//这层还没遍历
                ArrayList<Integer> newline=new ArrayList<>();
                newline.add(root.val);
                result.add(newline);
            }else{
                ArrayList<Integer> thisLine=result.get(level-1);
                thisLine.add(root.val);
            }
            if(root.left!=null){
                depth(root.left,level+1,result);
            }
            if(root.right!=null){
                depth(root.right,level+1,result);
            }
        }
    }
}
