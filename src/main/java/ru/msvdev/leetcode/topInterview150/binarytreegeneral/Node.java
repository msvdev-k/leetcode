package ru.msvdev.leetcode.topInterview150.binarytreegeneral;

public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    Node() {
    }

    Node(int val) {
        this.val = val;
    }

    Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
