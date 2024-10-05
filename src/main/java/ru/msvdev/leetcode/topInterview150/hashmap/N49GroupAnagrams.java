package ru.msvdev.leetcode.topInterview150.hashmap;

import java.util.*;

/**
 * 49. Group Anagrams
 * <p>
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * <p>
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Explanation:
 * There is no string in strs that can be rearranged to form "bat".
 * The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
 * The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
 * <p>
 * Example 2:
 * Input: strs = [""]
 * Output: [[""]]
 * <p>
 * Example 3:
 * Input: strs = ["a"]
 * Output: [["a"]]
 * <p>
 * Constraints:
 * -- 1 <= strs.length <= 10^4
 * -- 0 <= strs[i].length <= 100
 * -- strs[i] consists of lowercase English letters.
 */
public class N49GroupAnagrams {

    public List<List<String>> groupAnagrams1(String[] strs) {
        List<List<String>> anagramGroups = new ArrayList<>();
        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String anagram = new String(chars);

            if (anagramMap.containsKey(anagram)) {
                anagramMap.get(anagram).add(str);
            } else {
                List<String> anagramGroup = new ArrayList<>();
                anagramGroup.add(str);
                anagramGroups.add(anagramGroup);
                anagramMap.put(anagram, anagramGroup);
            }
        }

        return anagramGroups;
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String anagram = new String(chars);

            if (anagramMap.containsKey(anagram)) {
                anagramMap.get(anagram).add(str);
            } else {
                List<String> anagramGroup = new ArrayList<>();
                anagramGroup.add(str);
                anagramMap.put(anagram, anagramGroup);
            }
        }

        return new ArrayList<>(anagramMap.values());
    }


    private static final int CHAR_OFFSET = 'a';
    private static final int VECTOR_SIZE = 26;

    public List<List<String>> groupAnagrams3(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String str : strs) {
            byte[] anagramVector = new byte[VECTOR_SIZE];
            for (int i = 0; i < str.length(); i++) {
                anagramVector[(int) str.charAt(i) - CHAR_OFFSET]++;
            }
            String anagram = new String(anagramVector);
            if (anagramMap.containsKey(anagram)) {
                anagramMap.get(anagram).add(str);
            } else {
                List<String> anagramGroup = new ArrayList<>();
                anagramGroup.add(str);
                anagramMap.put(anagram, anagramGroup);
            }
        }

        return new ArrayList<>(anagramMap.values());
    }
}
