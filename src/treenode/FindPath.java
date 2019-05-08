package treenode;

import java.util.ArrayList;

/*
输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 */

//注：要找一直到叶结点的路径，到中间节点不算，e.g.（10 5 3 4 7） target=15 结果为空
public class FindPath {
    private ArrayList<Integer> currentPath=new ArrayList<>();
    private ArrayList<ArrayList<Integer>> allPaths=new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target){
        if(root==null){
            return allPaths;
        }
        int rootVal=root.val;
        currentPath.add(rootVal);
        int newTarget=target-rootVal;
        if(newTarget==0 && root.left==null && root.right==null){
            allPaths.add(new ArrayList<>(currentPath));
        }
        FindPath(root.left, newTarget);
        FindPath(root.right, newTarget);
        //递归到叶子节点如果还没有找到路径，就要回退到父节点继续寻找，依次类推
        currentPath.remove(currentPath.size()-1);
        return allPaths;
    }

}
