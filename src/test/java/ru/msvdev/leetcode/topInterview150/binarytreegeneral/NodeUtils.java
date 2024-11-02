package ru.msvdev.leetcode.topInterview150.binarytreegeneral;

import java.util.ArrayList;
import java.util.List;

public class NodeUtils {

    public static Node treeNodeMapToNodeTree(Integer[] root) {
        final int n = root.length;
        if (n == 0 || root[0] == null) return null;

        List<Node> parentNodes = new ArrayList<>();
        List<Node> childNodes = new ArrayList<>();

        Node rootNode = new Node(root[0]);
        parentNodes.add(rootNode);
        int idx = 1;

        while (idx < n) {
            for (Node parentNode : parentNodes) {
                if (root[idx] != null) {
                    Node childNode = new Node(root[idx]);
                    parentNode.left = childNode;
                    childNodes.add(childNode);
                }
                idx++;
                if (idx >= n) break;

                if (root[idx] != null) {
                    Node childNode = new Node(root[idx]);
                    parentNode.right = childNode;
                    childNodes.add(childNode);
                }
                idx++;
                if (idx >= n) break;
            }

            parentNodes = childNodes;
            childNodes = new ArrayList<>();
        }

        return rootNode;
    }


    public static Integer[] mapFromTree(Node root) {
        if (root == null) return new Integer[0];

        List<List<Node>> nodeLayers = new ArrayList<>();

        List<Node> layer = new ArrayList<>();
        layer.add(root);
        layer.add(null);
        do {
            nodeLayers.add(layer);
            layer = childNodeLayer(layer);
        } while (layer != null);

        List<Integer> arrayValues = new ArrayList<>();
        for (List<Node> nodeLayer : nodeLayers) {
            for (Node node : nodeLayer) {
                arrayValues.add(node != null ? node.val : null);
            }
        }

        return arrayValues.toArray(new Integer[0]);
    }

    private static List<Node> childNodeLayer(List<Node> parentNodeLayer) {
        List<Node> childNodeLayer = new ArrayList<>();
        boolean notEmpty = false;

        for (Node treeNode : parentNodeLayer) {
            if (treeNode != null) {
                if (treeNode.left != null) childNodeLayer.add(treeNode.left);
                if (treeNode.right != null) childNodeLayer.add(treeNode.right);
                notEmpty = notEmpty || treeNode.left != null || treeNode.right != null;
            }
        }

        childNodeLayer.add(null);
        return notEmpty ? childNodeLayer : null;
    }
}
