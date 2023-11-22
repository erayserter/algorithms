public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    class Pair {
        int height;
        boolean balanced;

        Pair(int height, boolean balanced) {
            this.height = height;
            this.balanced = balanced;
        }
    }

    public Pair isBalancedWithHeight(TreeNode root) {
        if (root ==  null)
            return new Pair(0, true);

        Pair left = isBalancedWithHeight(root.left);
        Pair right = isBalancedWithHeight(root.right);

        if (left.balanced && right.balanced && Math.abs(left.height - right.height) <= 1)
            return new Pair(Math.max(left.height, right.height) + 1, true);

        return new Pair(-1, false);
    }

    public boolean isBalanced(TreeNode root) {
        return isBalancedWithHeight(root).balanced;
    }
}