// Course: CSCI 230
//  Name: Ben Hairston
//  Homework Assignment 4
//  Problem 1.1: Leetcode 45- Group Anagrams
//  Reference: Zybooks Hash Table Chapter
// Data Structure and Algorithm: HashMap/LinkedList


import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>>answer = new LinkedList<>();

        HashMap<String, Integer> Hash = new HashMap<>();
        Arrays.sort(strs);
        char[] buffer;
        String dummy;

        for (String str : strs) {
            buffer = str.toCharArray();
            Arrays.sort(buffer);
            dummy = new String(buffer);

            if (Hash.containsKey(dummy)) {
                answer.get(Hash.get(dummy)).add(str);
            } else {
                answer.add(new LinkedList<String>());
                answer.get(answer.size() - 1).add(str);
                Hash.put(dummy, answer.size() - 1);
            }
        }
        return answer;
    }
}

