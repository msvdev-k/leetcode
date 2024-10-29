package ru.msvdev.leetcode.topInterview150.binarytreegeneral;

import java.util.ArrayList;
import java.util.List;

public class TreeNodeUtils {

    public static TreeNode mapToTree(Integer[] root) {
        final int n = root.length;
        if (n == 0 || root[0] == null) return null;

        List<TreeNode> parentNodes = new ArrayList<>();
        List<TreeNode> childNodes = new ArrayList<>();

        TreeNode rootTreeNode = new TreeNode(root[0]);
        parentNodes.add(rootTreeNode);
        int idx = 1;

        while (idx < n) {
            for (TreeNode parentNode : parentNodes) {
                if (root[idx] != null) {
                    TreeNode childNode = new TreeNode(root[idx]);
                    parentNode.left = childNode;
                    childNodes.add(childNode);
                }
                idx++;
                if (idx >= n) break;

                if (root[idx] != null) {
                    TreeNode childNode = new TreeNode(root[idx]);
                    parentNode.right = childNode;
                    childNodes.add(childNode);
                }
                idx++;
                if (idx >= n) break;
            }

            parentNodes = childNodes;
            childNodes = new ArrayList<>();
        }

        return rootTreeNode;
    }


    public static Integer[] mapFromTree(TreeNode root) {
        if (root == null) return new Integer[0];

        List<List<TreeNode>> nodeLayers = new ArrayList<>();

        List<TreeNode> layer = new ArrayList<>();
        layer.add(root);
        do {
            nodeLayers.add(layer);
            layer = childNodeLayer(layer);
        } while (layer != null);

        List<Integer> arrayValues = new ArrayList<>();
        for (List<TreeNode> nodeLayer : nodeLayers) {
            for (TreeNode node : nodeLayer) {
                arrayValues.add(node != null ? node.val : null);
            }
        }

        return arrayValues.toArray(new Integer[0]);
    }

    private static List<TreeNode> childNodeLayer(List<TreeNode> parentNodeLayer) {
        List<TreeNode> childNodeLayer = new ArrayList<>();
        boolean notEmpty = false;

        for (TreeNode treeNode : parentNodeLayer) {
            if (treeNode != null) {
                childNodeLayer.add(treeNode.left);
                childNodeLayer.add(treeNode.right);
                notEmpty = notEmpty || treeNode.left != null || treeNode.right != null;
            }
        }

        return notEmpty ? childNodeLayer : null;
    }
}
