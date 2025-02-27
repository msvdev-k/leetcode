package ru.msvdev.leetcode.topInterview150.binarytreegeneral;

import java.util.ArrayList;
import java.util.List;

/**
 * 173. Binary Search Tree Iterator
 * <p>
 * Implement the BSTIterator class that represents an iterator over the in-order traversal of
 * a binary search tree (BST):
 * -- BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. The root of the BST is
 * given as part of the constructor. The pointer should be initialized to a non-existent number smaller
 * than any element in the BST.
 * -- boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer,
 * otherwise returns false.
 * -- int next() Moves the pointer to the right, then returns the number at the pointer.
 * <p>
 * Notice that by initializing the pointer to a non-existent smallest number, the first call to next()
 * will return the smallest element in the BST.
 * You may assume that next() calls will always be valid. That is, there will be at least a next number
 * in the in-order traversal when next() is called.
 * <p>
 * Example 1:
 * Input
 * ["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
 * [[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
 * Output
 * [null, 3, 7, true, 9, true, 15, true, 20, false]
 * <p>
 * Explanation
 * BSTIterator bSTIterator = new BSTIterator([7, 3, 15, null, null, 9, 20]);
 * bSTIterator.next();    // return 3
 * bSTIterator.next();    // return 7
 * bSTIterator.hasNext(); // return True
 * bSTIterator.next();    // return 9
 * bSTIterator.hasNext(); // return True
 * bSTIterator.next();    // return 15
 * bSTIterator.hasNext(); // return True
 * bSTIterator.next();    // return 20
 * bSTIterator.hasNext(); // return False
 * <p>
 * Constraints:
 * -- The number of nodes in the tree is in the range [1, 1e5].
 * -- 0 <= Node.val <= 1e6
 * -- At most 1e5 calls will be made to hasNext, and next.
 * <p>
 * Follow up:
 * Could you implement next() and hasNext() to run in average O(1) time and use O(h) memory,
 * where h is the height of the tree?
 */
public class N173BinarySearchTreeIterator {

    public interface BSTIterator {
        int next();

        boolean hasNext();
    }


    public static class ArrayListBSTIterator implements BSTIterator {

        private final List<Integer> inorderTraversalValues = new ArrayList<>();
        private int currentIdx = 0;

        public ArrayListBSTIterator(TreeNode root) {
            inorderTraversal(root);
        }

        private void inorderTraversal(TreeNode node) {
            if (node == null) return;
            inorderTraversal(node.left);
            inorderTraversalValues.add(node.val);
            inorderTraversal(node.right);
        }

        @Override
        public int next() {
            return inorderTraversalValues.get(currentIdx++);
        }

        @Override
        public boolean hasNext() {
            return currentIdx < inorderTraversalValues.size();
        }
    }


}
