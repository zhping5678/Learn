package treenode;

//序列化和反序列化二叉树
public class SerializeSolution {

    //前序遍历，空节点用#
    String Serialize(TreeNode root) {
        StringBuilder builder=new StringBuilder();
        if (root==null){
            builder.append("# ");
            return builder.toString();
        }
        builder.append(root.val+" ");
        builder.append(Serialize(root.left));
        builder.append(Serialize(root.right));
        return builder.toString();
    }

    private int index=-1;
    TreeNode Deserialize(String str) {
        index++;
        TreeNode node=null;
        String[] vals=str.split(" ");
        if(!vals[index].equals("#")){
            node=new TreeNode( Integer.valueOf(vals[index]));
            node.left=Deserialize(str);
            node.right=Deserialize(str);
        }
        return node;
    }
}
