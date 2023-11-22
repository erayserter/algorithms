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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;
        if (preorder.length == 1)
            return new TreeNode(preorder[0]);

        TreeNode head = new TreeNode(preorder[0]);
        Set<Integer> set = new HashSet<>();

        int i;
        for (i = 0; i < inorder.length; i++) {
            if (inorder[i] == head.val)
                break;

            set.add(inorder[i]);
        }

        int j;
        for (j = 1; j < preorder.length && set.contains(preorder[j]); j++);

        int[] leftInorder = new int[i];
        int[] leftPreorder = new int[i];
        int[] rightInorder = new int[inorder.length - 1 - i];
        int[] rightPreorder = new int[inorder.length - 1 - i];

        for (int k = 0; k < i; k++) {
            leftInorder[k] = inorder[k];
            leftPreorder[k] = preorder[k + 1];
        }

        for (int k = 0; k < rightInorder.length; k++) {
            rightInorder[k] = inorder[i + 1 + k];
            rightPreorder[k] = preorder[i + 1 + k];
        }

        TreeNode left = buildTree(leftPreorder, leftInorder);
        TreeNode right = buildTree(rightPreorder, rightInorder);

        head.left = left;
        head.right = right;

        return head;
    }
}