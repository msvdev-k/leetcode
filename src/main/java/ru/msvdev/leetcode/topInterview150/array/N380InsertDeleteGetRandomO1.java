package ru.msvdev.leetcode.topInterview150.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class N380InsertDeleteGetRandomO1 {

    public static class RandomizedSet {

        private final HashMap<Integer, Integer> map;
        private final List<Integer> list;
        private final Random rnd;

        public RandomizedSet() {
            map = new HashMap<>();
            list = new ArrayList<>();
            rnd = new Random();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }

            map.put(val, list.size());
            list.add(val);

            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }

            int lastInList = list.get(list.size() - 1);
            if (val != lastInList) {
                int removeIdx = map.get(val);
                list.set(removeIdx, lastInList);
                map.put(lastInList, removeIdx);
            }

            map.remove(val);
            list.remove(list.size() - 1);

            return true;
        }

        public int getRandom() {
            return list.get(rnd.nextInt(list.size()));
        }
    }
}
