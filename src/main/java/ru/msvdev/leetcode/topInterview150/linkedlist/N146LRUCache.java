package ru.msvdev.leetcode.topInterview150.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU Cache
 * <p>
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 * Implement the LRUCache class:
 * ** LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * ** int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * ** void put(int key, int value) Update the value of the key if the key exists.
 * Otherwise, add the key-value pair to the cache. If the number of keys exceeds
 * the capacity from this operation, evict the least recently used key.
 * <p>
 * The functions get and put must each run in O(1) average time complexity.
 * <p>
 * Example 1:
 * Input
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * <p>
 * Explanation
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // cache is {1=1}
 * lRUCache.put(2, 2); // cache is {1=1, 2=2}
 * lRUCache.get(1);    // return 1
 * lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
 * lRUCache.get(2);    // returns -1 (not found)
 * lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
 * lRUCache.get(1);    // return -1 (not found)
 * lRUCache.get(3);    // return 3
 * lRUCache.get(4);    // return 4
 * <p>
 * Constraints:
 * -- 1 <= capacity <= 3000
 * -- 0 <= key <= 10^4
 * -- 0 <= value <= 10^5
 * -- At most 2 * 10^5 calls will be made to get and put.
 */
public class N146LRUCache {

    public interface LRUCache {
        int get(int key);

        void put(int key, int value);
    }


    public static class HashMapDoublyLinkedListLRUCache implements LRUCache {
        private final Map<Integer, Node> map;
        private Node first;
        private Node last;

        private final int capacity;
        private int size;

        public HashMapDoublyLinkedListLRUCache(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            this.map = new HashMap<>(capacity + 1);
        }

        public int get(int key) {
            final Node node = getNode(key);
            return node != null ? node.value : -1;
        }

        public void put(int key, int value) {
            Node node = getNode(key);
            if (node != null) {
                node.value = value;
                return;
            }

            node = new Node(key, value);
            map.put(key, node);

            if (size == 0) {
                last = node;
                size++;

            } else if (size < capacity) {
                node.next = first;
                first.previous = node;
                size++;

            } else {
                map.remove(last.key);

                if (capacity > 1) {
                    last = last.previous;
                    last.next = null;
                    node.next = first;
                    first.previous = node;

                } else {
                    last = node;
                }
            }

            first = node;
        }

        private Node getNode(int key) {
            if (map.containsKey(key)) {
                final Node node = map.get(key);

                if (size > 1) {
                    if (node == last) {
                        last = node.previous;
                        last.next = null;
                        node.next = first;
                        first.previous = node;

                    } else if (node != first) {
                        node.previous.next = node.next;
                        node.next.previous = node.previous;
                        node.next = first;
                        first.previous = node;
                    }

                    first = node;
                    first.previous = null;
                }

                return node;
            }

            return null;
        }
    }

    public static class Node {
        public final int key;
        public int value;
        public Node next;
        public Node previous;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    public static class ArrayLRUCache implements LRUCache {
        private static final int MAX_KEYS = 10_001;

        private final Node[] map;
        private Node first;
        private Node last;

        private final int capacity;
        private int size;

        public ArrayLRUCache(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            this.map = new Node[MAX_KEYS];
        }

        public int get(int key) {
            final Node node = getNode(key);
            return node != null ? node.value : -1;
        }

        public void put(int key, int value) {
            Node node = getNode(key);
            if (node != null) {
                node.value = value;
                return;
            }

            node = new Node(key, value);
            map[key] = node;

            if (size == 0) {
                last = node;
                size++;

            } else if (size < capacity) {
                node.next = first;
                first.previous = node;
                size++;

            } else {
                map[last.key] = null;

                if (capacity > 1) {
                    last = last.previous;
                    last.next = null;
                    node.next = first;
                    first.previous = node;

                } else {
                    last = node;
                }
            }

            first = node;
        }

        private Node getNode(int key) {
            if (map[key] != null) {
                final Node node = map[key];

                if (size > 1) {
                    if (node == last) {
                        last = node.previous;
                        last.next = null;
                        node.next = first;
                        first.previous = node;

                    } else if (node != first) {
                        node.previous.next = node.next;
                        node.next.previous = node.previous;
                        node.next = first;
                        first.previous = node;
                    }

                    first = node;
                    first.previous = null;
                }

                return node;
            }

            return null;
        }
    }

}
