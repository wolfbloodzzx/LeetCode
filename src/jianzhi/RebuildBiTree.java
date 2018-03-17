package jianzhi;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return val+"";
    }
    public String prePrint(){
        String s = this.toString();
        if(left != null)
            s += left.prePrint();
        if(right != null)
            s += right.prePrint();
        return s;
    }

    public String midPrint(){
        String s = "";
        if(left != null)
            s += left.midPrint();
        s += this.toString();
        if(right != null)
            s += right.midPrint();
        return s;
    }
}

public class RebuildBiTree {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return rebuildTree(pre, in, 0, pre.length-1, 0, in.length-1);
    }
    private TreeNode rebuildTree(int[] pre, int[] in,
                                 int start_pre, int end_pre,
                                 int start_in, int end_in){
        if(start_pre >= pre.length || start_in >= in.length){
            return null;
        }
        if(end_pre - start_pre == 1){
            return new TreeNode(pre[start_pre]);
        }
        TreeNode root = new TreeNode(pre[start_pre]);
        for(int i =start_in;i<=end_in;i++){
            if(in[i] == pre[start_pre]){
                int lps = start_pre + 1, lpe = start_pre + i - start_in,
                        lms = start_in, lme = i-1;
                if(lps > end_pre || lpe>end_pre || lms>end_in || lme > end_in)
                    root.left = null;
                else
                    root.left = rebuildTree(pre, in,
                            lps, lpe, lms, lme);

                root.right = rebuildTree(pre, in,
                        start_pre + 1 + i - start_in, end_pre,
                        i + 1, end_in);
                break;
            }
        }
        return root;
    }
    public static void main(String[] args){
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode tn = new RebuildBiTree().reConstructBinaryTree(pre, in);
        System.out.println(tn.prePrint());
        System.out.println(tn.midPrint());
    }
}
