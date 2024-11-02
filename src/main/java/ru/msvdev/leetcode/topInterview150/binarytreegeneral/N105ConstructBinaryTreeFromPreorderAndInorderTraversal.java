package ru.msvdev.leetcode.topInterview150.binarytreegeneral;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * <p>
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of
 * a binary tree and inorder is the inorder traversal of the same tree, construct and return
 * the binary tree.
 * <p>
 * Example 1:
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * <p>
 * Example 2:
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 * <p>
 * Constraints:
 * -- 1 <= preorder.length <= 3000
 * -- inorder.length == preorder.length
 * -- -3000 <= preorder[i], inorder[i] <= 3000
 * -- preorder and inorder consist of unique values.
 * -- Each value of inorder also appears in preorder.
 * -- preorder is guaranteed to be the preorder traversal of the tree.
 * -- inorder is guaranteed to be the inorder traversal of the tree.
 */
public class N105ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        return (preorder.length == 1) ?
                new TreeNode(preorder[0]) :
                buildTree1(
                        preorder, 0,
                        inorder, 0,
                        preorder.length
                );
    }

    private TreeNode buildTree1(
            int[] preorder, int startPreorderIdx,
            int[] inorder, int startInorderIdx,
            int length) {

        if (length == 1) return new TreeNode(preorder[startPreorderIdx]);
        if (length <= 0) return null;

        int nodeVal = preorder[startPreorderIdx];
        int nodeIdxInInorder = startInorderIdx;
        while (inorder[nodeIdxInInorder] != nodeVal) nodeIdxInInorder++;

        final TreeNode node = new TreeNode(nodeVal);
        node.left = buildTree1(
                preorder, startPreorderIdx + 1,
                inorder, startInorderIdx,
                nodeIdxInInorder - startInorderIdx
        );
        nodeIdxInInorder++;
        node.right = buildTree1(
                preorder, startPreorderIdx + nodeIdxInInorder - startInorderIdx,
                inorder, nodeIdxInInorder,
                startInorderIdx + length - nodeIdxInInorder
        );

        return node;
    }


    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        return (preorder.length == 1) ?
                new TreeNode(preorder[0]) :
                buildTree2(preorder, inorder, Integer.MAX_VALUE);
    }

    int preorderIdx = 0;
    int inorderIdx = 0;

    private TreeNode buildTree2(int[] preorder, int[] inorder, int parentNodeVal) {
        if (preorderIdx >= preorder.length) return null;

        if (parentNodeVal == inorder[inorderIdx]) {
            inorderIdx++;
            return null;
        }

        TreeNode node = new TreeNode(preorder[preorderIdx]);
        preorderIdx++;
        node.left = buildTree2(preorder, inorder, node.val);
        node.right = buildTree2(preorder, inorder, parentNodeVal);

        return node;
    }


}
