
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Invert_Binary_Tree_226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;
        else{
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = invertTree(right);
            root.right = invertTree(left);
            return root;
        }
    }
    public void printTree(TreeNode root){
        print(root);
        System.out.println();
    }

    private void print(TreeNode root){
        if(root == null)
            return;
        System.out.print(root.val);
        print(root.left);
        print(root.right);
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        Invert_Binary_Tree_226 solution = new Invert_Binary_Tree_226();
        solution.printTree(root);
        solution.printTree(solution.invertTree(root));
    }
}
