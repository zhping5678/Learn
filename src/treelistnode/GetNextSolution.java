package treelistnode;

//给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
public class GetNextSolution {

    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if ( pNode==null ) return null;
        //如果是根节点
        //如果有右子树，找到右子树的中序第一个节点
        if(pNode.right!=null){
            pNode=pNode.right;
            while(pNode.left!=null)
                pNode=pNode.left;
            return pNode;
        }
        //如果没有右子树，找根节点右子树中序遍历的第一个节点，应该就是根的右节点
        while (pNode.next!=null){
            TreeLinkNode root=pNode.next;
            if (root.left==pNode) return root;
            pNode=root;
        }
        return null;
    }

    //前提是根节点不为空
    private TreeLinkNode GetFirst(TreeLinkNode root){
        //如果没有左子树，中序第一个节点就是根节点
        if (root.left==null) return root;
        //如果有左子树，第一个是左子树的中序第一个点
        return GetFirst(root.left);
    }
}
