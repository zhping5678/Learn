package treenode;

import java.util.ArrayList;

//计算二叉树的最大深度
public class TreeDepth {


    //递归写法
    int maxDepth=0;
    public int TreeDepth_Solution1(TreeNode root){
        if(root==null){
            return 0;
        }
        calculateDepth(root,1);
        return maxDepth;
    }
    private void calculateDepth(TreeNode node,int depth){
        if(node==null){
            return;
        }
        if(node.left==null&&node.right==null){
            if(depth>maxDepth){
                maxDepth=depth;
            }
        }
        calculateDepth(node.left,depth+1);
        calculateDepth(node.right,depth+1);
    }

    //层次遍历，非递归写法
    public int TreeDepth_Solution2(TreeNode root){
        if(root==null){
            return 0;
        }
        int depth=0;
        ArrayList<TreeNode> nodes=new ArrayList<>();
        nodes.add(root);
        while (!nodes.isEmpty()){
            int low=0;
            int high=nodes.size();
            while (low<high){
                TreeNode node=nodes.remove(0);
                if (node.left!=null) nodes.add(node.left);
                if (node.right!=null) nodes.add(node.right);
                low++;
            }
            depth++;
        }
        return depth;
    }
}
