package ru.msvdev.leetcode.topInterview150.binarytreegeneral;

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 * <p>
 * Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree
 * and postorder is the postorder traversal of the same tree, construct and return the binary tree.
 * <p>
 * Example 1:
 * Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * Output: [3,9,20,null,null,15,7]
 * <p>
 * Example 2:
 * Input: inorder = [-1], postorder = [-1]
 * Output: [-1]
 * <p>
 * Constraints:
 * -- 1 <= inorder.length <= 3000
 * -- postorder.length == inorder.length
 * -- -3000 <= inorder[i], postorder[i] <= 3000
 * -- inorder and postorder consist of unique values.
 * -- Each value of postorder also appears in inorder.
 * -- inorder is guaranteed to be the inorder traversal of the tree.
 * -- postorder is guaranteed to be the postorder traversal of the tree.
 */
public class N106ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 1) return new TreeNode(postorder[0]);

        int lastIdx = postorder.length - 1;
        BuilderState state = new BuilderState(lastIdx, lastIdx);

        return buildTree(inorder, postorder, Integer.MAX_VALUE, state);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int parentNodeVal, BuilderState state) {
        if (state.postorderIdx < 0) return null;

        if (parentNodeVal == inorder[state.inorderIdx]) {
            state.inorderIdx--;
            return null;
        }

        TreeNode node = new TreeNode(postorder[state.postorderIdx]);
        state.postorderIdx--;
        node.right = buildTree(inorder, postorder, node.val, state);
        node.left = buildTree(inorder, postorder, parentNodeVal, state);

        return node;
    }

    private static final class BuilderState {
        int inorderIdx;
        int postorderIdx;

        public BuilderState(int inorderIdx, int postorderIdx) {
            this.inorderIdx = inorderIdx;
            this.postorderIdx = postorderIdx;
        }
    }
}
