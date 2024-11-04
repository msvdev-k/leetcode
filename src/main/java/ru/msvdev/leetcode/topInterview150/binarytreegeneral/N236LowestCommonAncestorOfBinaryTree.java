package ru.msvdev.leetcode.topInterview150.binarytreegeneral;

/**
 * 236. Lowest Common Ancestor of a Binary Tree
 * <p>
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * According to the definition of LCA on Wikipedia: "The lowest common ancestor is defined between
 * two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow
 * a node to be a descendant of itself)."
 * <p>
 * Example 1:
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * <p>
 * Example 2:
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to
 * the LCA definition.
 * <p>
 * Example 3:
 * Input: root = [1,2], p = 1, q = 2
 * Output: 1
 * <p>
 * Constraints:
 * -- The number of nodes in the tree is in the range [2, 1e5].
 * -- -1e9 <= Node.val <= 1e9
 * -- All Node.val are unique.
 * -- p != q
 * -- p and q will exist in the tree.
 */
public class N236LowestCommonAncestorOfBinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.equals(p) || root.equals(q)) return root;

        TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);

        if (leftLCA == null) {
            return rightLCA;
        } else if (rightLCA == null) {
            return leftLCA;
        }

        return root;
    }


}
