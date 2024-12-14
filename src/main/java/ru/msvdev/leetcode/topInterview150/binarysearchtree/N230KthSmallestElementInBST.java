package ru.msvdev.leetcode.topInterview150.binarysearchtree;

import ru.msvdev.leetcode.topInterview150.binarytreegeneral.TreeNode;

import java.util.Map;
import java.util.TreeMap;

/**
 * 230. Kth Smallest Element in a BST
 * <p>
 * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed)
 * of all the values of the nodes in the tree.
 * <p>
 * Example 1:
 * Input: root = [3,1,4,null,2], k = 1
 * Output: 1
 * <p>
 * Example 2:
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * Output: 3
 * <p>
 * Constraints:
 * -- The number of nodes in the tree is n.
 * -- 1 <= k <= n <= 1e4
 * -- 0 <= Node.val <= 1e4
 * <p>
 * Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find
 * the kth smallest frequently, how would you optimize?
 */
public class N230KthSmallestElementInBST {


    public int kthSmallest2(TreeNode root, int k) {
        currentK = k;
        currentVal = Integer.MIN_VALUE;
        kthSmallestReq(root);

        return currentVal;
    }

    private int currentK;
    private int currentVal;

    private void kthSmallestReq(TreeNode node) {
        if (node == null || currentK < 1) return;

        kthSmallestReq(node.left);

        if (currentK > 0) {
            currentK--;
            currentVal = node.val;
        }

        kthSmallestReq(node.right);
    }


    private final Map<Integer, Counter> values = new TreeMap<>();

    public int kthSmallest1(TreeNode root, int k) {
        sortNodeNumbers(root);

        for (Map.Entry<Integer, Counter> entry : values.entrySet()) {
            k -= entry.getValue().value();
            if (k <= 0) {
                return entry.getKey();
            }
        }

        return 0;
    }

    private void sortNodeNumbers(TreeNode node) {
        if (node == null) return;

        final Integer val = node.val;
        if (values.containsKey(val)) {
            values.get(val).increment();

        } else {
            Counter counter = new Counter(1);
            values.put(val, counter);
        }

        sortNodeNumbers(node.left);
        sortNodeNumbers(node.right);
    }


    static class Counter {
        private int c;

        public Counter(int c) {
            this.c = c;
        }

        public void increment() {
            c++;
        }

        public int value() {
            return c;
        }
    }
}
