package basic.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * Group Anagrams
Given an array of strings strs, group the anagrams together. You can return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */
public class Group_Anagrams {
	public static void main(String args[]) {
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> result = groupAnagrams(strs);
		result.forEach(t -> System.out.println(t + " "));
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<>();
		HashMap<String, List<String>> map = new HashMap<>();

		for (String str : strs) {
			char[] chArr = str.toCharArray();
			Arrays.sort(chArr);
			String key = new String(chArr);

			if (map.containsKey(key)) {
				map.get(key).add(str);
			} else {
				List<String> strList = new ArrayList<>();
				strList.add(str);
				map.put(key, strList);
			}
		}
		result.addAll(map.values());
		return result;
	}

}
