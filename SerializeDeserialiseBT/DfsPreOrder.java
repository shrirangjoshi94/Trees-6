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
        System.out.print(data);
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
        sb.append(root.val);
        sb.append(" ");
        serializeHelper(root.left);
        serializeHelper(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String [] strArr=data.split(" ");
        if(strArr[0].equals("#")) return null;
        return deserializeHelper(strArr);
    }
    int idx;
    private TreeNode deserializeHelper(String [] strArr){
        // base
        if(strArr[idx].equals("#")){
            idx++;
            return null;
        }
        int rootVal = Integer.parseInt(strArr[idx]);
        idx++;
        TreeNode root= new TreeNode(rootVal);
        //left
        root.left = deserializeHelper(strArr);
        //right
        root.right = deserializeHelper(strArr);
        return root;

    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
