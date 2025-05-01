/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    StringBuilder sb;
    public String serialize(TreeNode root) {
        this.sb =new StringBuilder();
        serializeHelper(root);
        String data = sb.toString();
        // System.out.print(data);
        return data;
    }
    private void serializeHelper(TreeNode root){
        //base
        if(root == null){
            sb.append("#");
            sb.append(" ");
            return;
        }
        //logic
        serializeHelper(root.left);
        serializeHelper(root.right);
        sb.append(root.val);
        sb.append(" ");
    }

    int idx;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String [] strArr=data.split(" ");
        this.idx = strArr.length - 1;
        if(strArr[idx].equals("#")) return null;
        // System.out.print(Arrays.asList(strArr));
        return deserializeHelper(strArr);
    }
  
    private TreeNode deserializeHelper(String [] strArr){
        // base
        if(strArr[idx].equals("#")){
            idx--;
            return null;
        }
        int rootVal = Integer.parseInt(strArr[idx]);
        idx--;
        TreeNode root= new TreeNode(rootVal);
        //right
        root.right = deserializeHelper(strArr);
        //left
        root.left = deserializeHelper(strArr);
        return root;

    }
}
